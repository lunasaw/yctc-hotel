package com.altersoftware.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.altersoftware.hotel.entity.OrderDO;

/**
 * @author czy@win10
 * @date 2020/2/1 20:53
 */
@Mapper
public interface OrderDAO {

    /**
     * 插入一条订单信息
     *
     *
     */
    @Insert(" INSERT INTO tb_order (id, menu_id, numbers, customer_id, pay_money, state, create_time, modify_time ) "
        +
        "VALUES(#{id}, #{menuId}, #{numbers}, #{customerId}, #{payMoney}, #{state}, now(), now()) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(OrderDO orderDO);

    /**
     * id查找订单消息
     *
     * @param id
     */
    @Select("select id, menu_id, numbers, customer_id, pay_money, state, create_time, modify_time from tb_order where id=#{id}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "menuId", column = "menu_id"),
        @Result(property = "numbers", column = "numbers"),
        @Result(property = "customerId", column = "customer_id"),
        @Result(property = "payMoney", column = "pay_money"),
        @Result(property = "state", column = "state"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    OrderDO getOrderDOById(long id);

    /**
     * 客户id查找订单消息
     *
     * @param customerId
     */
    @Select("select id, menu_id, numbers, customer_id, pay_money, state, create_time, modify_time from tb_order where customer_id=#{customerId}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "menuId", column = "menu_id"),
        @Result(property = "numbers", column = "numbers"),
        @Result(property = "customerId", column = "customer_id"),
        @Result(property = "payMoney", column = "pay_money"),
        @Result(property = "state", column = "state"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<OrderDO> getOrderDOByCustomerId(long customerId);

    /**
     * 所有订单
     *
     */
    @Select("select id, menu_id, numbers, customer_id, pay_money, state, create_time, modify_time from tb_order  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "menuId", column = "menu_id"),
        @Result(property = "numbers", column = "numbers"),
        @Result(property = "customerId", column = "customer_id"),
        @Result(property = "payMoney", column = "pay_money"),
        @Result(property = "state", column = "state"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<OrderDO> getOrderDOList();

    /**
     * 更新订单消息
     *
     * @param orderDO
     */
    @Update("update tb_order  set menu_id=#{menuId}, numbers=#{numbers}, customer_id=#{customerId}, pay_money=#{payMoney}, state=#{state}, modify_time=now() where id=#{id}")
    int update(OrderDO orderDO);

    /**
     * 根据id删除一条订单消息
     *
     * @param id
     */
    @Delete("DELETE FROM tb_order WHERE id=#{id}")
    int deleteById(long id);

    /**
     * 返回订单list
     *
     * @return
     */
    @Select("select id  from tb_order ")
    List<Long> getOrderIdList();

}
