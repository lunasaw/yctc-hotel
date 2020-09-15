package com.altersoftware.hotel.vo;

/**
 * 更新密码VO
 *
 * @author 15272
 */
public class UpdatePasswordVO {

    /** 原密码 */
    private String oldPassword;

    /** 新密码 */
    private String newPassword;

    /** 确认新密码 */
    private String confirmNewPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UpdatePasswordVO [oldPassword=");
        builder.append(oldPassword);
        builder.append(", newPassword=");
        builder.append(newPassword);
        builder.append(", confirmNewPassword=");
        builder.append(confirmNewPassword);
        builder.append("]");
        return builder.toString();
    }
}
