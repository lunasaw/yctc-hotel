package com.altersoftware.hotel.vo;

/**
 * 修改邮箱VO
 *
 * @author wlt
 */
public class UpdateMailVO {

    /** 新邮箱 */
    private String mail;

    /** 前端用户输入的邮箱验证码 */
    private String captchaFromFront;

    public UpdateMailVO() {
        super();
    }

    public UpdateMailVO(String mail, String captchaFromFront) {
        super();
        this.mail = mail;
        this.captchaFromFront = captchaFromFront;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
        builder.append("UpdateMailVO [mail=");
        builder.append(mail);
        builder.append(", captchaFromFront=");
        builder.append(captchaFromFront);
        builder.append("]");
        return builder.toString();
    }
}
