package com.altersoftware.hotel.controller.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.CustomerInfoController;

/**
 * @author czy@win10
 * @date 2020/1/30 20:11
 */
@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/customer")
public class CustomerInfoControllerImpl implements CustomerInfoController {

    @Override
    @GetMapping("show-customerinfo")
    public String showCustomers() {
        return TemplatePath.CUSTOMER_INFO;
    }

    @Override
    @GetMapping("show-customerinfotable")
    public String showCustomersTable() {
        return TemplatePath.CUSTOMER_INFO_TABLE;
    }

    @Override
    @GetMapping("show-customerupdate")
    public String showCustomersupdate() {
        return TemplatePath.CUSTOMER_UPDATE;
    }
}
