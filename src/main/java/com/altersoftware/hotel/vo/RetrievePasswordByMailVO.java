package com.altersoftware.hotel.vo;

/**
 * 邮箱找密VO
 *
 * @author 15272
 */
public class RetrievePasswordByMailVO {

    /** 邮箱 */
    private String mail;
    /** 验证码 */
    private String verificationCode;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RetrievePasswordByMailVO [mail=");
        builder.append(mail);
        builder.append(", verificationCode=");
        builder.append(verificationCode);
        builder.append("]");
        return builder.toString();
    }
}
