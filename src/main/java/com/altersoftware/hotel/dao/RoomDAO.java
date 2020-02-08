package com.altersoftware.hotel.dao;

import java.util.List;

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
    @Insert(" INSERT INTO tb_room (id, floor_id, room_number,  type, price, deposit, state, create_time, modify_time ) "
        +
        "VALUES(#{id}, #{floorId}, #{roomNumber},  #{type}, #{price}, #{deposit}, #{state},  now(), now()) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(RoomDO roomDO);

    /**
     * id查找房间消息
     *
     * @param id
     */
    @Select("select id, floor_id, room_number,  type, price, deposit, state,  create_time, modify_time from tb_room where id=#{id}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "floorId", column = "floor_id"),
        @Result(property = "roomNumber", column = "room_number"),
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
    @Update("update tb_room  set floor_id=#{floorId}, room_number=#{roomNumber},  type=#{type}, price=#{price}, deposit=#{deposit}, state=#{state},  modify_time=now()  where id=#{id}")
    int update(RoomDO roomDO);

    /**
     * 根据id删除一条房间消息
     *
     * @param id
     */
    @Delete("DELETE FROM tb_room WHERE id=#{id}")
    int deleteById(long id);

    /**
     * 获取全部房间信息
     *
     * @return
     */
    @Select("select id, floor_id, room_number,  type, price, deposit, state,  create_time, modify_time from tb_room ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "floorId", column = "floor_id"),
        @Result(property = "roomNumber", column = "room_number"),
        @Result(property = "type", column = "type"),
        @Result(property = "price", column = "price"),
        @Result(property = "deposit", column = "deposit"),
        @Result(property = "state", column = "state"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<RoomDO> getAllRoomDo();

    /**
     * 通过房间号查询房间信息
     * 
     * @param roomNumber
     * @return
     */
    @Select("select id, floor_id, room_number,  type, price, deposit, state,  create_time, modify_time from tb_room where room_number=#{roomNumber}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "floorId", column = "floor_id"),
        @Result(property = "roomNumber", column = "room_number"),
        @Result(property = "type", column = "type"),
        @Result(property = "price", column = "price"),
        @Result(property = "deposit", column = "deposit"),
        @Result(property = "state", column = "state"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    RoomDO getRoomDOByNumber(int roomNumber);

    /**
     * 类别查找房间List
     *
     * @param roomTypeName
     */
    @Select("select id, floor_id, room_number,  type, price, deposit, state,  create_time, modify_time from tb_room where type=#{roomTypeName}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "floorId", column = "floor_id"),
        @Result(property = "roomNumber", column = "room_number"),
        @Result(property = "type", column = "type"),
        @Result(property = "price", column = "price"),
        @Result(property = "deposit", column = "deposit"),
        @Result(property = "state", column = "state"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<RoomDO> getRoomDOByRoomType(String roomTypeName);

}
