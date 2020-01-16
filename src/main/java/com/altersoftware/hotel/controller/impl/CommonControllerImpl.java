package com.altersoftware.hotel.controller.impl;

import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.CommonController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@ComponentScan({"edu.yctc.hotel.service"})
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
}
