package com.altersoftware.hotel.vo;

import com.altersoftware.hotel.entity.UserDO;

public class UserInformationVO {

    /** userDO */
    private UserDO userDO;
    /** 学院名 */
    private String academyName;
    /** 班级名 */
    private String className;

    public UserDO getUserDO() {
        return userDO;
    }

    public void setUserDO(UserDO userDO) {
        this.userDO = userDO;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserInformationVO [userDO=");
        builder.append(userDO);
        builder.append(", academyName=");
        builder.append(academyName);
        builder.append(", className=");
        builder.append(className);
        builder.append("]");
        return builder.toString();
    }

}
