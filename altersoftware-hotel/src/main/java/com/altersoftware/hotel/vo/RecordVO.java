package com.altersoftware.hotel.vo;


/**
 * @author Iszychen@win10
 * @date 2020/2/7 21:21
 */
public class RecordVO {

    /** 客户编号 */
    private long   customerId; //vip

    /** 处理员工编号 */
    private long   staffId;

    /** 预计入住时间间隔 */
    private String precheckInTime;

    /** 入住时间 */
    private String checkInTime;

    /** 退房时间 */
    private String checkOutTime;

    /** 房间类别名称 */
    private String roomTypeName;

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public String getPrecheckInTime() {
        return precheckInTime;
    }

    public void setPrecheckInTime(String precheckInTime) {
        this.precheckInTime = precheckInTime;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
}
