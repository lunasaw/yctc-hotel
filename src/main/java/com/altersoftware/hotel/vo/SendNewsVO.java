package com.altersoftware.hotel.vo;

import java.util.List;

/**
 * 推送消息VO
 *
 * @author 15272
 */
public class SendNewsVO {

    /** 待发送用户集 */
    private List<Long> userIdList;

    /** 消息标题 */
    private String title;

    /** 消息正文 */
    private String content;

    public List<Long> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<Long> userIdList) {
        this.userIdList = userIdList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SendNewsVO [userIdList=");
        builder.append(userIdList);
        builder.append(", title=");
        builder.append(title);
        builder.append(", content=");
        builder.append(content);
        builder.append("]");
        return builder.toString();
    }
}
