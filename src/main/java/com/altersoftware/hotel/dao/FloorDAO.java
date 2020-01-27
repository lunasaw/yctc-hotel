package com.altersoftware.hotel.dao;

import org.apache.ibatis.annotations.*;

import com.altersoftware.hotel.entity.FloorDO;

/**
 * @author czy@win10
 * @date 2020/1/26 13:49
 */
@Mapper
public interface FloorDAO {
    /**
     * 插入一条楼层信息
     * 
     * 
     */
    @Insert(" INSERT INTO tb_floor (id, roomnumbers, plan_diagram, fireevacuation_diagram, three_d_diagram, create_time, modify_time ) "
        +
        "VALUES(#{id}, #{roomNumbers}, #{plan}, #{fireDiagram}, #{threeDDiagram}, now(), now()) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(FloorDO floorDO);

    /**
     * id查找酒店消息
     *
     * @param id
     */
    @Select("select id, roomnumbers, plan_diagram, fireevacuation_diagram, three_d_diagram, create_time, modify_time from tb_floor where id=#{id}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "roomNumbers", column = "roomnumbers"),
        @Result(property = "plan", column = "plan_diagram"),
        @Result(property = "fireDiagram", column = "fireevacuation_diagram"),
        @Result(property = "threeDDiagram", column = "three_d_diagram"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    FloorDO getFloorDOById(long id);

    /**
     * 更新酒店消息
     *
     * @param floorDO
     */
    @Update("update tb_floor  set roomnumbers=#{roomNumbers}, plan_diagram=#{plan}, fireevacuation_diagram=#{fireDiagram}, three_d_diagram=#{threeDDiagram}, modify_time=now()  where id=#{id}")
    int update(FloorDO floorDO);

    /**
     * 根据id删除一条酒店消息
     *
     * @param id
     */
    @Delete("DELETE FROM tb_floor WHERE id=#{id}")
    int deleteById(long id);
}
