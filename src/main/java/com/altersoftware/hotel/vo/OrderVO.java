package com.altersoftware.hotel.vo;

import java.util.Date;

/**
 * @author hzx
 * @date 2020/2/10 22:55
 */
public class OrderVO {

    /** 菜品编号 */
    private long   menuId;
    /** 菜品份数 */
    private int    numbers;
    /** 客户编号 */
    private long   customerId;
    /** 房间号 */
    private int  roomNumber;
    /** 创建时间 */
    Date          createTime;
    /** 修改时间 */
    Date           modifyTime;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
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

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
            "menuId=" + menuId +
            ", numbers=" + numbers +
            ", customerId=" + customerId +
            ", roomNumber=" + roomNumber +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
