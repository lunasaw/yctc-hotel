package com.altersoftware.hotel.vo;

import java.util.List;

public class PermissionGroupNameAndPermissionIdsVO {
	private long id;
    /** 权限组的名字 */
    private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/** 可拥有的新权限ids */


    private List<Long> permissonIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
	    builder.append(id);
	    builder.append(", id=");
	    builder.append(", permissonIds=");
        builder.append(permissonIds);
        builder.append("]");
        return builder.toString();
    }

}
