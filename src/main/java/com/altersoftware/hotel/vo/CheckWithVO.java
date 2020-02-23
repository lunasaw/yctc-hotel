package com.altersoftware.hotel.vo;

import javax.validation.constraints.NotEmpty;

/**
 * @author Iszychen@win10
 * @date 2020/2/23 16:21
 */
public class CheckWithVO {

    /** 同住人手机号 */
    @NotEmpty
    private String phone;
    /** 同住人姓名 */
    @NotEmpty
    private String name;
    /** 同住人房间号 */
    @NotEmpty
    private int    roomNumber;
    /** 预定客户编号 */
    @NotEmpty
    private long   customerId;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
