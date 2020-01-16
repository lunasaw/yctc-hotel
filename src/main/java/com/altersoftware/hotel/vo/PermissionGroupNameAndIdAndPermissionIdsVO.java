package com.altersoftware.hotel.vo;

import java.util.List;

public class PermissionGroupNameAndIdAndPermissionIdsVO {

    /** 权限组的新名字 */
    private String name;
    /** 权限组的原Id */
    private Long id;
    /** 可拥有的新权限ids */
    private List<Long> permissonIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getPermissonIds() {
        return permissonIds;
    }

    public void setPermissonIds(List<Long> permissonIds) {
        this.permissonIds = permissonIds;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PermissionGroupNameAndPermissionIdsVO [name=");
        builder.append(name);
        builder.append(", id=");
        builder.append(id);
        builder.append(", permissonIds=");
        builder.append(permissonIds);
        builder.append("]");
        return builder.toString();
    }

}
