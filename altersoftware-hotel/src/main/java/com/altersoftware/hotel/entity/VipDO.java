package com.altersoftware.hotel.entity;

import java.util.Date;

public class VipDO {

    /** 主键 */
    private long   id;
    /** 客户编号 */
    private long   customerNumber;
    /** 会员等级 */
    private String grade;
    /** 消费金额 */
    private double amount;
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

    public long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(long customerNumber) {
        this.customerNumber = customerNumber;
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
            ", customerNumber=" + customerNumber +
            ", grade='" + grade + '\'' +
            ", amount=" + amount +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
