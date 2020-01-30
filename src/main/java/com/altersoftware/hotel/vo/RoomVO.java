package com.altersoftware.hotel.vo;

import java.util.Date;

/**
 * @author czy@win10
 * @date 2020/1/29 22:04
 */
public class RoomVO {
    /** 房间门牌号 */
    private int    roomNumber;

    /** 房间价格 */
    private double price;

    /** 房间押金 */
    private double deposit;

    /** 房间状态 */
    private int    state;

    /** 房间类型 */
    private String type;

    /** 修改时间 */
    private Date modifyTime;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
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

    @Override
    public String toString() {
        return "RoomVO{" +
                "roomNumber=" + roomNumber +
                ", price=" + price +
                ", deposit=" + deposit +
                ", state=" + state +
                ", type='" + type + '\'' +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
