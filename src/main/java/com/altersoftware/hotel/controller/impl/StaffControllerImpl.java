package com.altersoftware.hotel.controller.impl;

import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.StaffController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Iszychen@win10
 * @date 2020/2/6 17:26
 */
@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/staffinfo")
public class StaffControllerImpl implements StaffController {

    @Override
    @GetMapping("show-staff")
	public String showStaff() {
        return TemplatePath.STAFF_INFO;
	}

    @Override
    @GetMapping("show-stafftable")
    public String showStaffTable() {
        return TemplatePath.STAFF_INFO_TABLE;
    }
}
