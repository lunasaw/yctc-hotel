package com.altersoftware.hotel.controller.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.PlaceAnOrderController;

/**
 * @author Iszychen@win10
 * @date 2020/2/7 22:14
 */
@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/placeorder")
public class PlaceAnOrderControllerImpl implements PlaceAnOrderController {

    @Override
    public String placeAnOrder() {
        return TemplatePath.PLACE_AN_ORDER;
    }
}
