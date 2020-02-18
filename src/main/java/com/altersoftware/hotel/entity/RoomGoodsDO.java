package com.altersoftware.hotel.entity;

public class RoomGoodsDO {
    //房间号
    private long roomId;

    //物品名
    private String goodsName;

    /**
     * 物品状态
     * {@link com.altersoftware.hotel.constant.entity.room.RoomState}
     */
    private int    state;

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "RoomGoodsDO{" +
                "roomId=" + roomId +
                ", goodsName='" + goodsName + '\'' +
                ", state=" + state +
                '}';
    }
}
