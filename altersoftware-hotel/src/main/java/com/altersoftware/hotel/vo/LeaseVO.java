package com.altersoftware.hotel.vo;

public class LeaseVO {

   private long customerId;

   private long goodsId;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "LeaseVO{" +
                "customerId=" + customerId +
                ", goodsId=" + goodsId +
                '}';
    }
}
