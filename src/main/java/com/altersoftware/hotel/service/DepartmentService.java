package com.altersoftware.hotel.service;

import java.util.List;

import com.altersoftware.hotel.entity.DepartmentDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author czy@win10
 * @date 2020/2/3 19:40
 */
public interface DepartmentService {

    /**
     * 插入一条部门信息
     *
     * @param departmentDO
     * @return
     */
    ResultDO<Void> insert(DepartmentDO departmentDO);

    /**
     * 展示部门信息
     *
     * @param id
     */
    ResultDO<DepartmentDO> showDepartment(long id);

    /**
     * 修改部门信息
     *
     * @param departmentDO
     */
    ResultDO<Void> updateDepartmentDO(DepartmentDO departmentDO);

    /**
     * 根据负责人id查询部门信息
     *
     * @param staffId
     */
    ResultDO<DepartmentDO> showGoodsBystaffId(long staffId);

    /**
     * 删除部门信息
     *
     * @return
     */
    ResultDO<Void> deleteById(long id);

    /**
     * 删除部分部门信息
     *
     * @return
     */
    ResultDO<Void> deleteList(List<Long> ids);

    /**
     * 查询所有部门信息
     *
     * @return
     */
    ResultDO<List<DepartmentDO>> getAll();
}
