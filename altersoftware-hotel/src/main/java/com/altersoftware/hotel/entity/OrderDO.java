package com.altersoftware.hotel.entity;

import java.util.Date;

/**
 * @author czy@win10
 * @date 2020/2/1 20:29
 */
public class OrderDO {

    /** 创建时间 */
    Date           createTime;
    /** 修改时间 */
    Date           modifyTime;
    /** 订单编号 */
    private long   id;
    /** 菜品编号 */
    private long   menuId;
    /** 菜品份数 */
    private int    numbers;
    /** 客户编号 */
    private long   customerId;
    /** 实际付款金额 */
    private double payMoney;
    /** 状态 暂定为是否付款 */
    private int    state;

    public OrderDO(long id, long menuId, int numbers, long customerId) {
        this.id = id;
        this.menuId = menuId;
        this.numbers = numbers;
        this.customerId = customerId;
    }

    public OrderDO() {}

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

    public double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(double payMoney) {
        this.payMoney = payMoney;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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
            ", payMoney=" + payMoney +
            ", state=" + state +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
