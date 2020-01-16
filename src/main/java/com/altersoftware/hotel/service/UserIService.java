package com.altersoftware.hotel.service;


import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;

public interface UserIService {

    /**
     * 用userId查询UserDO
     *
     * @param userId
     * @return
     */
    public ResultDO<UserDO> getUserDOById(long userId);

    /**
     * 注册
     *
     * @param userDO
     * @return
     */
    public ResultDO<Void> signup(UserDO userDO);

    /**
     * 登陆
     *
     * @param userDO
     * @return
     */
    public ResultDO<Long> signin(UserDO userDO);

    /**
     * 改密
     * 
     * @param userDO
     * @param oldPassword
     * @param newPassword
     * @return
     */
    public ResultDO<Void> updatePassword(UserDO userDO, String oldPassword, String newPassword);

    /**
     * 通过邮箱找到userDO
     *
     * @param mail
     * @return
     */
    public ResultDO<UserDO> getUserDOByMail(String mail);

    /**
     * 通过手机找到userDO
     *
     * @param phone
     * @return
     */
    public ResultDO<UserDO> getUserDOByPhone(String phone);

    /**
     * 邮箱找密
     *
     * @param mail
     * @param newPassword
     * @return
     */
    public ResultDO<Void> retrievePasswordByMail(String mail, String newPassword);

    /**
     * 手机找密
     *
     * @param phone
     * @param newPasssword
     * @return
     */
    public ResultDO<Void> retrievePasswordByPhone(String phone, String newPasssword);

    /**
     * 修改邮箱
     *
     * @param userDO
     * @param mail
     * @return
     */
    public ResultDO<Void> updateMail(UserDO userDO, String mail);

    /**
     * 修改手机
     *
     * @param userDO
     * @param mobile
     * @return
     */
    public ResultDO<Void> updateMobile(UserDO userDO, String mobile);

    /**
     * 通过学号/工号找到userDO
     *
     * @param number
     * @return
     */
    public ResultDO<UserDO> getUserDOByNumber(String number);

    /**
     * 通过faceToken返回userDO
     * 
     * @param faceToken
     * @return
     */
    public ResultDO<UserDO> getUserDOByFaceToken(String faceToken);

    /**
     * 更新userDO信息
     * 
     * @param userDO
     * @return
     */
    public ResultDO<Void> updateUserDO(UserDO userDO);



}
