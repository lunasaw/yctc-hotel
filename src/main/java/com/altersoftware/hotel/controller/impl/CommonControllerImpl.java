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

    @Override
    @GetMapping("index/senery")
    public String showIndexSvcenery() {
        return TemplatePath.SCENERY;
    }

    @Override
    @GetMapping("index/health")
    public String showIndexHealth() {
        return TemplatePath.HEALTH;
    }

    @Override
    @GetMapping("index/wedding")
    public String showIndexWedding() {
        return TemplatePath.WEDDING;
    }

    @Override
    @GetMapping("index/social")
    public String showIndexSocial() {
        return TemplatePath.SOCIALIZING;
    }

    @Override
    @GetMapping("index/introduction")
    public String showIndexIntroduction() {
        return TemplatePath.HOTEL_INTRODUCTION;
    }

    @Override
    @GetMapping("index/discount")
    public String showIndexDiscount() {
        return TemplatePath.DISCOUNTPRICE;
    }



}
