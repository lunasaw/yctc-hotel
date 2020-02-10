package com.altersoftware.hotel.controller;

/**
 * @author Iszychen@win10
 * @date 2020/2/7 22:13
 */
public interface PlaceAnOrderController {
    /**
     * 下单页面-填写入住时间和退房时间
     * TODO 可为模态框 该页面可省
     * TODO order 为菜品订单 record为客房订单
     * 
     * @return
     */
    String placeAnOrder();

    /**
     * 管理员住房订单页面
     * 
     * @return
     */
    String RrcordByAdmin();

    /**
     * 客户信息订单页面
     * 
     * @return
     */
    String RcordByCustomerId();
}
