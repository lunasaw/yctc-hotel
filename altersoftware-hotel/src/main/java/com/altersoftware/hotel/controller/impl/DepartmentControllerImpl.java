package com.altersoftware.hotel.controller.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.DepartmentController;

/**
 * @author czy@win10
 * @date 2020/2/3 21:17
 */
@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/department")
public class DepartmentControllerImpl implements DepartmentController {

    @Override
    @GetMapping("show-departmentinfo")
    public String showDepartment() {
        return TemplatePath.DEPARTMENT;
    }

    @Override
    @GetMapping("show-departtable")
    public String showDepartmentTable() {
        return TemplatePath.DEPARTMENT_TABLE;
    }
}
