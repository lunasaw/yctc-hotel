package com.altersoftware.hotel.entity;

import java.util.Date;

public class PermissionGroupPermissionDO {

    /** 主键 */
    private long id;
    /** 权限组id */
    private long permissionGroupId;
    /** 权限id */
    private long permissionId;
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

    public long getPermissionGroupId() {
        return permissionGroupId;
    }

    public void setPermissionGroupId(long permissionGroupId) {
        this.permissionGroupId = permissionGroupId;
    }

    public long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(long permissionId) {
        this.permissionId = permissionId;
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
        return "PermissionGroupPermissionDO [id=" + id + ", permissionGroupId=" + permissionGroupId + ", permissionId="
            + permissionId + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
    }
}
