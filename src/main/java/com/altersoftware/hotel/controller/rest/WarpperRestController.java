package com.altersoftware.hotel.controller.rest;


import com.altersoftware.hotel.entity.ResultDO;

public interface WarpperRestController {

    /**
     * 发邮件验证码的rest方法
     *
     * @param mail
     * @return
     */
    public ResultDO<Void> sendMail(String mail);

    /**
     * 发短信验证码的rest方法
     *
     * @param mobile
     * @return
     */
    public ResultDO<Void> sendSms(String mobile);

    /**
     * 发邮件验证码(修改邮箱时用的)的rest方法
     *
     * @param mail
     * @return
     */
    public ResultDO<Void> sendEmailForUpdateMail(String mail);

    /**
     * 发短信验证码(修改手机时用的)的rest方法
     *
     * @param mobile
     * @return
     */
    public ResultDO<Void> sendSmsForUpdateMobile(String mobile);
}
