package com.altersoftware.hotel.entity;

import java.util.Date;

public class PermissionUserDO {

    /** 主键 */
    private long id;
    /** 用户id */
    private long userId;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
        return "PermissionUserDO [id=" + id + ", userId=" + userId + ", permissionId=" + permissionId + ", createTime="
            + createTime + ", modifyTime=" + modifyTime + "]";
    }
}
