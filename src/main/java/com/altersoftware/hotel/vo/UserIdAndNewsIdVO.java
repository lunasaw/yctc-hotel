package com.altersoftware.hotel.vo;

/**
 * 接收userId和newsId的VO
 * 
 * @author 15272
 */
public class UserIdAndNewsIdVO {

    /** 接收的userId */
    private String userId;
    /** 接收的newsId */
    private String newsId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserIdAndNewsIdVO [userId=");
        builder.append(userId);
        builder.append(", newsId=");
        builder.append(newsId);
        builder.append("]");
        return builder.toString();
    }
}
