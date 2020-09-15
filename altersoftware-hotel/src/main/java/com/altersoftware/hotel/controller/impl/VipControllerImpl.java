package com.altersoftware.hotel.controller.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.VipController;

/**
 * @author Iszychen@win10
 * @date 2020/2/4 15:31
 */
@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/vipinfo")
public class VipControllerImpl implements VipController {

    @Override
    @GetMapping("show-vip")
    public String showVipInfo() {
        return TemplatePath.VIP_INFO;
    }

    @Override
    @GetMapping("show-viptable")
    public String showVipTable() {
        return TemplatePath.VIP_TABLE;
    }
}
