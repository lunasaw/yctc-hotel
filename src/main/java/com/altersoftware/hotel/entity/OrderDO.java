package com.altersoftware.hotel.entity;

import java.util.Date;

/**
 * @author czy@win10
 * @date 2020/2/1 20:29
 */
public class OrderDO {


    /** 订单编号 */
    private long id;
    /** 菜品编号 */
    private long menuId;
    /** 菜品分数 */
    private int  numbers;
    /** 客户编号 */
    private long customerId;
    /** 创建时间 */
    Date         createTime;
    /** 修改时间 */
    Date         modifyTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
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
        return "OrderDO{" +
            "id=" + id +
            ", menuId=" + menuId +
            ", numbers=" + numbers +
            ", customerId=" + customerId +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
