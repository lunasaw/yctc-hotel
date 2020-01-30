package com.altersoftware.hotel.controller.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altersoftware.hotel.controller.HotelController;

/**
 * @author czy@win10
 * @date 2020/1/30 21:56
 */
@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/hotel")
public class HotelControllerImpl implements HotelController {

    @Override
    public String showHotel() {
        return null;
    }
}
