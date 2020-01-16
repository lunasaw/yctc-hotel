package com.altersoftware.hotel.vo;

/**
 * 授权操作VO
 *
 * @author wlt
 */
public class AuthorizationVO {

    /** 被操作权限的用户的账号 */
    private String userNumber;

    /** 操作的权限名 */
    private String permissionName;

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AuthorizationVO [userNumber=");
        builder.append(userNumber);
        builder.append(", permissionName=");
        builder.append(permissionName);
        builder.append("]");
        return builder.toString();
    }
}
