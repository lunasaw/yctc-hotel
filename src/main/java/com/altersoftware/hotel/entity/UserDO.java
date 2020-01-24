package com.altersoftware.hotel.entity;

import java.util.Date;

import com.altersoftware.hotel.constant.entity.user.UserType;

public class UserDO {

    /** 主键用户号 */
    private long   id;

    /** 部门号码 */
    private long   departmentId;

    /** 用户账户余额 */
    private Double account;

    /** 会员卡号/员工工号 */
    private String number;

    /** 用户年龄 */
    private int    age;

    /** 用户密码 */
    private String password;

    /** 用户姓名 */
    private String name;

    /** 权限组id 见{@link UserType}} */
    private long   type;

    /** 用户性别 */
    private String sex;

    /** 身份证 */
    private String idCardNumber;

    /** 用户联系方式 */
    private String contactPhone;

    /** 用户邮箱 */
    private String email;

    /** 面部资料 */
    private String faceId;

    /** 人脸标识 */
    private String faceToken;

    /** 创建时间 */
    private Date   createTime;

    /** 修改时间 */
    private Date   modifyTime;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public Double getAccount() {
        return account;
    }

    public void setAccount(Double account) {
        this.account = account;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public long getType() {
        return type;
    }

    public void setType(long type) {
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

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFaceId() {
        return faceId;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId;
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

    @Override
    public String toString() {
        return "UserDO{" +
            "id=" + id +
            ", departmentId=" + departmentId +
            ", account=" + account +
            ", number=" + number +
            ", age=" + age +
            ", password='" + password + '\'' +
            ", name='" + name + '\'' +
            ", type=" + type +
            ", sex='" + sex + '\'' +
            ", idCardNumber='" + idCardNumber + '\'' +
            ", contactPhone='" + contactPhone + '\'' +
            ", email='" + email + '\'' +
            ", faceId='" + faceId + '\'' +
            ", faceToken='" + faceToken + '\'' +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
