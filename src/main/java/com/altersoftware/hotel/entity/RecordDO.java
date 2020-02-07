package com.altersoftware.hotel.entity;

import java.util.Date;

public class RecordDO {

    /** 订单编号 */
    private long   id;

    /** 房间号 */
    private int    roomNumber;

    /** 客户编号 */
    private long   customerId;

    /** 处理员工编号 */
    private long   staffId;

    /** 预计入住时间间隔 */
    private String precheckInTime;

    /** 入住时间 */
    private String checkInTime;

    /** 退房时间 */
    private String checkOutTime;

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

    public int getRoomId() {
        return roomNumber;
    }

    public void setRoomId(int roomNumber) {
        this.roomNumber = roomNumber;
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
            ", roomNumber=" + roomNumber +
            ", customerId=" + customerId +
            ", staffId=" + staffId +
            ", precheckInTime='" + precheckInTime + '\'' +
            ", checkInTime='" + checkInTime + '\'' +
            ", checkOutTime='" + checkOutTime + '\'' +
            ", evaluate='" + evaluate + '\'' +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
