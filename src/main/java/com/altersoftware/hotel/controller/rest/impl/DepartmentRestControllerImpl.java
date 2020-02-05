package com.altersoftware.hotel.controller.rest.impl;

import java.util.List;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.entity.MenuDO;
import com.altersoftware.hotel.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import com.altersoftware.hotel.controller.rest.DepartmentRestController;
import com.altersoftware.hotel.entity.DepartmentDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author hzx
 * @date 2020/2/3 21:20
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/department")
public class DepartmentRestControllerImpl implements DepartmentRestController {

    @Autowired
    DepartmentService departmentService;

    /**
     * 插入一条部门信息
     *
     * @param departmentDO
     * @return
     */
    @Override
    @PostMapping("add-department")
    public ResultDO<Void> insert(@RequestBody DepartmentDO departmentDO) {
        // 参数校验
        if (departmentDO.getId() <= 0 || departmentDO.getStaffId() <= 0 || departmentDO.getStaffNumbers() <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<Void> voidResultDO = departmentService.insert(departmentDO);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    /**
     * 展示部门信息
     *
     * @param id
     */
    @Override
    @PostMapping("get-department")
    public ResultDO<DepartmentDO> showDepartment(long id) {
        // 参数校验
        if (id <= 0) {
            return new ResultDO<DepartmentDO>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<DepartmentDO> departmentDOResultDO = departmentService.showDepartment(id);
        if (departmentDOResultDO.isSuccess() == false) {
            return new ResultDO<DepartmentDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            DepartmentDO doResultDOModule = departmentDOResultDO.getModule();
            return new ResultDO<DepartmentDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, doResultDOModule);
        }
    }

    /**
     * 修改部门信息
     *
     * @param departmentDO
     */
    @Override
    @PostMapping("update-department")
    public ResultDO<Void> updateDepartmentDO(@RequestBody DepartmentDO departmentDO) {
        // 参数校验
        if (departmentDO.getId() <= 0 || departmentDO.getStaffId() <= 0 || departmentDO.getStaffNumbers() <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<DepartmentDO> departmentDOResultDO = departmentService.showDepartment(departmentDO.getId());
        if (departmentDOResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            DepartmentDO resultDOModule = departmentDOResultDO.getModule();
            resultDOModule.setId(departmentDO.getId());
            resultDOModule.setName(departmentDO.getName());
            resultDOModule.setStaffId(departmentDO.getStaffId());
            resultDOModule.setStaffNumbers(departmentDO.getStaffNumbers());

            ResultDO<Void> voidResultDO = departmentService.insert(resultDOModule);
            if (voidResultDO.isSuccess() == false) {
                return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                        ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            } else {
                return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
            }
        }
    }

    /**
     * 根据房间查询部门信息
     *
     * @param staffId
     */
    @Override
    @PostMapping("get-bystaffid")
    public ResultDO<DepartmentDO> showGoodsBystaffId(@RequestParam(name = "staffId") long staffId) {
        // 参数校验
        if (staffId <= 0) {
            return new ResultDO<DepartmentDO>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<DepartmentDO> departmentDOResultDO = departmentService.showGoodsBystaffId(staffId);
        if (departmentDOResultDO.isSuccess() == false) {
            return new ResultDO<DepartmentDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            DepartmentDO doResultDOModule = departmentDOResultDO.getModule();
            return new ResultDO<DepartmentDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, doResultDOModule);
        }
    }

    /**
     * 删除部门信息
     *
     * @return
     */
    @Override
    @PostMapping("delete-byid")
    public ResultDO<Void> deleteById(long id) {
        // 参数校验
        if (id <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<Void> voidResultDO = departmentService.deleteById(id);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    /**
     * 查询所有部门信息
     *
     * @return
     */
    @Override
    @PostMapping("get-list")
    public ResultDO<List<DepartmentDO>> getAll() {
        ResultDO<List<DepartmentDO>> resultDO = departmentService.getAll();
        if (resultDO.isSuccess() == false) {
            return new ResultDO<List<DepartmentDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            List<DepartmentDO> resultDOModule = resultDO.getModule();
            return new ResultDO<List<DepartmentDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, resultDOModule);
        }
    }
}
