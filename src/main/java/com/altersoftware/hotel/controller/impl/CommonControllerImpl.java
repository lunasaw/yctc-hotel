package com.altersoftware.hotel.controller.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.CommonController;


@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/")
/**
 * commonController接口实现
 *
 * @author wlt
 */
public class CommonControllerImpl implements CommonController {

    @Override
    @GetMapping("index")
    public String showIndex() {
        return TemplatePath.INDEX;
    }

    @Override
    @GetMapping("index/resturant")
    public String showIndexResturant() {
        return TemplatePath.RESTAURANT;
    }

}
