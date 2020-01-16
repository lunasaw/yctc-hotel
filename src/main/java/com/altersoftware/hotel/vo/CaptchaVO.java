package com.altersoftware.hotel.vo;

/**
 * 前端用户输入的验证码VO
 *
 * @author 15272
 */
public class CaptchaVO {

    /** 前端用户输入的验证码 */
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
        builder.append("CaptchaVO [captchaFromFront=");
        builder.append(captchaFromFront);
        builder.append("]");
        return builder.toString();
    }
}
