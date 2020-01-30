package com.altersoftware.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.altersoftware.hotel.entity.LeaseDO;

/**
 * @author czy@win10
 * @date 2020/1/30 13:53
 */
@Mapper
public interface LeaseDAO {
    /**
     * 插入一条租赁信息
     *
     *
     */
    @Insert(" INSERT INTO tb_lease (id, goods_id, customer_id, lease_rentaltime, create_time, modify_time ) "
        +
        "VALUES(#{id}, #{goodsId}, #{customerId}, #{rentalTime}, now(), now()) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(LeaseDO leaseDO);

    /**
     * id查找租赁消息
     *
     * @param id
     */
    @Select("select id, goods_id, customer_id, lease_rentaltime, lease_returntime, create_time, modify_time from tb_lease where id=#{id}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "goodsId", column = "goods_id"),
        @Result(property = "customerId", column = "customer_id"),
        @Result(property = "rentalTime", column = "lease_rentaltime"),
        @Result(property = "returnTime", column = "lease_returntime"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    LeaseDO getLeaseDOById(long id);

    /**
     * 通过用户Id查询客户租赁物品订单
     * 
     * @param userId
     * @return
     */
    @Select("select id, goods_id, customer_id, lease_rentaltime, lease_returntime, create_time, modify_time from tb_lease where customer_id=#{userId}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "goodsId", column = "goods_id"),
        @Result(property = "customerId", column = "customer_id"),
        @Result(property = "rentalTime", column = "lease_rentaltime"),
        @Result(property = "returnTime", column = "lease_returntime"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<LeaseDO> getLeaseDOByCustomerId(long userId);

    /**
     * 更新租赁消息
     *
     * @param leaseDO
     */
    @Update("update tb_lease  set goods_id=#{goodsId}, customer_id=#{customerId}, lease_rentaltime=#{rentalTime}, lease_returntime=#{returnTime}, modify_time=now()  where id=#{id}")
    int update(LeaseDO leaseDO);

    /**
     * 归还租赁消息
     *
     * @param id
     */
    @Update("update tb_lease set lease_returntime=now(), modify_time=now()  where id=#{id}")
    int returnGoods(long id);

    /**
     * 根据id删除一条租赁消息
     *
     * @param id
     */
    @Delete("DELETE FROM tb_lease WHERE id=#{id}")
    int deleteById(long id);

    /**
     * 返回租赁list
     *
     * @return
     */
    @Select("select id  from tb_lease ")
    List<Long> getFloorIdList();
}
