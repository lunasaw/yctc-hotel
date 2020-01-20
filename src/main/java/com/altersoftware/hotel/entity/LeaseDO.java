package com.altersoftware.hotel.entity;

import java.util.Date;

/**
 * @author czy@win10
 * @date 2020/1/20 16:31
 */
public class LeaseDO {

    /** 出租纪录编号 */
    private long id;
    /** 租赁物品编号 */
    private long goodsId;
    /** 租赁顾客编号 */
    private long customerId;
    /** 租赁约定时长 */
    private Date rentalTime;
    /** 出租归还时间 */
    private Date returnTime;
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

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Date getRentalTime() {
        return rentalTime;
    }

    public void setRentalTime(Date rentalTime) {
        this.rentalTime = rentalTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
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
        return "LeaseDO{" +
            "id=" + id +
            ", goodsId=" + goodsId +
            ", customerId=" + customerId +
            ", rentalTime=" + rentalTime +
            ", returnTime=" + returnTime +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
