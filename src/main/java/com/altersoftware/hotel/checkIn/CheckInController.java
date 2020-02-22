package com.altersoftware.hotel.checkIn;

import com.altersoftware.hotel.entity.RecordDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;

/**
 * @author Iszychen@win10
 * @date 2020/2/21 18:07
 */
public interface CheckInController {

    // TODO 1.通过客户会员账号查询faceToken
    ResultDO<UserDO> checkFaceToken(String number);

    // TODO 2.拍摄身份正上传=> 拍摄保留本地 从本地指定 对身份证进行信息 认证返回true 提示认证成功
    ResultDO<Boolean> checkIdCard(String id64, long customerId);

    // TODO 下一步 返回一个订单信息List 若有两个房,间指定房间
    ResultDO<RecordDO> nowToLive(long customerId);

    // TODO 3.前端拍摄人脸 (拍照上传后 转圈等待) 传回 长串数据 通过方法转为图片 与数据库中身份证比对 比对

    // TODO 返回ture or false 若为ture 提示办理完成 点击后跳转 若为false 提示人脸认证失败请重试 不跳转
    ResultDO<Boolean> checkFace(String face64);

}
