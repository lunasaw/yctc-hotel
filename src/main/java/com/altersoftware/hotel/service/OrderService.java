package com.altersoftware.hotel.service;

import java.util.List;

import com.altersoftware.hotel.entity.OrderDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.vo.OrderVO;

/**
 * @author Iszychen@win10
 * @date 2020/2/10 21:19
 */
public interface OrderService {
    /**
     * 根据构造的菜品订单存入数据库
     *
     * @param orderVO
     * @return
     */
    ResultDO<Long> createOrder(OrderVO orderVO);

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
    ResultDO<Void> deleteList(List<Long> ids);

    /**
     * 删除未支付订单订单信息
     *
     * @return
     */
    ResultDO<Void> deleteList();

    /**
     * 查询所有菜品订单信息
     *
     * @return
     */
    ResultDO<List<OrderDO>> getAll();

    /**
     * 会员试用 //TODO 暂不考虑餐品打折
     * 通过客户编号和房间号返回实际需支付金额
     *
     * @param customerId
     * @return
     */
    ResultDO<Double> getActualMoney(long customerId);

    /**
     * 更改支付金额
     * 
     * @param orderId
     * @param number
     * @param menuId
     * @return
     */
    ResultDO<Void> changeMenuMoneyPay(long orderId, int number, long menuId);

    /**
     * 返回一次支付所有金额
     * 
     * @param orderId
     * @return
     */
    Double allOnceMoney(long orderId);
}
