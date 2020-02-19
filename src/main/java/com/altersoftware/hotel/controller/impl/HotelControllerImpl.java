package com.altersoftware.hotel.controller.impl;

import com.altersoftware.hotel.constant.TemplatePath;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altersoftware.hotel.controller.HotelController;

/**
 * @author hzx
 * @date 2020/1/30 21:56
 */
@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/hotelinfo")
public class HotelControllerImpl implements HotelController {
    /**
     * 酒店信息页面
     * @return
     */
    @Override
    @GetMapping("show-hotel")
    public String showHotel() {
        return TemplatePath.HOTEL;
    }

    /**
     * 酒店退房页面
     * @return
     */
    @Override
    @GetMapping("show-goaway")
    public String showGoAway() {
        return TemplatePath.GOAWAY;
    }


}
