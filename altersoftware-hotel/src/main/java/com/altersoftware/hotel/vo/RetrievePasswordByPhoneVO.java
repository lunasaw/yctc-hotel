package com.altersoftware.hotel.vo;

/**
 * 手机找密VO
 *
 * @author 15272
 */
public class RetrievePasswordByPhoneVO {

    /** 手机号 */
    private String phone;
    /** 验证码 */
    private String verificationCode;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        builder.append("RetrievePasswordByPhoneVO [phone=");
        builder.append(phone);
        builder.append(", verificationCode=");
        builder.append(verificationCode);
        builder.append("]");
        return builder.toString();
    }

}
