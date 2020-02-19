package com.altersoftware.hotel.controller.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altersoftware.hotel.controller.RoomGoodsStateController;

/**
 * @author Iszychen@win10
 * @date 2020/2/19 23:21
 */
@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/goodstate")
public class RoomGoodsStateImpl implements RoomGoodsStateController {

    @Override
    public String showRooms() {
        return null;
    }
}
