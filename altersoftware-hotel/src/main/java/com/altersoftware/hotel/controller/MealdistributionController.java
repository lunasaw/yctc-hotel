package com.altersoftware.hotel.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Iszychen@win10
 * @date 2020/2/16 16:28
 */
@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/mealdistribution")
public interface MealdistributionController {
    /**
     * 来到配送页面
     *
     * @return
     */
    String showMenu();

    /**
     * 管理员后台
     * 
     * @return
     */
    String showMenuAdmin();

    String showMenuAdminTable();
}
