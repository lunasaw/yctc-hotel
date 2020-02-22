package com.altersoftware.hotel.controller;

/**
 * @author czy@win10
 * @date 2020/1/31 21:49
 */
public interface LeaseController {
    /**
     * 转到租赁信息页面
     *
     */
    String showLeaseInfo();

    /**
     * 转到租赁信息页面
     *
     */
    String showLeaseTable();

    String showLeaseState();

    String showLeaseStateTable();

    String showLeaseHistory();
}
