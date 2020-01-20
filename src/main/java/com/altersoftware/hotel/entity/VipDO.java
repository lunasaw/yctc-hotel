package com.altersoftware.hotel.entity;

import java.util.Date;

public class VipDO {

    /** 创建时间 */
    Date           createTime;
    /** 修改时间 */
    Date           modifyTime;
    /** 主键 */
    private long   id;
    /** 用户编号 */
    private long   number;
    /** 会员等级 */
    private String grade;
    /** 消费金额 */
    private double amount;
    /** 折扣 */
    private float  discount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
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
        return "VipDO{" +
            "id=" + id +
            ", number=" + number +
            ", grade='" + grade + '\'' +
            ", amount=" + amount +
            ", discount=" + discount +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
