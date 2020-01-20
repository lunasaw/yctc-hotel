package com.altersoftware.hotel.entity;

import java.util.Date;

public class RecordDO {

    /** 订单编号 */
    private long   id;

    /** 房间号 */
    private long   roomID;

    /** 客户编号 */
    private long   customerID;

    /** 员工编号 */
    private long   staffID;

    /** 入住时间 */
    private Date   checkInTime;

    /** 退房时间 */
    private Date   checkOutTime;

    /** 房间押金 */
    private float  deposit;

    /** 评价 */
    private String evaluate;

    /** 创建时间 */
    private Date   createTime;

    /** 修改时间 */
    private Date   modifyTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoomID() {
        return roomID;
    }

    public void setRoomID(long roomID) {
        this.roomID = roomID;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public long getStaffID() {
        return staffID;
    }

    public void setStaffID(long staffID) {
        this.staffID = staffID;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Date getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Date checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "RecordDO{" +
            "id=" + id +
            ", roomID=" + roomID +
            ", customerID=" + customerID +
            ", staffID=" + staffID +
            ", checkInTime=" + checkInTime +
            ", checkOutTime=" + checkOutTime +
            ", deposit=" + deposit +
            ", evaluate='" + evaluate + '\'' +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
