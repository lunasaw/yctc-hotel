package com.altersoftware.hotel.entity;

import java.util.Date;

/**
 * @author czy@win10
 * @date 2020/2/2 13:46
 */
public class RoomTypeDO {

    /** 房间类别编号 */
    private long   id;

    /** 房间类别 */
    private String roomType;

    /** 房间类别名称 */
    private String name;

    /** 房间类别图片 */
    private String picture;

    /** 预计入住人数 */
    private int    userNumber;

    /** 房间描述 */
    private String description;

    /** 房间大小 */
    private String wide;

    /** 是否可加床 */
    private String addBed;

    /** 创建时间 */
    private Date   createTime;

    /** 修改时间 */
    private Date   modifyTime;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public String getDescribe() {
        return description;
    }

    public void setDescribe(String description) {
        this.description = description;
    }

    public String getWide() {
        return wide;
    }

    public void setWide(String wide) {
        this.wide = wide;
    }

    public String getAddBed() {
        return addBed;
    }

    public void setAddBed(String addBed) {
        this.addBed = addBed;
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
        return "RoomTypeDO{" +
            "id=" + id +
            ", roomType='" + roomType + '\'' +
            ", name='" + name + '\'' +
            ", picture='" + picture + '\'' +
            ", userNumber=" + userNumber +
            ", description='" + description + '\'' +
            ", wide='" + wide + '\'' +
            ", addBed='" + addBed + '\'' +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
