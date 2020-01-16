package com.altersoftware.hotel.service;

import com.altersoftware.hotel.entity.NewsDO;
import com.altersoftware.hotel.entity.ResultDO;

import java.util.List;
import java.util.Map;

/**
 * 发送 消息通知业务接口
 * 
 * @author 15272
 */
public interface NewsIService {

    /**
     * 给用户集中的所有用户推送消息集中的所有消息
     * 
     * @param userIdList
     * @param newsIdList
     * @return
     */
    public ResultDO<Void> sendNewsToUser(List<Long> userIdList, List<Long> newsIdList);

    /**
     * 向数据库中添加一条消息返回id
     * 
     * @param title
     * @param content
     * @return
     */
    public ResultDO<Long> putNewsToDB(String title, String content);

    /**
     * 移除用户集中用户的消息集中的信息
     * 
     * @param userIdList
     * @param newsIdList
     * @return
     */
    public ResultDO<Void> removeUserNews(List<Long> userIdList, List<Long> newsIdList);

    /**
     * 通过userId得到消息
     * 
     * @param userId
     * @return
     */
    public ResultDO<Map<Integer, List<NewsDO>>> getUserNews(long userId);

    /**
     * 通过用户id和信息id更改信息阅读状态
     * 
     * @param userId
     * @param newsId
     * @param state
     * @return
     */
    public ResultDO<Void> setNewsStateByUserIdAndNewsId(long userId, long newsId, int state);

    /**
     * 向用户推送消息
     * 
     * @param userIdList
     * @param title
     * @param content
     * @return
     */
    public ResultDO<Void> sendNewsTOUserList(List<Long> userIdList, String title, String content);

    /**
     * 变成已读
     * 
     * @param userId
     * @param newsId
     * @return
     */
    public ResultDO<Void> turnTOReaded(long userId, long newsId);

    /**
     * 变成未读
     * 
     * @param userId
     * @param newsId
     * @return
     */
    public ResultDO<Void> turnToUnread(long userId, long newsId);

    /**
     * 全部标记为已读
     * 
     * @param userId
     * @return
     */
    public ResultDO<Void> turnAllToReaded(long userId);

    /**
     * 全部标记为未读
     * 
     * @param userId
     * @return
     */
    public ResultDO<Void> turnAlltoUnread(long userId);

    /**
     * 通过id返回newsDO
     * 
     * @param id
     * @return
     */
    public ResultDO<NewsDO> getNewsDOById(long id);

    /**
     * 删除所有已读通知
     * 
     * @param userId
     * @return
     */
    public ResultDO<Void> deleteAllReadedNewsByUserId(long userId);
}
