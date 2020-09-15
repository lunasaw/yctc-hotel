package com.altersoftware.hotel.dao;

import org.apache.ibatis.annotations.*;

import com.altersoftware.hotel.entity.HotelDO;

/**
 * @author czy@win10
 * @date 2020/1/25 20:04
 */
@Mapper
public interface HotelDAO {

    /**
     * 插入一条酒店消息
     *
     * @param hotelDO
     */
    @Insert(" INSERT INTO tb_hotel (id, name, floornumbers, roomnumbers, mobile, address, rules, create_time, modify_time ) "
        +
        "VALUES(#{id}, #{name}, #{floorNumbers}, #{roomNumbers}, #{mobile}, #{address}, #{rules}, now(), now()) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(HotelDO hotelDO);

    /**
     * id查找酒店消息
     *
     * @param id
     */
    @Select("select id, name, floornumbers, roomnumbers, mobile, address, rules, create_time, modify_time from tb_hotel where id=#{id}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "floorNumbers", column = "floornumbers"),
        @Result(property = "roomNumbers", column = "roomnumbers"),
        @Result(property = "mobile", column = "mobile"),
        @Result(property = "address", column = "address"),
        @Result(property = "rules", column = "rules"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    HotelDO getHotelDOById(long id);

    /**
     * 更新酒店消息
     *
     * @param hotelDO
     */
    @Update("update tb_hotel  set name=#{name}, floornumbers=#{floorNumbers}, roomnumbers=#{roomNumbers}, mobile=#{mobile}, address=#{address}, rules=#{rules}, modify_time=now()  where id=#{id}")
    int update(HotelDO hotelDO);

    /**
     * 根据id删除一条酒店消息
     *
     * @param id
     */
    @Delete("DELETE FROM tb_hotel WHERE id=#{id}")
    int deleteById(long id);
}
