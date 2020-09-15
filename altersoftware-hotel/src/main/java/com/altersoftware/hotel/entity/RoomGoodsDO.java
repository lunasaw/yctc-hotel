package com.altersoftware.hotel.entity;

import java.util.Date;

public class RoomGoodsDO {
    // 房间门牌号
    private int    roomNumber;

    // 物品名
    private String goodsName;

    /**
     * 物品状态
     * {@link com.altersoftware.hotel.constant.entity.room.RoomState}
     */
    private String state;

    /** 创建时间 */
    private Date   createTime;

    /** 修改时间 */
    private Date   modifyTime;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
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
        return "RoomGoodsDO{" +
            "roomNumber=" + roomNumber +
            ", goodsName='" + goodsName + '\'' +
            ", state=" + state +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
