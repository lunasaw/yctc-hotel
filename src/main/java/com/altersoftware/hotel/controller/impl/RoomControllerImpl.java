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
 * @author czy@win10
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
    public String showUpdate() {
        return null;
    }

}