package com.altersoftware.hotel.entity;

import java.util.Date;

public class MealdistributionDO {

    /** 配送编号 */
    private long id;

    /** 房间编号 */
    private long roomId;

    /** 员工编号 */
    private long staffId;

    /** 菜品编号 */
    private long menuId;

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
        return roomId;
    }

    public void setRoomID(long roomId) {
        this.roomId = roomId;
    }

    public long getStaffID() {
        return staffId;
    }

    public void setStaffID(long staffId) {
        this.staffId = staffId;
    }

    public long getMenuID() {
        return menuId;
    }

    public void setMenuID(long menuId) {
        this.menuId = menuId;
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
            ", menuId=" + menuId +
            ", inTime=" + inTime +
            ", outTime=" + outTime +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
