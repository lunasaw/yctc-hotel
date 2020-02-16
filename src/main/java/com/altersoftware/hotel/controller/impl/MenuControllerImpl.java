package com.altersoftware.hotel.controller.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.MenuController;

/**
 * @author czy@win10
 * @date 2020/2/1 21:37
 */
@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/menuinfo")
public class MenuControllerImpl implements MenuController {

    @Override
    @GetMapping("show-menus")
    public String showMenu() {
        return TemplatePath.MENUS;
    }

    @Override
    @GetMapping("show-menusadmin")
    public String showMenuAdmin() {
        return TemplatePath.MENUS_ADMIN;
    }

    @Override
    @GetMapping("show-menusadmintable")
    public String showMenuAdminTable() { return TemplatePath.MENUS_ADMIN_TABLE; }


}
