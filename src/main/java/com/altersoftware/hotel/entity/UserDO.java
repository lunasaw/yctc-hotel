package com.altersoftware.hotel.entity;

import java.util.Date;

public class UserDO {

    /** 用户id */
    private long id;
    /** 学院 */
    private long academyId;
    /** 班级 */
    private long classId;
    /** 学号/工号 */
    private String number;
    /** 密码 */
    private String password;
    /** 姓名 */
    private String name;
    /** user类型，见{@link edu.yctc.hotel.constant.UserType}} */
    private int type;
    /** 性别 */
    private String sex;
    /** 身份证 */
    private String idCardNumber;
    /** 手机号 */
    private String phone;
    /** 邮箱 */
    private String mail;
    /** 人脸照url */
    private String picture;
    /** 人脸标识 */
    private String faceToken;
    /** 创建时间 */
    private Date createTime;
    /** 修改时间 */
    private Date modifyTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFaceToken() {
        return faceToken;
    }

    public void setFaceToken(String faceToken) {
        this.faceToken = faceToken;
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

    public long getAcademyId() {
        return academyId;
    }

    public void setAcademyId(long academyId) {
        this.academyId = academyId;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserDO [id=");
        builder.append(id);
        builder.append(", academyId=");
        builder.append(academyId);
        builder.append(", classId=");
        builder.append(classId);
        builder.append(", number=");
        builder.append(number);
        builder.append(", password=");
        builder.append(password);
        builder.append(", name=");
        builder.append(name);
        builder.append(", type=");
        builder.append(type);
        builder.append(", sex=");
        builder.append(sex);
        builder.append(", idCardNumber=");
        builder.append(idCardNumber);
        builder.append(", phone=");
        builder.append(phone);
        builder.append(", mail=");
        builder.append(mail);
        builder.append(", picture=");
        builder.append(picture);
        builder.append(", faceToken=");
        builder.append(faceToken);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", modifyTime=");
        builder.append(modifyTime);
        builder.append("]");
        return builder.toString();
    }

}
