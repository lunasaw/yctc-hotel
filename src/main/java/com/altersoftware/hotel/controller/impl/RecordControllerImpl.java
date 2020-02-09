package com.altersoftware.hotel.controller.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.RecordController;

/**
 * @author Iszychen@win10
 * @date 2020/2/7 22:04
 */
@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/record")
public class RecordControllerImpl implements RecordController {

    @Override
    public String showRecord() {
        return TemplatePath.RECORD_INFO;
    }

    @GetMapping("page")
    public String payPage() {
        // 支付支付测试页面
        return "pay/index";
    }

    @GetMapping("checkalipay")
    public String checkalipay() {
        // 支付宝回调页面
        return TemplatePath.CHECK_ALI_PAY;
    }
}
