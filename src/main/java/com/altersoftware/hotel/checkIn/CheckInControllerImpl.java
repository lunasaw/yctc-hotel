package com.altersoftware.hotel.checkIn;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.constant.ConstantHolder;
import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.entity.CheckInWithDO;
import com.altersoftware.hotel.entity.RecordDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;
import com.altersoftware.hotel.service.CheckInWithService;
import com.altersoftware.hotel.service.CustomerService;
import com.altersoftware.hotel.service.RecordService;
import com.altersoftware.hotel.service.UserIService;
import com.altersoftware.hotel.util.Base64Utils;
import com.altersoftware.hotel.util.CheckIn;
import com.altersoftware.hotel.util.FileUtilsAlter;
import com.altersoftware.hotel.util.UploadUtils;
import com.altersoftware.hotel.vo.BaseVO;
import com.altersoftware.hotel.vo.CheckWithVO;

/**
 * @author Iszychen@win10
 * @date 2020/2/22 17:44
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/checkin")
public class CheckInControllerImpl implements CheckInController {

    @Resource
    private UserIService       userIService;

    @Resource
    private CustomerService    customerService;

    @Resource
    private RecordService      recordService;

    @Resource
    private CheckInWithService checkInWithService;

    @Override
    public ResultDO<UserDO> checkFaceToken(String number) {
        // 参数校验
        if (StringUtils.isEmpty(number) == true) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<UserDO> userDOByNumber = userIService.getUserDOByNumber(number);
        if (userDOByNumber.isSuccess() == false) {
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
        if (userDOByNumber.getModule().getFaceToken() == null) {
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, userDOByNumber.getModule());
        }
        return new ResultDO<>(true, ResultCode.SUCCESS,
            ResultCode.MSG_SUCCESS, userDOByNumber.getModule());
    }

    @Override
    @PostMapping("idcard")
    public ResultDO<UserDO> checkIdCard(@RequestBody BaseVO base64VO) {
        try {
            String path = ResourceUtils.getURL("classpath:static/").getPath();

            // 先检查是预定用户 还是陪同用户
            ResultDO<UserDO> userDOById = userIService.getUserDOById(base64VO.getCustomerId());
            if (userDOById.getModule() != null) {
                UserDO userDO = null;
                // 将拍摄 或者 上传 的身份证照片解码
                if (Base64Utils.GenerateImage(base64VO.getId64(), path + base64VO.getCustomerId() + ".jpg") == false) {
                    return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                        ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
                }

                // 将图片上传到服务器
                System.out.println("开始上传服务器");
                File file = new File(path + base64VO.getCustomerId() + ".jpg");
                byte[] bytes = FileUtilsAlter.fileToByte(file);
                UploadUtils.uploadFile(bytes, ConstantHolder.FILE_UPLOAD, base64VO.getCustomerId() + ".jpg");
                System.out.println("上传完成");
                userDO = userDOById.getModule();
                String s = ConstantHolder.FILE_UPLOAD + base64VO.getCustomerId() + ".jpg";
                userDO.setFaceToken(s);
                customerService.updateUserDO(userDO);
                // OCR识别身份信息
                String s1 = CheckIn.IDCardOCR(base64VO.getCustomerId());
                String[] split = s1.split(",");
                // 将识别的信息与预设信息比较
                System.out.println("开始ocr识别");
                if (split[0].equals(userDO.getName()) == false || split[1].equals(userDO.getIdCardNumber()) == false) {
                    return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                        ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
                }
                System.out.println("结束ocr识别");
                System.out.println("开始云端比较");

                // 将识别到的信息与云端比较
                if (CheckIn.idEnsure(userDO.getName(), userDO.getIdCardNumber()) == false) {
                    return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                        ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
                }
                System.out.println("完成云端比较");

                return new ResultDO<>(true, ResultCode.SUCCESS,
                    ResultCode.MSG_SUCCESS, userDO);
            } else {
                ResultDO<CheckInWithDO> checkInWithPhone = checkInWithService.getCheckInWithPhone(base64VO.getPhone());

                System.out.println("查住户");

                // 用户不是同住用户
                if (!checkInWithPhone.isSuccess()) {
                    return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                        ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
                }
                System.out.println("解码开始");

                // 将拍摄 或者 上传 的身份证照片解码
                if (!Base64Utils.GenerateImage(base64VO.getId64(), path + base64VO.getPhone() + ".jpg")) {
                    return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                        ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
                }
                System.out.println("解码完成");
                // 将图片上传到服务器
                System.out.println("开始上传服务器");
                File file = new File(path + base64VO.getPhone() + ".jpg");
                byte[] bytes = FileUtilsAlter.fileToByte(file);
                UploadUtils.uploadFile(bytes, ConstantHolder.FILE_UPLOAD, base64VO.getPhone() + ".jpg");
                System.out.println("上传完成");

                CheckInWithDO module = checkInWithPhone.getModule();
                String s = ConstantHolder.FILE_UPLOAD + base64VO.getPhone() + ".jpg";
                module.setIdPiture(s);
                // OCR识别身份信息
                System.out.println("开始ocr识别");
                String s1 = CheckIn.IDCardOCR(Long.parseLong(base64VO.getPhone()));
                System.out.println("结束ocr识别");

                String[] split = s1.split(",");

                // 将识别的信息与预设信息比较
                if (!split[0].equals(module.getName())) {
                    return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
                        ResultCode.MSG_PARAMETER_INVALID, null);
                }
                // // 将识别到的信息与云端比较
                System.out.println("开始云端比较");

                if (CheckIn.idEnsure(module.getName(), module.getIdCard()) == false) {
                    return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                        ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
                }
                System.out.println("完成云端比较");

                module.setIdCard(split[1]);
                checkInWithService.updateCheckInWithDO(module);
                return new ResultDO<>(true, ResultCode.SUCCESS,
                    ResultCode.MSG_SUCCESS);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    @Override
    public ResultDO<List<RecordDO>> nowToLive(long customerId) {
        // 参数校验
        if (customerId <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<List<RecordDO>> listResultDO = recordService.showRecordByCustomer(customerId);
        if (listResultDO.isSuccess() == false) {
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
        return new ResultDO<>(true, ResultCode.SUCCESS,
            ResultCode.MSG_SUCCESS, listResultDO.getModule());
    }

    @Override
    public ResultDO<Void> checkFace(String face64, long customerId) {
        try {
            String path = ResourceUtils.getURL("classpath:static/").getPath();
            // 将拍摄 或者 上传 的身份证照片解码
            if (Base64Utils.GenerateImage(face64, path + "tmp.jpg") == false) {
                return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                    ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
            }
            // // 获取身份证图片 和本地图片地址
            // String s1 = path + customerId + ".jpg";
            // String s = ConstantHolder.FILE_UPLOAD + customerId + ".jpg";
            // 虹软sdk对比
            if (CheckIn.checkIn(customerId) == false) {
                return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                    ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
            }
            return new ResultDO<>(true, ResultCode.SUCCESS,
                ResultCode.MSG_SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    @Override
    public ResultDO<Void> checkWith(List<CheckWithVO> list) {
        CheckInWithDO checkInWithDO = new CheckInWithDO();
        ResultDO<Void> deleteLoseEfficacy = checkInWithService.deleteLoseEfficacy();
        if (deleteLoseEfficacy.isSuccess() == false) {
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
        for (int i = 0; i < list.size(); i++) {
            CheckWithVO checkWithVO = list.get(i);
            checkInWithDO.setPhone(checkWithVO.getPhone());
            checkInWithDO.setName(checkWithVO.getName());
            checkInWithDO.setCustomerId(checkWithVO.getCustomerId());
            checkInWithDO.setRoomNumber(checkWithVO.getRoomNumber());
            ResultDO<Void> insert = checkInWithService.insert(checkInWithDO);
            if (insert.isSuccess() == false) {
                return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                    ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
            }
        }
        return new ResultDO<>(true, ResultCode.SUCCESS,
            ResultCode.MSG_SUCCESS);
    }

    @Override
    public ResultDO<RecordDO> checkWithPhone(String phone) {
        try {
            ResultDO<CheckInWithDO> checkInWithPhone = checkInWithService.getCheckInWithPhone(phone);
            if (!checkInWithPhone.isSuccess()) {
                return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            }
            // 预定用户填写的房间号 和他预定的正在使用房间号相等
            ResultDO<List<RecordDO>> listResultDO =
                recordService.showRecordByCustomer(checkInWithPhone.getModule().getCustomerId());
            List<RecordDO> module = listResultDO.getModule();
            for (int i = 0; i < module.size(); i++) {
                if (module.get(i).getRoomNumber() == checkInWithPhone.getModule().getRoomNumber()) {
                    return new ResultDO<>(true, ResultCode.SUCCESS,
                        ResultCode.MSG_SUCCESS, module.get(i));
                }
            }
            // 操作成功 但是没有房间给他选
            return new ResultDO<>(true, ResultCode.SUCCESS,
                ResultCode.MSG_SUCCESS, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }
}
