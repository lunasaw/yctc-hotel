package com.altersoftware.hotel.controller.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.OrderContoller;

/**
 * @author Iszychen@win10
 * @date 2020/2/10 21:55
 */
@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/placeorder")
public class OrderContollerImpl implements OrderContoller {

    @Override
    @GetMapping("select-order")
    public String showOrder() {
        return TemplatePath.PLACE_AN_ORDER_MENU;
    }

    @Override
    @GetMapping("order-admin")
    public String OrderByAdmin() {
        return TemplatePath.ORDER_BY_ADMIN;
    }

    @Override
    @GetMapping("order-customer")
    public String OrderByCustomer() {
        return TemplatePath.ORDER_BY_CUSTOMER;
    }
}
