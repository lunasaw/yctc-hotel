package com.altersoftware.hotel.entity;

import java.util.Date;

public class PermissionGroupDO {

    /** 权限组id */
    private long id;
    /** 权限组名 */
    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "PermissionGroupDO [id=" + id + ", name=" + name + ", createTime=" + createTime + ", modifyTime="
            + modifyTime + "]";
    }
}
