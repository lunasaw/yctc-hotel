package com.altersoftware.hotel.vo;


import com.altersoftware.hotel.entity.NewsDO;

public class NewsDOAndUrlVO {

    /** newsDO */
    private NewsDO newsDO;
    /** url */
    private String url;

    public NewsDO getNewsDO() {
        return newsDO;
    }

    public void setNewsDO(NewsDO newsDO) {
        this.newsDO = newsDO;
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
        builder.append("NewsDOAndUrlVO [newsDO=");
        builder.append(newsDO);
        builder.append(", url=");
        builder.append(url);
        builder.append("]");
        return builder.toString();
    }

}
