package com.altersoftware.hotel.controller.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.MealdistributionController;

/**
 * @author Iszychen@win10
 * @date 2020/2/16 16:29
 */

@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/mealdistribution")
public class MealdistributionControllerImpl implements MealdistributionController {

    @Override
    public String showMenu() {
        return null;
    }

    @Override
    @GetMapping("show-mwalbysdmin")
    public String showMenuAdmin() {
        return TemplatePath.MENU_ADMIN ;
    }

    @Override
    @GetMapping("show-mwalbysdmintable")
    public String showMenuAdminTable() {
        return TemplatePath.MENU_ADMIN_TABLE;
    }
}
