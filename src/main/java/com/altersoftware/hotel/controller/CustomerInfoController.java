package com.altersoftware.hotel.controller;

/**
 * @author czy@win10
 * @date 2020/1/30 20:11
 */
public interface CustomerInfoController {

    /**
     * 来到客户信息页面
     * 
     * @return
     */
    String showCustomers();

    /**
     * 客户信息修改页面
     *
     * @return
     */
    public String showCustomersupdate();

    /**
     * 来到客户信息页面的子网页
     *
     * @return
     */
    String showCustomersTable();

}
