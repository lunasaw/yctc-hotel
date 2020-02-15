package com.altersoftware.hotel.entity;

import java.util.Date;

public class MealdistributionDO {

    /** 配送编号 */
    private long id;

    /** 房间编号 */
    private long roomId;

    /** 员工编号 */
    private long staffId;

    /** 订单编号 */
    private long orderId;

    /** 开始配送时间 */
    private Date inTime;

    /** 送达时间 */
    private Date outTime;

    /** 创建时间/下单实际 */
    private Date createTime;

    /** 修改时间 */
    private Date modifyTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
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
        return "MealdistributionDO{" +
            "id=" + id +
            ", roomId=" + roomId +
            ", staffId=" + staffId +
            ", orderId=" + orderId +
            ", inTime=" + inTime +
            ", outTime=" + outTime +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
