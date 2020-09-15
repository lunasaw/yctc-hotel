package com.altersoftware.hotel.vo;

/**
 * @author czy@win10
 * @date 2020/1/29 22:04
 */
public class RoomVO {
    /** 楼层号 */
    private int    floorId;

    /** 房间门牌号 */
    private int    roomNumber;

    /** 房间类型 */
    private String type;

    /** 房间价格 */
    private double price;

    /** 房间押金 */
    private double deposit;

    /** 房间状态 */
    private int    state;

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
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
}
