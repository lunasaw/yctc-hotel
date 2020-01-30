package com.altersoftware.hotel.controller.rest.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.controller.rest.HotelRestController;
import com.altersoftware.hotel.entity.HotelDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author czy@win10
 * @date 2020/1/30 21:57
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/hotel")
public class HotelRestControllerImpl implements HotelRestController {

    @Override
    @PostMapping("show-hotel")
    public ResultDO<HotelDO> showHotel(long Id) {
        return null;
    }

    @Override
    @PostMapping("update")
    public ResultDO<Void> updateHotel(HotelDO hotelDO) {
        return null;
    }

    @Override
    @PostMapping("add-hotel")
    public ResultDO<Void> insertHotel(HotelDO hotelDO) {
        return null;
    }
}
