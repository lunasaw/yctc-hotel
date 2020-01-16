package com.altersoftware.hotel.dao;

import com.altersoftware.hotel.entity.UserNewsDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;



@Mapper
public interface UserNewsDAO {

    /**
     * 插入一条用户消息
     * 
     * @param userNewsDO
     */
    public void insert(UserNewsDO userNewsDO);

    /**
     * 通过id得到用户消息
     * 
     * @param id
     * @return
     */
    public UserNewsDO getUserNewsDOById(long id);

    /**
     * 更新一条用户消息
     * 
     * @param userNewsDO
     */
    public void update(UserNewsDO userNewsDO);

    /**
     * 通过id删除一条用户消息
     * 
     * @param id
     */
    public void deleteById(long id);

    /**
     * 通过用户id得到用户消息
     * 
     * @param userId
     * @return
     */
    public List<Long> getNewsIdByUserId(long userId);

    /**
     * 通过用户id和消息id得到tUserNewsDO
     * 
     * @param userId
     * @param newsId
     * @return
     */
    public UserNewsDO getUserNewsDOByUserIdAndNewsId(long userId, long newsId);

    /**
     * 通过用户id得到用户未读信息的id
     * 
     * @param userId
     * @return
     */
    public List<Long> getNoReadNewsIdByUserId(long userId);

    /**
     * 通过用户id和消息id更新消息查看状态
     * 
     * @param userId
     * @param newsId
     * @param state
     */
    public void updateStateByUserIdAndNewsId(long userId, long newsId, int state);

    /**
     * 通过用户id得到用户已读信息的id
     * 
     * @param userId
     * @return
     */
    public List<Long> getReadedNewsIdByUserId(long userId);

    /**
     * 通过用户id和信息id删除一条记录
     * 
     * @param userId
     * @param newsId
     * @return
     */
    public void deletByUserIdAndNewsId(long userId, long newsId);

    /**
     * 删除所有已读通知
     * 
     * @param userId
     */
    public void deleteAllReadedNewsByUserId(long userId);
}
