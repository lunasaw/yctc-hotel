package com.altersoftware.hotel.controller.rest;

import java.util.List;

import com.altersoftware.hotel.entity.OrderDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.vo.OrderVO;

/**
 * @author Iszychen@win10
 * @date 2020/2/10 22:52
 */
public interface OrderRestController {

    /**
     * 根据构造的菜品订单存入数据库
     *
     * @param orderVO
     * @return
     */
    ResultDO<Void> createOrder(OrderVO orderVO);

    /**
     * 展示菜品订单信息
     *
     * @param id
     */
    ResultDO<OrderDO> showOrder(long id);

    /**
     * 根据客户编号查询菜品订单信息List
     *
     * @param customerId
     */
    ResultDO<List<OrderDO>> showOrderByCustomerId(long customerId);

    /**
     * 修改菜品订单信息
     *
     * @param orderDO
     */
    ResultDO<Void> updateOrder(OrderDO orderDO);

    /**
     * 返回所有订单编号
     *
     *
     */
    ResultDO<List<Long>> showOrderIdList();

    /**
     * 删除菜品订单信息
     *
     * @return
     */
    ResultDO<Void> deleteById(long id);

    /**
     * 删除部分菜品订单信息
     *
     * @return
     */
    ResultDO<Void> deleteList(Long[] ids);

    /**
     * 查询所有菜品订单信息
     *
     * @return
     */
    ResultDO<List<OrderDO>> getAll();
}
