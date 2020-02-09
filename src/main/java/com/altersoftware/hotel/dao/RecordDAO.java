package com.altersoftware.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.altersoftware.hotel.entity.RecordDO;

/**
 * @author Iszychen@win10
 * @date 2020/2/7 14:23
 */
@Mapper
public interface RecordDAO {
    /**
     * 插入一条订单信息
     *
     *
     */
    @Insert(" INSERT INTO tb_record (id, room_number, customer_id, staff_id, pay_money, state, record_checkintime, record_checkouttime, pre_checkintime, record_evaluate, create_time, modify_time ) "
        +
        "VALUES(#{id}, #{roomNumber}, #{customerId}, #{staffId}, #{payMoney}, #{state}, #{checkInTime}, #{checkOutTime}, #{precheckInTime}, #{evaluate}, now(), now()) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(RecordDO recordDO);

    /**
     * id查找订单消息
     *
     * @param id
     * @return
     */
    @Select("select id, room_number, customer_id, staff_id, pay_money, state, record_checkintime, record_checkouttime,  pre_checkintime, record_evaluate,  create_time, modify_time from tb_record where id=#{id}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "roomNumber", column = "room_number"),
        @Result(property = "customerId", column = "customer_id"),
        @Result(property = "staffId", column = "staff_id"),
        @Result(property = "payMoney", column = "pay_money"),
        @Result(property = "state", column = "state"),

        @Result(property = "checkInTime", column = "record_checkintime"),
        @Result(property = "checkOutTime", column = "record_checkouttime"),
        @Result(property = "precheckInTime", column = "pre_checkintime"),
        @Result(property = "evaluate", column = "record_evaluate"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    RecordDO getRecordDOById(long id);

    /**
     * 查询所有订单信息
     *
     *
     * @return
     */
    @Select("select id, room_number, customer_id, staff_id, pay_money, state, record_checkintime, record_checkouttime,  pre_checkintime, record_evaluate,  create_time, modify_time from tb_record")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "roomNumber", column = "room_number"),
        @Result(property = "customerId", column = "customer_id"),
        @Result(property = "staffId", column = "staff_id"),
        @Result(property = "payMoney", column = "pay_money"),
        @Result(property = "state", column = "state"),
        @Result(property = "checkInTime", column = "record_checkintime"),
        @Result(property = "checkOutTime", column = "record_checkouttime"),
        @Result(property = "precheckInTime", column = "pre_checkintime"),
        @Result(property = "evaluate", column = "record_evaluate"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<RecordDO> getAll();

    /**
     * 更新订单消息
     *
     * @param floorDO
     */
    @Update("update tb_record  set room_number=#{roomNumber}, customer_id=#{customerId}, staff_id=#{staffId}," +
        "pay_money=#{payMoney}, state=#{state}, record_checkintime=#{checkInTime}, record_checkouttime=#{checkOutTime}, pre_checkintime=#{precheckInTime}, record_evaluate=#{evaluate}, modify_time=now()  where id=#{id}")
    int update(RecordDO floorDO);

    /**
     * 根据id删除一条订单消息
     *
     * @param id
     */
    @Delete("DELETE FROM tb_record WHERE id=#{id}")
    int deleteById(long id);

    /**
     * 根据房间客房号查询所属订单
     *
     * @param roomNumber
     * @return
     */
    @Select("select id, room_number, customer_id, staff_id, pay_money, state,  record_checkintime, record_checkouttime,  pre_checkintime, record_evaluate,  create_time, modify_time from tb_record where room_number=#{room_number}")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "roomNumber", column = "room_number"),
        @Result(property = "customerId", column = "customer_id"),
        @Result(property = "staffId", column = "staff_id"),
        @Result(property = "payMoney", column = "pay_money"),
        @Result(property = "state", column = "state"),
        @Result(property = "checkInTime", column = "record_checkintime"),
        @Result(property = "checkOutTime", column = "record_checkouttime"),
        @Result(property = "precheckInTime", column = "pre_checkintime"),
        @Result(property = "evaluate", column = "record_evaluate"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<RecordDO> getRecordDOByRoomNumber(int roomNumber);

    /**
     * 根据处理订单员工查询所属订单
     *
     * @param staffId
     * @return
     */
    @Select("select id, room_number, customer_id, staff_id, pay_money, state, record_checkintime, record_checkouttime,  pre_checkintime, "
        +
        "record_evaluate,  create_time, modify_time from tb_record where staff_id=#{staffId}")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "roomNumber", column = "room_number"),
        @Result(property = "customerId", column = "customer_id"),
        @Result(property = "staffId", column = "staff_id"),
        @Result(property = "payMoney", column = "pay_money"),
        @Result(property = "state", column = "state"),
        @Result(property = "checkInTime", column = "record_checkintime"),
        @Result(property = "checkOutTime", column = "record_checkouttime"),
        @Result(property = "precheckInTime", column = "pre_checkintime"),
        @Result(property = "evaluate", column = "record_evaluate"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<RecordDO> getRecordDOByStaffId(long staffId);

    /**
     * 根据客户会员号查询所属订单
     *
     * @param customerId
     * @return
     */
    @Select("select id, room_number, customer_id, staff_id, pay_money, state, record_checkintime, record_checkouttime,  pre_checkintime, "
        +
        "record_evaluate,  create_time, modify_time from tb_record where customer_id=#{customerId}")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "roomNumber", column = "room_number"),
        @Result(property = "customerId", column = "customer_id"),
        @Result(property = "staffId", column = "staff_id"),
        @Result(property = "payMoney", column = "pay_money"),
        @Result(property = "state", column = "state"),
        @Result(property = "checkInTime", column = "record_checkintime"),
        @Result(property = "checkOutTime", column = "record_checkouttime"),
        @Result(property = "precheckInTime", column = "pre_checkintime"),
        @Result(property = "evaluate", column = "record_evaluate"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<RecordDO> getRecordDOByCustomerId(long customerId);
}
