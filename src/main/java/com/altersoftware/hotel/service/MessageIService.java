package com.altersoftware.hotel.service;


import com.altersoftware.hotel.entity.ResultDO;

public interface MessageIService {

    /**
     * 发邮箱验证码
     * 
     * @param mail
     * @return
     */
    public ResultDO<Void> sendVerificationCodeMail(String mail);

    /**
     * 发手机验证码
     * 
     * @param mobile
     * @return
     */
    public ResultDO<Void> sendVerificationCodeSms(String mobile);

    /**
     * 发送短信
     * 
     * @param mobile
     * @param content
     * @return
     */
    public ResultDO<String> sendSms(String mobile, String content);

}
