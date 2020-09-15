package com.altersoftware.hotel.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.RoomController;

/**
 * @author hzx
 * @date 2020/1/29 21:14
 */
@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/room")
public class RoomControllerImpl implements RoomController {

    private final static Logger LOG = LoggerFactory.getLogger("controllerLogger");

    @Override
    @GetMapping("show-rooms")
    public String showRooms() {
        return TemplatePath.ROOMS;
    }


    @Override
    @GetMapping("show-roomsreception")
    public String showRoomsReception() {
        return TemplatePath.ROOMS_RECEPTION;
    }

    @Override
    @GetMapping("rooms-update")
    public String showUpdate() { return TemplatePath.ROOMS_UPDATE; }

    @Override
    @GetMapping("rooms-admin")
    public String showUpdateAdmin() { return TemplatePath.ROOM_ADMIN; }

    @Override
    @GetMapping("rooms-admintable")
    public String showUpdateAdminTable() { return TemplatePath.ROOM_ADMIN_TABLE; }

    @Override
    @GetMapping("rooms-goods")
    public String showRoomGoods() { return TemplatePath.ROOM_GOODS; }

    @Override
    @GetMapping("rooms-goodstable")
    public String showRoomGoodsTable() { return TemplatePath.ROOM_GOODS_TABLE; }

}
