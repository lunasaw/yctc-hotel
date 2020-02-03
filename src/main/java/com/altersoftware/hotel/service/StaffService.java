package com.altersoftware.hotel.service;

import java.util.List;

import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;

/**
 * @author czy@win10
 * @date 2020/2/3 19:41
 */
public interface StaffService {

    /**
     * 部门编号返回员工信息
     *
     * @param departmentId
     * @return
     */
    ResultDO<List<UserDO>> getStaffByDepartmentId(long departmentId);

}
