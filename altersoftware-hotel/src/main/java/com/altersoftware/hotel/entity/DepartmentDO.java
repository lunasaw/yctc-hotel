package com.altersoftware.hotel.entity;

import java.util.Date;

/**
 * @author czy@win10
 * @date 2020/1/20 15:46
 */
public class DepartmentDO {

    /** 部门编号 */
    private long   id;
    /** 部门名称 */
    private String name;
    /** 部门人数 */
    private int    staffNumbers;
    /** 部门负责人编号 */
    private long   staffId;
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

    public int getStaffNumbers() {
        return staffNumbers;
    }

    public void setStaffNumbers(int staffNumbers) {
        this.staffNumbers = staffNumbers;
    }

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
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
        return "DepartmentDO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", staffNumbers=" + staffNumbers +
            ", staffId=" + staffId +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
