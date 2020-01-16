package com.altersoftware.hotel.entity;

import java.util.Date;

public class PermissionDO {

    /** 权限id */
    private long id;
    /** 权限名 */
    private String name;
    /** 创建时间 */
    private Date createTime;
    /** 修改时间 */
    private Date modifyTime;
    /** resource */
    private String resource;

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

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PermissionDO [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", modifyTime=");
        builder.append(modifyTime);
        builder.append(", resource=");
        builder.append(resource);
        builder.append("]");
        return builder.toString();
    }

}
