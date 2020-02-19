package com.altersoftware.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.altersoftware.hotel.entity.RoomGoodsDO;

/**
 * @author Iszychen@win10
 * @date 2020/2/18 23:13
 */
@Mapper
public interface RoomGoodsDAO {
    /**
     * 插入一条物品状态信息
     *
     *
     */
    @Insert(" INSERT INTO tb_room_goods ( room_number, goods_name, state,  create_time, modify_time ) "
        +
        "VALUES(  #{roomNumber}, #{goodsName}, #{state}, now(), now()) ")
    void insert(RoomGoodsDO roomGoodsDO);

    /**
     * 根据房间和房间物品查找房间状态
     *
     * @param roomNumber
     * @param goodsName
     * @return
     */
    @Select("select  room_number, goods_name, state,  create_time, modify_time from tb_room_goods where room_number=#{roomNumber} and goods_name=#{goodsName}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "roomNumber", column = "room_number"),
        @Result(property = "goodsName", column = "goods_name"),
        @Result(property = "state", column = "state"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    RoomGoodsDO getRoomGoodsDOByRoomNumberAndGoodsName(@Param("roomNumber") int roomNumber,
        @Param("goodsName") String goodsName);

    /**
     * 查找房间物品状态List消息
     *
     */
    @Select("select  room_number, goods_name, state, create_time, modify_time from tb_room_goods where room_number=#{roomNumber}")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "roomNumber", column = "room_number"),
        @Result(property = "goodsName", column = "goods_name"),
        @Result(property = "state", column = "state"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<RoomGoodsDO> getGoodsStateListByRoom(int roomNumber);

    /**
     * 查询一个物品对应的所有房间的状态
     *
     * @return
     */
    @Select("select  room_number, goods_name, state, create_time, modify_time from tb_room_goods where goods_name=#{goodsName}")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "roomNumber", column = "room_number"),
        @Result(property = "goodsName", column = "goods_name"),
        @Result(property = "state", column = "state"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<RoomGoodsDO> getOneGoodsStateListByName(String goodsName);

    /**
     * 更新物品状态消息
     *
     * @param roomGoodsDO
     */
    @Update("update tb_room_goods  set state=#{state}, modify_time=now()  where room_number=#{roomNumber} and goods_name=#{goodsName} ")
    int update(RoomGoodsDO roomGoodsDO);

    /**
     * 根据根据房间和房间物品删除一条物品状态消息
     *
     * @param roomNumber
     * @param goodsName
     * @return
     */
    @Delete("DELETE FROM tb_room_goods WHERE room_number=#{roomNumber} and goods_name=#{goodsName}")
    int deleteByRoomNumberAndGoodsName(@Param("roomNumber") int roomNumber, @Param("goodsName") String goodsName);

    /**
     * 根据房间编号删除一个房间的物品状态消息
     *
     * @param roomNumber
     * @return
     */
    @Delete("DELETE FROM room_number WHERE room_number=#{roomNumber} ")
    int deleteByRooomNumber(int roomNumber);

    /**
     * 查询所有物品状态信息
     * 
     * @return
     */
    @Select("select  room_number, goods_name, state, create_time, modify_time from tb_room_goods ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "roomNumber", column = "room_number"),
        @Result(property = "goodsName", column = "goods_name"),
        @Result(property = "state", column = "state"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<RoomGoodsDO> getAll();
}
