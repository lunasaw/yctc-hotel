package com.altersoftware.hotel.entity;

import java.util.Date;

public class UserNewsDO {

    /** 主键 */
    private long id;

    /** 用户id */
    private long userId;

    /** 消息id */
    private long newsId;

    /** 阅读状态 */
    private int state;

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

    public long getNewsId() {
        return newsId;
    }

    public void setNewsId(long newsId) {
        this.newsId = newsId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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
        StringBuilder builder = new StringBuilder();
        builder.append("UserNewsDO [id=");
        builder.append(id);
        builder.append(", userId=");
        builder.append(userId);
        builder.append(", newsId=");
        builder.append(newsId);
        builder.append(", state=");
        builder.append(state);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", modifyTime=");
        builder.append(modifyTime);
        builder.append("]");
        return builder.toString();
    }

}
