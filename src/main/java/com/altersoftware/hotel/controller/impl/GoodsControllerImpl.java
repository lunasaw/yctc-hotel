package com.altersoftware.hotel.controller.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.GoodsController;

/**
 * @author czy@win10
 * @date 2020/1/31 21:51
 */
@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/goods")
public class GoodsControllerImpl implements GoodsController {

    /**
     * 物品信息页面
     *
     * @return
     */
    @Override
    @GetMapping("show-goods")
    public String showGoodsInfo() {
        return TemplatePath.GOODS;
    }

    /**
     * 物品信息页面
     *
     * @return
     */
    @Override
    @GetMapping("show-goodstable")
    public String showGoodsTable() {
        return TemplatePath.GOODS_TABLE;
    }

}
