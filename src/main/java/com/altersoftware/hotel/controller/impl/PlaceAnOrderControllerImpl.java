package com.altersoftware.hotel.controller.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.PlaceAnOrderController;

/**
 * @author Iszychen@win10
 * @date 2020/2/7 22:14
 */
@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/order")
public class PlaceAnOrderControllerImpl implements PlaceAnOrderController {

    @Override
    @GetMapping("selete-record")
    public String placeAnOrder(Model model) {
        // model.addAttribute("",)
        return TemplatePath.PLACE_AN_ORDER;
    }

    @Override
    @GetMapping("order-admin")
    public String RrcordByAdmin() {
        return TemplatePath.RECORD_BY_ADMIN;
    }

    @Override
    @GetMapping("order-customer")
    public String RcordByCustomerId() {
        return TemplatePath.RECORD_BY_CUSTOMER;
    }
}
