package com.altersoftware.hotel.controller.rest;

import java.util.List;

import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;

/**
 * @author Iszychen@win10
 * @date 2020/2/6 17:28
 */
public interface StaffRestController {

    /**
     * 部门编号返回员工信息
     *
     * @param departmentId
     * @return
     */
    ResultDO<List<UserDO>> getStaffByDepartmentId(long departmentId);

    /**
     * 获取所有客户信息
     *
     * @return
     */
    ResultDO<List<UserDO>> getAllStaff();

    /**
     * 修改客户信息
     *
     * @param userDO
     * @return
     */
    ResultDO<Void> updateUserDO(UserDO userDO);

    /**
     * 删除指定客户信息
     *
     * @param number
     * @return
     */
    ResultDO<Void> deleteByUserId(String number);

    /**
     * 会员号搜索客户/员工
     *
     * @param number
     * @return
     */
    ResultDO<UserDO> getByNumber(String number);
}
