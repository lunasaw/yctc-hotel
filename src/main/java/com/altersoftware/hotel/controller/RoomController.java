package com.altersoftware.hotel.controller;

/**
 * @author czy@win10
 * @date 2020/1/29 21:13
 */
public interface RoomController {
    /**
     * 展示房间页面
     *
     */
    String showRooms();

    String showRoomsReception();

    /**
     * 跳转到修改页面
     *
     */
    String showUpdate();

    String showUpdateAdmin();

    String showUpdateAdminTable();

}
