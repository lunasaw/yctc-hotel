package com.altersoftware.hotel.checkIn;

import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;

/**
 * @author Iszychen@win10
 * @date 2020/2/21 18:07
 */
public interface CheckInController {

    // TODO 1.通过客户会员账号查询faceToken
    ResultDO<UserDO> checkFaceToken(String number);

    // TODO 2.拍摄身份正上传=> 拍摄保留本地 从本地指定

    // TODO 3.前端拍摄人脸

    // TODO 4.
}
