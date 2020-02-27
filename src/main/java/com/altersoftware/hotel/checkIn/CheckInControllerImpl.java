package com.altersoftware.hotel.checkIn;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.altersoftware.hotel.util.*;
import com.altersoftware.hotel.vo.BaseVO;
import com.altersoftware.hotel.vo.CheckWithVO;
import com.altersoftware.hotel.vo.FaceVO;

import cn.hutool.core.util.StrUtil;

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
    @RequestMapping("id-check")
    public ResultDO<UserDO> checkFaceToken(long userId) {
        // 参数校验 预定用户用于检查是否有facetoken
        if (userId <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<UserDO> userDOById = userIService.getUserDOById(userId);
        if (userDOById.isSuccess() == false) {
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
        if (userDOById.getModule().getFaceToken() == null) {
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, userDOById.getModule());
        }
        return new ResultDO<>(true, ResultCode.SUCCESS,
            ResultCode.MSG_SUCCESS, userDOById.getModule());
    }

    @Override
    @PostMapping("check-phone")
    public ResultDO<RecordDO> checkWithPhone(String phone) {
        // 参数校验 同住用户用于检查是否有订单存在
        if (StringUtils.isEmpty(phone) == true) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
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

    @Override
    @PostMapping("check-hadcustomer")
    public ResultDO<UserDO> checkCustomerWithPhone(String phone) {
        // 删除失效请求
        ResultDO<Void> deleteLoseEfficacy = checkInWithService.deleteLoseEfficacy();
        if (deleteLoseEfficacy.isSuccess() == false) {
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
        ResultDO<UserDO> userDOByPhone = userIService.getUserDOByPhone(phone);
        if (userDOByPhone.isSuccess() == false) {
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
        return new ResultDO<>(true, ResultCode.SUCCESS,
            ResultCode.MSG_SUCCESS, userDOByPhone.getModule());
    }

    @Override
    @PostMapping("idCard-check")
    public ResultDO<UserDO> checkIdCard(@RequestBody BaseVO base64VO) {
        try {

            String path = ResourceUtils.getURL("classpath:static/").getPath();

            // 先检查是预定用户 还是陪同用户
            ResultDO<UserDO> userDOById = userIService.getUserDOById(base64VO.getCustomerId());
            if (userDOById.getModule() != null) {
                String s = ConstantHolder.FILE_UPLOAD + base64VO.getCustomerId() + ".jpg";
                // 判断是否为前端上传
                System.out.println("判断开始");
                FileUtilsAlter.downloadHttpUrl(ConstantHolder.FILE_UPLOAD + base64VO.getCustomerId() + ".jpg", path,
                    "hadbody.jpg");
                File files = new File(path + "hadbody.jpg");
                boolean exists = files.exists();
                // 获取用户数据
                UserDO userDO = userDOById.getModule();
                // 未在前端上传
                if (exists == true) {

                    System.out.println("开始ocr识别");
                    // OCR识别身份信息
                    String s1 = CheckIn.IDCardOCR(base64VO.getCustomerId());
                    String[] split = s1.split(",");
                    // 将识别的信息与预设信息比较
                    System.out.println(userDO);
                    if (split[0].equals(userDO.getName()) == false) {

                        return new ResultDO<>(false, ResultCode.ID_CARD_DOES_NOT_MATCH,
                            ResultCode.MSG_ID_CARD_DOES_NOT_MATCH, null);
                    }
                    if (split[1].equals(userDO.getIdCardNumber()) == false) {
                        return new ResultDO<>(false, ResultCode.ID_CARD_DOES_NOT_MATCH,
                            ResultCode.MSG_ID_CARD_DOES_NOT_MATCH, null);
                    }
                    System.out.println("结束ocr识别");

                    boolean idface = IDface.idface(path + "hadbody.jpg");
                    if (idface == false) {
                        return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
                            ResultCode.MSG_PARAMETER_INVALID, null);
                    }

                    System.out.println("开始云端比较");

                    // 将识别到的信息与云端比较 上线之前先关闭远程api
                    if (CheckIn.idEnsure(userDO.getName(), userDO.getIdCardNumber()) == false) {
                        return new ResultDO<>(false, ResultCode.IDENTIFICATION_OF_ABNORMAL,
                            ResultCode.MSG_IDENTIFICATION_OF_ABNORMAL, null);
                    }
                    System.out.println("完成云端比较");

                    userDO.setFaceToken(s);
                    customerService.updateUserDO(userDO);
                    return new ResultDO<>(true, ResultCode.SUCCESS,
                        ResultCode.MSG_SUCCESS, userDO);

                } else {
                    String cut = "data:image/png;base64,";
                    base64VO.setId64(StrUtil.removePreAndLowerFirst(base64VO.getId64(), cut));

                    System.out.println("开始ocr识别");
                    // OCR识别身份信息
                    String s1 = CheckIn.IDCardOCRBybase64(base64VO.getId64());
                    String[] split = s1.split(",");
                    // 将识别的信息与预设信息比较
                    System.out.println(userDO);
                    if (split[0].equals(userDO.getName()) == false) {

                        return new ResultDO<>(false, ResultCode.ID_CARD_DOES_NOT_MATCH,
                            ResultCode.MSG_ID_CARD_DOES_NOT_MATCH, null);
                    }
                    if (split[1].equals(userDO.getIdCardNumber()) == false) {
                        return new ResultDO<>(false, ResultCode.ID_CARD_DOES_NOT_MATCH,
                            ResultCode.MSG_ID_CARD_DOES_NOT_MATCH, null);
                    }
                    System.out.println("结束ocr识别");
                    // 将拍摄 或者 上传 的身份证照片解码
                    if (Base64Utils.GenerateImage(base64VO.getId64(),
                        path + base64VO.getCustomerId() + ".jpg") == false) {
                        return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                            ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
                    }

                    boolean idface = IDface.idface(path + base64VO.getCustomerId() + ".jpg");
                    if (idface == false) {
                        return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
                            ResultCode.MSG_PARAMETER_INVALID, null);
                    }

                    // 将图片上传到服务器
                    System.out.println("开始上传服务器");
                    File file = new File(path + base64VO.getCustomerId() + ".jpg");
                    byte[] bytes = FileUtilsAlter.fileToByte(file);
                    UploadUtils.uploadFile(bytes, ConstantHolder.FILE_UPLOAD, base64VO.getCustomerId() + ".jpg");
                    System.out.println("上传完成");
                    System.out.println("开始云端比较");

                    // 将识别到的信息与云端比较 上线之前先关闭远程api
                    if (CheckIn.idEnsure(userDO.getName(), userDO.getIdCardNumber()) == false) {
                        return new ResultDO<>(false, ResultCode.IDENTIFICATION_OF_ABNORMAL,
                            ResultCode.MSG_IDENTIFICATION_OF_ABNORMAL, null);
                    }
                    System.out.println("完成云端比较");
                    userDO.setFaceToken(s);
                    customerService.updateUserDO(userDO);
                    return new ResultDO<>(true, ResultCode.SUCCESS,
                        ResultCode.MSG_SUCCESS, userDO);
                }

            } else {
                ResultDO<CheckInWithDO> checkInWithPhone = checkInWithService.getCheckInWithPhone(base64VO.getPhone());
                String s = ConstantHolder.FILE_UPLOAD + base64VO.getPhone() + ".jpg";

                System.out.println("查住户");
                // 用户不是同住用户
                if (!checkInWithPhone.isSuccess()) {
                    return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                        ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
                }
                CheckInWithDO module = checkInWithPhone.getModule();
                String[] split = null;
                // 判断是否为前端上传
                System.out.println("判断开始");
                FileUtilsAlter.downloadHttpUrl(ConstantHolder.FILE_UPLOAD + base64VO.getCustomerId() + ".jpg", path,
                    "hadbody.jpg");
                File files = new File(path + "hadbody.jpg");
                boolean exists = files.exists();
                // 前端上传
                if (exists) {

                    System.out.println("开始ocr识别");
                    // OCR识别身份信息  地址识别
                    String s1 = CheckIn.IDCardOCR(base64VO.getCustomerId());
                    split = s1.split(",");
                    // 将识别的信息与预设信息比较
                    if (split[0].equals(module.getName()) == false) {

                        return new ResultDO<>(false, ResultCode.ID_CARD_DOES_NOT_MATCH,
                            ResultCode.MSG_ID_CARD_DOES_NOT_MATCH, null);
                    }
                    module.setIdCard(split[1]);
                    System.out.println("结束ocr识别");

					//人像校验
                    boolean idface = IDface.idface(path + "hadbody.jpg");
                    if (idface == false) {
                        return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
                            ResultCode.MSG_PARAMETER_INVALID, null);
                    }

                    System.out.println("开始云端比较");

                    // 将识别到的信息与云端比较 上线之前先关闭远程api
                    if (CheckIn.idEnsure(module.getName(), module.getIdCard()) == false) {
                        return new ResultDO<>(false, ResultCode.IDENTIFICATION_OF_ABNORMAL,
                            ResultCode.MSG_IDENTIFICATION_OF_ABNORMAL, null);
                    }
                    System.out.println("完成云端比较");

                    module.setIdPiture(s);
                    checkInWithService.updateCheckInWithDO(module);
                    return new ResultDO<>(true, ResultCode.SUCCESS,
                        ResultCode.MSG_SUCCESS);
                }else {

	                // OCR识别身份信息
	                System.out.println("开始ocr识别");
	                String s1 = CheckIn.IDCardOCRBybase64((base64VO.getId64()));
	                System.out.println("结束ocr识别");

	                split = s1.split(",");

	                // 将识别的信息与预设信息比较
	                if (!split[0].equals(module.getName())) {
		                return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
				                ResultCode.MSG_PARAMETER_INVALID, null);
	                }
	                System.out.println("解码开始");

	                // 将拍摄 或者 上传 的身份证照片解码
	                if (!Base64Utils.GenerateImage(base64VO.getId64(), path + base64VO.getPhone() + ".jpg")) {
		                return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
				                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
	                }
	                System.out.println("解码完成");

	                // 检测照片是否有人像
	                boolean idface = IDface.idface(path + base64VO.getPhone() + ".jpg");
	                if (idface == false) {
		                return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
				                ResultCode.MSG_PARAMETER_INVALID, null);
	                }
	                // 将图片上传到服务器
	                System.out.println("开始上传服务器");
	                File file = new File(path + base64VO.getPhone() + ".jpg");
	                byte[] bytes = FileUtilsAlter.fileToByte(file);
	                UploadUtils.uploadFile(bytes, ConstantHolder.FILE_UPLOAD, base64VO.getPhone() + ".jpg");
	                System.out.println("上传完成");

	                module.setIdPiture(s);

	                // // 将识别到的信息与云端比较
	                System.out.println("开始云端比较");
	                // 更新身份证号
	                module.setIdCard(split[1]);
	                if (CheckIn.idEnsure(module.getName(), module.getIdCard()) == false) {
		                return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
				                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
	                }
	                System.out.println("完成云端比较");

	                checkInWithService.updateCheckInWithDO(module);
	                return new ResultDO<>(true, ResultCode.SUCCESS,
			                ResultCode.MSG_SUCCESS);
                }

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
    @PostMapping("body-check")
    public ResultDO<Void> checkFace(@RequestBody FaceVO faceVO) {
        String cut = "data:image/png;base64,";
        faceVO.setBase64(StrUtil.removePreAndLowerFirst(faceVO.getBase64(), cut));
        try {
            String path = ResourceUtils.getURL("classpath:static/").getPath();

            // 将拍摄面部照片解码
            if (Base64Utils.GenerateImage(faceVO.getBase64(), path + "tmp.jpg") == false) {
                return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                    ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
            }
            ImageUtils.zoomByScale(path + "tmp.jpg", path + "tmp.jpg", "jpg", 1.5);
            System.out.println("图片识别");
            try {
                FaceIR.scanVivo();
            } catch (Exception e) {
                e.printStackTrace();
                return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
            }
            System.out.println("活体完成");
            // // 获取身份证图片 和本地图片地址
            // String s1 = path + customerId + ".jpg";
            // String s = ConstantHolder.FILE_UPLOAD + customerId + ".jpg";
            // 虹软sdk对比
            System.out.println("人脸检测比对开始");
            if (faceVO.getCustomerId() != 0) {
                if (CheckIn.checkIn(faceVO.getCustomerId()) == false) {
                    return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                        ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
                }
            }
            if (faceVO.getPhone() != null) {
                if (CheckIn.checkIn(Long.parseLong(faceVO.getPhone())) == false) {
                    return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                        ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
                }
            }
            System.out.println("人脸检测比对完成");

            return new ResultDO<>(true, ResultCode.SUCCESS,
                ResultCode.MSG_SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    @Override
    @PostMapping("add-live")
    public ResultDO<Void> checkWith(@RequestBody List<CheckWithVO> list) {
        // 删除失效请求
        System.out.println("删除失效请求");
        ResultDO<Void> deleteLoseEfficacy = checkInWithService.deleteLoseEfficacy();
        if (deleteLoseEfficacy.isSuccess() == false) {
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }

        System.out.println(list);
        // 遍历List
        for (int j = 0; j < list.size(); j++) {
            CheckWithVO checkWith = list.get(j);
            System.out.println("获取用户订单List");
            ResultDO<List<RecordDO>> listResultDO = recordService.showRecordByCustomer(checkWith.getCustomerId());
            System.out.println(listResultDO);
            List<RecordDO> resultDOModule = listResultDO.getModule();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            for (int n = 0; n < resultDOModule.size(); n++) {
                RecordDO recordDO = resultDOModule.get(n);
                ResultDO<CheckInWithDO> checkInWithPhone = checkInWithService.getCheckInWithPhone(checkWith.getPhone());
                // 用户已存在与该房间内
                System.out.println("判断是否已经存在房间");
                if (checkInWithPhone.getModule() != null) {
                    return new ResultDO<>(false, ResultCode.HAD_KIVE,
                        ResultCode.MSG_HAD_KIVE, null);
                }
                if (recordDO.getRoomNumber() == checkWith.getRoomNumber()) {
                    try {
                        CheckInWithDO checkInWithDO = new CheckInWithDO();
                        System.out.println(recordDO.getCheckOutTime());
                        checkInWithDO.setLastTime(dateFormat.parse(recordDO.getCheckOutTime()));
                        System.out.println(checkInWithDO.getLastTime());

                        checkInWithDO.setPhone(checkWith.getPhone());
                        checkInWithDO.setName(checkWith.getName());
                        checkInWithDO.setCustomerId(checkWith.getCustomerId());
                        checkInWithDO.setRoomNumber(checkWith.getRoomNumber());
                        ResultDO<Void> insert = checkInWithService.insert(checkInWithDO);
                        if (insert.isSuccess() == false) {
                            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        return new ResultDO<>(true, ResultCode.SUCCESS,
            ResultCode.MSG_SUCCESS);
    }
}
