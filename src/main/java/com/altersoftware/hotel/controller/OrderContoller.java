package com.altersoftware.hotel.controller;

/**
 * @author Iszychen@win10
 * @date 2020/2/10 21:27
 */
public interface OrderContoller {

    /**
     * TODO order 为菜品订单 record为客房订单
     * 客户选择菜品订单页面
     * 
     * @return
     */
    String showOrder();

    /**
     * 管理员菜品订单页面
     * 
     * @return
     */
    String OrderByAdmin();

    /**
     * 客户历史菜品订单页面
     * 
     * @return
     */
    String OrderByCustomer();
}
