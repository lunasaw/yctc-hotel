package com.altersoftware.hotel.vo;

/**
 * 修改手机VO
 *
 * @author 15272
 */
public class UpdateMobileVO {

    /** 新手机 */
    private String mobile;

    /** 前端用户输入的短信验证码 */
    private String captchaFromFront;

    public UpdateMobileVO() {
        super();
    }

    public UpdateMobileVO(String mobile, String captchaFromFront) {
        super();
        this.mobile = mobile;
        this.captchaFromFront = captchaFromFront;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCaptchaFromFront() {
        return captchaFromFront;
    }

    public void setCaptchaFromFront(String captchaFromFront) {
        this.captchaFromFront = captchaFromFront;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UpdateMobileVO [mobile=");
        builder.append(mobile);
        builder.append(", captchaFromFront=");
        builder.append(captchaFromFront);
        builder.append("]");
        return builder.toString();
    }
}
