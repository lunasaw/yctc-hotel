package com.altersoftware.hotel.controller.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.RoomTypeController;

/**
 * @author czy@win10
 * @date 2020/2/2 16:30
 */
@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/roomType")
public class RoomTypeControllerImpl implements RoomTypeController {

    @Override
    @GetMapping("show-roomtype")
    public String showRoomType() {
        return TemplatePath.ROOM_TYPE;
    }
}
