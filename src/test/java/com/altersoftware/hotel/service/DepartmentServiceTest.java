package com.altersoftware.hotel.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altersoftware.hotel.entity.DepartmentDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author czy@win10
 * @date 2020/1/31 22:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentServiceTest {

    @Resource
    private DepartmentService departmentService;

    @Test
    public void aInsert() {
        DepartmentDO departmentDO = new DepartmentDO();
        departmentDO.setId(1);
        departmentDO.setName("洗衣房");
        departmentDO.setStaffId(95001);
        ResultDO<Void> insert = departmentService.insert(departmentDO);
        Assert.assertEquals(true, insert.isSuccess());
    }

    @Test
    public void bShowDepartment() {
        ResultDO<DepartmentDO> DepartmentDOResultDO = departmentService.showDepartment(1);
        Assert.assertEquals(true, DepartmentDOResultDO.isSuccess());
    }

    @Test
    public void cUpdate() {
        ResultDO<DepartmentDO> DepartmentDOResultDO = departmentService.showDepartment(1);
        DepartmentDO module = DepartmentDOResultDO.getModule();
        module.setName("清洁部");
        ResultDO<Void> voidResultDO = departmentService.updateDepartmentDO(module);
        Assert.assertEquals(true, voidResultDO.isSuccess());
    }

    @Test
    public void eShowByRoom() {
        ResultDO<DepartmentDO> listResultDO = departmentService.showDepartment(1);
        Assert.assertEquals(true, listResultDO.isSuccess());
    }

    @Test
    public void fGetAll() {
        ResultDO<List<DepartmentDO>> all = departmentService.getAll();
        Assert.assertEquals(true, all.isSuccess());

    }

    @Test
    public void gDelete() {
        ResultDO<Void> voidResultDO = departmentService.deleteById(3);
        Assert.assertEquals(true, voidResultDO.isSuccess());
    }
}
