package com.altersoftware.hotel.entity;

import java.util.Date;

public class StaffDO {

    /** 主键员工号 */
    private long   id;

    /** 员工姓名 */
    private String name;

    /** 部门号码 */
    private long   departmenID;

    /** 权限组id */
    private long   permissionGroupId;

    /** 员工性别 */
    private String sex;

    /** 员工年龄 */
    private int    age;

    /** 员工联系方式 */
    private long   contactPhone;

    /** 员工账号 */
    private long   account;

    /** 员工密码 */
    private String password;

    /** 面部资料 */
    private String faceID;

    /** 员工邮箱 */
    private String mail;

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

    public long getDepartmenID() {
        return departmenID;
    }

    public void setDepartmenID(long departmenID) {
        this.departmenID = departmenID;
    }

    public long getPermissionGroupId() {
        return permissionGroupId;
    }

    public void setPermissionGroupId(long permissionGroupId) {
        this.permissionGroupId = permissionGroupId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(long contactPhone) {
        this.contactPhone = contactPhone;
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

    public String getFaceID() {
        return faceID;
    }

    public void setFaceID(String faceID) {
        this.faceID = faceID;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
        return "StaffDO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", departmenID=" + departmenID +
            ", permissionGroupId=" + permissionGroupId +
            ", sex='" + sex + '\'' +
            ", age=" + age +
            ", contactPhone=" + contactPhone +
            ", account=" + account +
            ", password='" + password + '\'' +
            ", faceID='" + faceID + '\'' +
            ", mail='" + mail + '\'' +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
