package com.altersoftware.hotel.entity;

import java.util.Date;

/**
 * @author Iszychen@win10
 * @date 2020/2/23 15:28
 */
public class CheckInWithDO {
    /** 编号 */
    private long   id;
    /** 预定客户编号 */
    private long   customerId;
    /** 同行人手机 */
    private String phone;
    /** 同行人身份证号 */
    private String idCard;
    /** 同行人姓名 */
    private String name;
    /** 同行人房间号 */
    private int    roomNumber;
    /** 同行人身份证图片地址 */
    private String idPiture;
    /** 失效时间 */
    private Date   lastTime;
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

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getIdPiture() {
        return idPiture;
    }

    public void setIdPiture(String idPiture) {
        this.idPiture = idPiture;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
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
}
