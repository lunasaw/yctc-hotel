package com.altersoftware.hotel.controller;

/**
 * @author czy@win10
 * @date 2020/2/1 21:35
 */
public interface MenuController {
    /**
     * 来到菜品里面
     * 
     * @return
     */
    String showMenu();

    /**
     * 管理员后台
     * 
     * @return
     */
    String showMenuAdmin();

    String showMenuAdminTable();

    String showMenuTable();
}
