package com.altersoftware.hotel.dao;

import org.apache.ibatis.annotations.*;

import com.altersoftware.hotel.entity.RoomDO;

/**
 * @author czy@win10
 * @date 2020/1/27 15:53
 */
@Mapper
public interface RoomDAO {

    /**
     * 插入一条房间信息
     *
     *
     */
    @Insert(" INSERT INTO tb_room (id, floor_id, type, price, deposit, state, create_time, modify_time ) "
        +
        "VALUES(#{id}, #{floorId}, #{type}, #{price}, #{deposit}, #{state},  now(), now()) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(RoomDO roomDO);

    /**
     * id查找房间消息
     *
     * @param id
     */
    @Select("select id, floor_id, type, price, deposit, state,  create_time, modify_time from tb_room where id=#{id}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "floorId", column = "floor_id"),
        @Result(property = "type", column = "type"),
        @Result(property = "price", column = "price"),
        @Result(property = "deposit", column = "deposit"),
        @Result(property = "state", column = "state"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    RoomDO getRoomDOById(long id);

    /**
     * 更新房间消息
     *
     * @param roomDO
     */
    @Update("update tb_room  set floor_id=#{floorId}, type=#{type}, price=#{price}, deposit=#{deposit}, state=#{state},  modify_time=now()  where id=#{id}")
    int update(RoomDO roomDO);

    /**
     * 根据id删除一条房间消息
     *
     * @param id
     */
    @Delete("DELETE FROM tb_room WHERE id=#{id}")
    int deleteById(long id);

}
