package com.altersoftware.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.altersoftware.hotel.entity.RoomTypeDO;

/**
 * @author czy@win10
 * @date 2020/2/2 13:49
 */
@Mapper
public interface RoomTypeDAO {
    /**
     * 插入一条房间类别信息
     * 
     * @param roomTypeDO
     */
    @Insert(" INSERT INTO tb_room_type (id, room_Type, type_picture, type_name, user_number, wide, add_bed, description, create_time, modify_time ) "
        +
        "VALUES(#{id}, #{roomType}, #{picture}, #{name}, #{userNumber}, #{wide}, #{addBed}, #{description}, now(), now()) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(RoomTypeDO roomTypeDO);

    /**
     * id查找房间类别消息
     *
     * @param id
     */
    @Select("select id, room_Type, type_name, type_picture, user_number, description,  wide, add_bed, create_time, modify_time from tb_room_type where id=#{id}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "roomType", column = "room_Type"),
        @Result(property = "name", column = "type_name"),
        @Result(property = "picture", column = "type_picture"),
        @Result(property = "userNumber", column = "user_number"),
        @Result(property = "description", column = "description"),
        @Result(property = "wide", column = "wide"),
        @Result(property = "addBed", column = "add_bed"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    RoomTypeDO getRoomTypeDOById(long id);

    /**
     * 更新房间类别消息
     *
     * @param roomTypeDO
     */
    @Update("update tb_room_type  set room_Type=#{roomType}, type_name=#{name}, type_picture=#{picture}, user_number=#{userNumber}, description=#{description},  wide=#{wide}, add_bed=#{addBed}, modify_time=now()  where id=#{id}")
    int update(RoomTypeDO roomTypeDO);

    /**
     * 根据id删除一条房间类别消息
     *
     * @param id
     */
    @Delete("DELETE FROM tb_room_type WHERE id=#{id}")
    int deleteById(long id);

    /**
     * id查找房间类别消息
     *
     * @return
     */
    @Select("select id, room_Type, type_name, type_picture, user_number, description,  wide, add_bed, create_time, modify_time from tb_room_type ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "roomType", column = "room_Type"),
        @Result(property = "name", column = "type_name"),
        @Result(property = "picture", column = "type_picture"),
        @Result(property = "userNumber", column = "user_number"),
        @Result(property = "description", column = "description"),
        @Result(property = "wide", column = "wide"),
        @Result(property = "addBed", column = "add_bed"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<RoomTypeDO> getRoomTypeDOList();

}
