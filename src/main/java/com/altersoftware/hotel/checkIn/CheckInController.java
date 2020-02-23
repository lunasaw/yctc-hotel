package com.altersoftware.hotel.checkIn;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.altersoftware.hotel.entity.RecordDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;
import com.altersoftware.hotel.vo.BaseVO;
import com.altersoftware.hotel.vo.CheckWithVO;

/**
 * @author Iszychen@win10
 * @date 2020/2/21 18:07
 */
public interface CheckInController {

    /**
     * 同会员id 查询用户DO 检查facetoken是否存在
     * true 存在 并且返回用户信息
     * false 不存在 也返回用户信息
     *
     * @param number
     * @return
     */
    // TODO 1.通过客户会员账号查询faceToken
    ResultDO<UserDO> checkFaceToken(String number);

    // TODO 2.拍摄身份正上传=> 拍摄留本地 从本保地指定 对身份证进行信息 认证返回true 提示认证成功
    /**
     * 1.先确定用户是上传还是拍照
     * 2.上传直接调用filerest 上传
     * 3.拍照传回base64字符串
     * 4.转为图片
     * 5.ocr识别 云端比对
     * 6.返回用户信息
     *
     * @param base64VO
     * @return
     */
    ResultDO<UserDO> checkIdCard(@RequestBody BaseVO base64VO);

    /**
     * 返回用户当前预定的房间 也就是正在使用的房间
     *
     * @param customerId
     * @return
     */
    // TODO 下一步 返回一个订单信息List 若有两个房,间指定房间
    ResultDO<List<RecordDO>> nowToLive(long customerId);

    // TODO 3.前端拍摄人脸 (拍照上传后 转圈等待) 传回 长串数据 通过方法转为图片 与数据库中身份证比对 比对
    // TODO 返回ture or false 若为ture 提示办理完成 点击后跳转 若为false 提示人脸认证失败请重试 不跳转
    /**
     * 人脸肯定是base64编码
     * 1. 先解码 存放本地
     * 2. 调用算法比对
     * 3. 返回比对结果
     *
     * @param face64
     * @return
     */
    ResultDO<Void> checkFace(String face64, long customerId);

    /**
     * 客户添加同住人信息
     *
     * @param list
     * @return
     */
    ResultDO<Void> checkWith(List<CheckWithVO> list);

    /**
     * 检查有无同行人信息
     *
     * @param phone
     * @return
     */
    ResultDO<RecordDO> checkWithPhone(String phone);

}
