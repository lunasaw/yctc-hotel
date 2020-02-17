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

    /**
     * 获取所有员工信息
     *
     * @return
     */
    ResultDO<List<UserDO>> getAllStaff();

    /**
     * 修改员工信息
     *
     * @param userDO
     * @return
     */
    ResultDO<Void> updateUserDO(UserDO userDO);

    /**
     * 删除指定员工信息
     *
     * @param number
     * @return
     */
    ResultDO<Void> deleteByUserId(String number);

    /**
     * 删除部分指定员工信息
     *
     * @param numbers
     * @return
     */
    ResultDO<Void> deleteByList(List<String> numbers);

    /**
     * 会员号搜索员工/员工
     *
     * @param number
     * @return
     */
    ResultDO<UserDO> getByNumber(String number);

    /**
     * 返回前台员工List
     * 
     * @return
     */
    ResultDO<List<UserDO>> getReception();


    /**
     * 返回保洁员工List
     * 
     * @return
     */
    ResultDO<List<UserDO>> getClean();

    /**
     * 返回安保员工List
     * 
     * @return
     */
    ResultDO<List<UserDO>> getProcter();

}
