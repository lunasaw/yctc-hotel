package com.altersoftware.hotel.dao;

import org.apache.ibatis.annotations.*;

import com.altersoftware.hotel.entity.NewsDO;

/**
 * @author czy@win10
 * @date 2020/1/25 20:04
 */
public interface HotelDAO {

    /**
     * 插入一条消息
     *
     * @param newsDO
     */
    @Insert(" INSERT INTO tb_hotel (id, title, content, create_time, modify_time ) "
        +
        "VALUES(#{id}, #{title}, #{content}, NOW(), NOW()) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(NewsDO newsDO);

    /**
     * id查找消息
     *
     * @param id
     */
    @Select("select id, title, content, create_time, modify_time from tb_news where id=#{id}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "title", column = "title"),
        @Result(property = "content", column = "content"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    NewsDO getNewsDOById(long id);

    /**
     * 更新消息
     *
     * @param newsDO
     */
    @Update("update tb_news  set title=#{title}, content=#{content}, modify_time=now()  where id=#{id}")
    int update(NewsDO newsDO);

    /**
     * 根据id删除一条消息
     *
     * @param id
     */
    @Delete("DELETE FROM tb_news WHERE id=#{id}")
    void deleteById(long id);
}
