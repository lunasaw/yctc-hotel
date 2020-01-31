package com.altersoftware.hotel.vo;

/**
 * @author hzx
 * @date 2020/1/30 22:06
 */
public class HotelVO {
    /** 酒店编号 */
    private long   id;
    /** 酒店名称 */
    private String name;
    /** 楼层数量 */
    private int    floorNumbers;
    /** 房间数量 */
    private int    roomNumbers;
    /** 联系方式 */
    private int    mobile;
    /** 酒店地址 */
    private String address;
    /** 规章制度 */
    private String rules;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloorNumbers() {
        return floorNumbers;
    }

    public void setFloorNumbers(int floorNumbers) {
        this.floorNumbers = floorNumbers;
    }

    public int getRoomNumbers() {
        return roomNumbers;
    }

    public void setRoomNumbers(int roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    @Override
    public String toString() {
        return "HotelVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", floorNumbers=" + floorNumbers +
                ", roomNumbers=" + roomNumbers +
                ", mobile=" + mobile +
                ", address='" + address + '\'' +
                ", rules='" + rules + '\'' +
                '}';
    }
}
