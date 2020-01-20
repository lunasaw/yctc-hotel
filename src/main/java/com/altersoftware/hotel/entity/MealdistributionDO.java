package com.altersoftware.hotel.entity;

import java.util.Date;

public class MealdistributionDO {

    /** 配送编号 */
    private long id;

    /** 房间编号 */
    private long roomID;

    /** 员工编号 */
    private long staffID;

    /** 菜品编号 */
    private long menuID;

    /** 下单时间 */
    private Date inTime;

    /** 配送时间 */
    private Date outTime;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date modifyTime;

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

    public long getStaffID() {
        return staffID;
    }

    public void setStaffID(long staffID) {
        this.staffID = staffID;
    }

    public long getMenuID() {
        return menuID;
    }

    public void setMenuID(long menuID) {
        this.menuID = menuID;
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
            ", roomID=" + roomID +
            ", staffID=" + staffID +
            ", menuID=" + menuID +
            ", inTime=" + inTime +
            ", outTime=" + outTime +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
