package com.altersoftware.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.altersoftware.hotel.entity.MealdistributionDO;

/**
 * @author czy@win10
 * @date 2020/1/30 16:03
 */
@Mapper
public interface MealdistributionDAO {
    /**
     * 插入一条配送订单信息
     *
     *
     */
    @Insert(" INSERT INTO tb_mealdistribution (id, room_id, staff_id, menu_id, mealdistribution_intime, mealdistribution_outtime, create_time, modify_time ) "
        +
        "VALUES(#{id}, #{roomId}, #{staffId}, #{menuId}, #{inTime}, #{outTime}, now(), now()) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(MealdistributionDO mealdistributionDO);

    /**
     * id查找配送订单消息
     *
     * @param id
     */
    @Select("select id, room_id, staff_id, menu_id, mealdistribution_intime, mealdistribution_outtime, create_time, modify_time from tb_mealdistribution where id=#{id}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "roomId", column = "room_id"),
        @Result(property = "staffId", column = "staff_id"),
        @Result(property = "menuId", column = "menu_id"),
        @Result(property = "inTime", column = "mealdistribution_intime"),
        @Result(property = "outTime", column = "mealdistribution_outtime"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    MealdistributionDO getMealdistributionDOById(long id);

    /**
     * 房间查找配送订单消息
     *
     * @param roomId
     */
    @Select("select id, room_id, staff_id, menu_id, mealdistribution_intime, mealdistribution_outtime, create_time, modify_time from tb_mealdistribution where room_id=#{roomId}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "roomId", column = "room_id"),
        @Result(property = "staffId", column = "staff_id"),
        @Result(property = "menuId", column = "menu_id"),
        @Result(property = "inTime", column = "mealdistribution_intime"),
        @Result(property = "outTime", column = "mealdistribution_outtime"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<MealdistributionDO> getMealdistributionDOByRoomId(long roomId);

    /**
     * 员工查找配送订单消息
     *
     * @param staffId
     */
    @Select("select id, room_id, staff_id, menu_id, mealdistribution_intime, mealdistribution_outtime, create_time, modify_time from tb_mealdistribution where staff_id=#{staffId}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "roomId", column = "room_id"),
        @Result(property = "staffId", column = "staff_id"),
        @Result(property = "menuId", column = "menu_id"),
        @Result(property = "inTime", column = "mealdistribution_intime"),
        @Result(property = "outTime", column = "mealdistribution_outtime"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<MealdistributionDO> getMealdistributionDOByStaffId(long staffId);

    /**
     * 菜单Id查找配送订单消息
     *
     * @param menuId
     */
    @Select("select id, room_id, staff_id, menu_id, mealdistribution_intime, mealdistribution_outtime, create_time, modify_time from tb_mealdistribution where menu_id=#{menuId}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "roomId", column = "room_id"),
        @Result(property = "staffId", column = "staff_id"),
        @Result(property = "menuId", column = "menu_id"),
        @Result(property = "inTime", column = "mealdistribution_intime"),
        @Result(property = "outTime", column = "mealdistribution_outtime"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    MealdistributionDO getMealdistributionDOByMenuId(long menuId);

    /**
     * 更新配送订单消息
     *
     * @param mealdistributionDO
     */
    @Update("update tb_mealdistribution  set room_id=#{roomId}, staff_id=#{staffId}, menu_id=#{menuId}, mealdistribution_intime=#{inTime}, mealdistribution_outtime=#{outTime}, modify_time=now()  where id=#{id}")
    int update(MealdistributionDO mealdistributionDO);

    /**
     * 开始配送
     *
     * @param staffId
     */
    @Update("update tb_mealdistribution  set mealdistribution_intime=now(), modify_time=now()  where staff_id=#{staffId}")
    int start(long staffId);

    /**
     * 完成配送
     *
     * @param staffId
     */
    @Update("update tb_mealdistribution  set mealdistribution_outtime=now(), modify_time=now()  where staff_id=#{staffId}")
    int end(long staffId);

    /**
     * 根据id删除一条配送订单消息
     *
     * @param id
     */
    @Delete("DELETE FROM tb_mealdistribution WHERE id=#{id}")
    int deleteById(long id);

    /**
     * 返回配送订单list
     *
     * @return
     */
    @Select("select id  from tb_mealdistribution ")
    List<Long> getFloorIdList();
}
