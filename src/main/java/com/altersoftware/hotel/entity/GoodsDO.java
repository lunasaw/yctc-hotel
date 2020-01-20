package com.altersoftware.hotel.entity;

import java.util.Date;

/**
 * @author czy@win10
 * @date 2020/1/20 15:58
 */
public class GoodsDO {

    /** 物品编号 */
    private long   id;
    /** 房间编号 */
    private long   roomId;
    /** 物品名称 */
    private String name;
    /** 物品采购时间 */
    private Date   dateTime;
    /** 物品采购价格 */
    private float  price;
    /** 物品损坏赔偿价格 */
    private float  compensationMoeny;
    /** 物品是否使用 */
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

    public long getroomId() {
        return roomId;
    }

    public void setroomId(long roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getCompensationMoeny() {
        return compensationMoeny;
    }

    public void setCompensationMoeny(float compensationMoeny) {
        this.compensationMoeny = compensationMoeny;
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
        return "GoodsDO{" +
            "id=" + id +
            ", roomId=" + roomId +
            ", name='" + name + '\'' +
            ", dateTime=" + dateTime +
            ", price=" + price +
            ", compensationMoeny=" + compensationMoeny +
            ", state=" + state +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
