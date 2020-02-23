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
import com.altersoftware.hotel.entity.RecordDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;
import com.altersoftware.hotel.service.RecordService;
import com.altersoftware.hotel.service.UserIService;
import com.altersoftware.hotel.util.Base64Utils;
import com.altersoftware.hotel.util.CheckIn;
import com.altersoftware.hotel.util.FileUtilsAlter;
import com.altersoftware.hotel.util.UploadUtils;
import com.altersoftware.hotel.vo.BaseVO;

/**
 * @author Iszychen@win10
 * @date 2020/2/22 17:44
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/checkin")
public class CheckInControllerImpl implements CheckInController {

    @Resource
    private UserIService  userIService;

    @Resource
    private RecordService recordService;

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
        // 参数校验
        if (base64VO.getCustomerId() <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        UserDO userDO = null;
        try {
            String path = ResourceUtils.getURL("classpath:static/").getPath();
            // 将拍摄 或者 上传 的身份证照片解码
            if (Base64Utils.GenerateImage(base64VO.getId64(), path + base64VO.getCustomerId() + ".jpg") == false) {
                return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                    ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
            }
            // 将图片上传到服务器
            File file = new File(path + base64VO.getCustomerId() + ".jpg");
            byte[] bytes = FileUtilsAlter.fileToByte(file);
            UploadUtils.uploadFile(bytes, ConstantHolder.FILE_UPLOAD, base64VO.getCustomerId() + ".jpg");
            ResultDO<UserDO> userDOById = userIService.getUserDOById(base64VO.getCustomerId());
            userDO = userDOById.getModule();
            // OCR识别身份信息
            String s1 = CheckIn.IDCardOCR(base64VO.getCustomerId());
            String[] split = s1.split(",");
            // 将识别的信息与预设信息比较
            if (split[0].equals(userDO.getName()) == false || split[1].equals(userDO.getIdCardNumber()) == false) {
                return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                    ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
            }
            // 将识别到的信息与云端比较
            if (CheckIn.idEnsure(userDO.getName(), userDO.getIdCardNumber()) == false) {
                return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                    ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
            }
            return new ResultDO<>(true, ResultCode.SUCCESS,
                ResultCode.MSG_SUCCESS, userDO);
        } catch (Exception e) {
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
}
