package com.altersoftware.hotel.controller.impl;

import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.VipGradeController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Iszychen@win10
 * @date 2020/2/6 18:26
 */
@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/vipgrade")
public class VipGradeControllerImpl implements VipGradeController {

    @Override
    @GetMapping("show-vipuser")
    public String showUserGrade() {
        return TemplatePath.VIP_GRADE_SHOW;
    }

    @Override
    @GetMapping("show-vipgrade")
    public String showGrade() {
        return TemplatePath.VIP_GRADE_INFO;
    }


    @Override
    @GetMapping("show-vipgradetable")
    public String showGradeTable() {
        return TemplatePath.VIP_GRADE_INFO_TABLE;
    }



}
