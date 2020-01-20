package com.altersoftware.hotel.entity;

import java.util.Date;

/**
 * @author czy@win10
 * @date 2020/1/20 15:17
 */
public class CustomerDO {

    /*** 编号 */
    private long   id;
    /** 姓名 */
    private String name;
    /** 身份证号 */
    private String idCard;
    /** 性别 */
    private String sex;
    /** 手机 */
    private long   mobile;
    /** 账户余额 */
    private long   account;
    /** 密码 */
    private String password;
    /** 脸部 */
    private String faceId;
    /** 邮箱 */
    private String email;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFaceId() {
        return faceId;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "CustomerDO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", idCard='" + idCard + '\'' +
            ", sex='" + sex + '\'' +
            ", mobile=" + mobile +
            ", account=" + account +
            ", password='" + password + '\'' +
            ", faceId='" + faceId + '\'' +
            ", email='" + email + '\'' +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
