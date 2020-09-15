package com.altersoftware.hotel.vo;

/**
 * 邮箱验证码（效验用户）
 *
 * @author wlt
 */
public class MailCaptchaVO {

    /** 前端用户输入的邮箱验证码 */
    private String captchaFromFront;

    public String getCaptchaFromFront() {
        return captchaFromFront;
    }

    public void setCaptchaFromFront(String captchaFromFront) {
        this.captchaFromFront = captchaFromFront;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MailCaptchaVO [captchaFromFront=");
        builder.append(captchaFromFront);
        builder.append("]");
        return builder.toString();
    }
}
