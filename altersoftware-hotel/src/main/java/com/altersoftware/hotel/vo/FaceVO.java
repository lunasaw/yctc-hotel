package com.altersoftware.hotel.vo;

/**
 * @author Iszychen@win10
 * @date 2020/2/24 21:30
 */
public class FaceVO {

    /** 图片64编码 **/
    private String base64;

    /** 客户id **/
    private long   customerId;

    /** 客户手机号 **/
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
