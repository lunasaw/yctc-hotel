package com.altersoftware.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.altersoftware.hotel.entity.UserNewsDO;

@Mapper
public interface UserNewsDAO {

    /**
     * 插入一条用户消息
     * 
     * @param userNewsDO
     */
    @Insert(" INSERT INTO tb_user_news (id, user_id, news_id, state, create_time, modify_time ) "
        +
        "VALUES(#{id}, #{userId}, #{newsId}, #{state}, now(), now()) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(UserNewsDO userNewsDO);

    /**
     * 通过id得到用户消息
     * 
     * @param id
     * @return
     */
    @Select("select id, user_id, news_id, state, create_time, modify_time from tb_user_news where id=#{id}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "userId", column = "user_id"),
        @Result(property = "newsId", column = "news_id"),
        @Result(property = "state", column = "state"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    UserNewsDO getUserNewsDOById(long id);

    /**
     * 更新一条用户消息
     * 
     * @param userNewsDO
     */
    @Update("update tb_user_news  set user_id=#{userId}, news_id=#{newsId}, state=#{state}, modify_time=now()  where id=#{id}")
    int update(UserNewsDO userNewsDO);

    /**
     * 通过id删除一条用户消息
     * 
     * @param id
     */
    @Delete("DELETE FROM tb_user_news WHERE id=#{id}")
    void deleteById(long id);

    /**
     * 通过用户id得到用户消息
     * 
     * @param userId
     * @return
     */
    @Select("select  news_id from tb_user_news where id=#{id}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "userId", column = "user_id"),
        @Result(property = "newsId", column = "news_id"),
        @Result(property = "state", column = "state"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<Long> getNewsIdByUserId(long userId);

    /**
     * 通过用户id和消息id得到tUserNewsDO
     * 
     * @param userId
     * @param newsId
     * @return
     */
    @Select("select id, user_id, news_id, state, create_time, modify_time from tb_user_news where user_id=#{userId}  and news_id=#{newsId} ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "userId", column = "user_id"),
        @Result(property = "newsId", column = "news_id"),
        @Result(property = "state", column = "state"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    UserNewsDO getUserNewsDOByUserIdAndNewsId(long userId, long newsId);

    /**
     * 通过用户id得到用户未读信息的id
     * 
     * @param userId
     * @return
     */
    @Select("select news_id  from tb_user_news where state=1 ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "userId", column = "user_id"),
        @Result(property = "newsId", column = "news_id"),
        @Result(property = "state", column = "state"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<Long> getNoReadNewsIdByUserId(long userId);

    /**
     * 通过用户id和消息id更新消息查看状态
     * 
     * @param userId
     * @param newsId
     * @param state
     */
    @Update("update tb_user_news  set  state=0 ,modify_time=now()  where  user_id=#{userId} and news_id=#{newsId} and state=#{state}")
    int updateStateByUserIdAndNewsId(long userId, long newsId, int state);

    /**
     * 通过用户id得到用户已读信息的id
     * 
     * @param userId
     * @return
     */
    @Select("select news_id  from tb_user_news where state=0 ")
    List<Long> getReadedNewsIdByUserId(long userId);

    /**
     * 通过用户id和信息id删除一条记录
     * 
     * @param userId
     * @param newsId
     * @return
     */
    @Delete("DELETE FROM tb_user_news WHERE  user_id=#{userId} and news_id=#{newsId}")
    void deletByUserIdAndNewsId(long userId, long newsId);

    /**
     * 删除所有已读通知
     * 
     * @param userId
     */
    @Delete("DELETE FROM tb_user_news WHERE  state=0 and user_id=#{userId} ")
    void deleteAllReadedNewsByUserId(long userId);
}
