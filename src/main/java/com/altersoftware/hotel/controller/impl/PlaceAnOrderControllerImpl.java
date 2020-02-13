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

    /**
     * 下单页面-填写入住时间和退房时间
     * TODO 可为模态框 该页面可省
     * TODO order 为菜品订单 record为客房订单
     *
     * @return
     */
    @Override
    @GetMapping("selete-record")
    public String placeAnOrder(Model model) {
        // model.addAttribute("",)
        return TemplatePath.PLACE_AN_ORDER;
    }

    /**
     * 管理员住房订单页面
     *
     * @return
     */
    @Override
    @GetMapping("order-admin")
    public String RrcordByAdmin() {
        return TemplatePath.RECORD_BY_ADMIN;
    }

    /**
     * 管理员住房订单页面
     *
     * @return
     */
    @Override
    @GetMapping("order-admintable")
    public String RrcordByAdminTable() {
        return TemplatePath.RECORD_BY_ADMIN_TABLE;
    }
    /**
     * 客户信息订单页面
     *
     * @return
     */
    @Override
    @GetMapping("order-customer")
    public String RcordByCustomerId() {
        return TemplatePath.RECORD_BY_CUSTOMER;
    }
}
