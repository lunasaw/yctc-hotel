package com.altersoftware.hotel.controller.rest.impl;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.controller.rest.DepartmentRestController;
import com.altersoftware.hotel.entity.DepartmentDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author czy@win10
 * @date 2020/2/3 21:20
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/department")
public class DepartmentRestControllerImpl implements DepartmentRestController {

    @Override
    @PostMapping("add-department")
    public ResultDO<Void> insert(DepartmentDO departmentDO) {
        return null;
    }

    @Override
    @PostMapping("get-department")
    public ResultDO<DepartmentDO> showDepartment(long id) {
        return null;
    }

    @Override
    @PostMapping("update-department")
    public ResultDO<Void> updateDepartmentDO(DepartmentDO departmentDO) {
        return null;
    }

    @Override
    @PostMapping("get-bystaffid")
    public ResultDO<DepartmentDO> showGoodsBystaffId(long staffId) {
        return null;
    }

    @Override
    @PostMapping("delete-byid")
    public ResultDO<Void> deleteById(long id) {
        return null;
    }

    @Override
    @PostMapping("get-list")
    public ResultDO<List<DepartmentDO>> getAll() {
        return null;
    }
}
