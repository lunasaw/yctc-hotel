package com.altersoftware.hotel.vo;


import com.altersoftware.hotel.entity.UserDO;

public class StudentDOAndUrlVO {

    /** userDO */
    private UserDO userDO;
    /** url */
    private String url;

    public UserDO getUserDO() {
        return userDO;
    }

    public void setUserDO(UserDO userDO) {
        this.userDO = userDO;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("StudentDOAndUrlVO [studentDO=");
        builder.append(userDO);
        builder.append(", url=");
        builder.append(url);
        builder.append("]");
        return builder.toString();
    }
}
