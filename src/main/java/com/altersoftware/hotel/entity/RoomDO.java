package com.altersoftware.hotel.entity;

import java.util.Date;

public class RoomDO {

    /** 房间号 */
    private long   id;

    /** 楼层号 */
    private int    floorId;

    /** 房间类型 */
    private String type;

    /** 房间价格 */
    private double price;

    /** 房间押金 */
    private double deposit;

    /** 房间状态 */
    private int    state;

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

    public int getFloorID() {
        return floorId;
    }

    public void setFloorID(int floorId) {
        this.floorId = floorId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
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
        return "RoomDO{" +
            "id=" + id +
            ", floorId=" + floorId +
            ", type='" + type + '\'' +
            ", price=" + price +
            ", deposit=" + deposit +
            ", state=" + state +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
