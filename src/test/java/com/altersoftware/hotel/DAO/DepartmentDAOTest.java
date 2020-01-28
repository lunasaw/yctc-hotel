package com.altersoftware.hotel.DAO;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altersoftware.hotel.dao.DepartmentDAO;
import com.altersoftware.hotel.entity.DepartmentDO;

/**
 * @author czy@win10
 * @date 2020/1/28 15:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDAOTest {

    private static final long   ID            = 1;
    private static final String NAME          = "前厅部";
    private static final int    STAFF_NUMBERS = 20;
    private static final long   LEADING       = 10004;

    @Resource
    private DepartmentDAO       departmentDAO;

    @Test
    public void aInsert() {
        DepartmentDO departmentDO = new DepartmentDO();
        departmentDO.setId(ID);
        departmentDO.setName(NAME);
        departmentDO.setStaffId(LEADING);
        departmentDO.setStaffNumbers(STAFF_NUMBERS);
        departmentDAO.insert(departmentDO);
    }

    @Test
    public void bGetById() {
        DepartmentDO departmentDOById = departmentDAO.getDepartmentDOById(ID);
        System.out.println(departmentDOById);
        Assert.assertNotNull(departmentDOById);
    }

    @Test
    public void cUpdate() {
        DepartmentDO departmentDOById = departmentDAO.getDepartmentDOById(ID);
        departmentDOById.setStaffNumbers(departmentDOById.getStaffNumbers() + 1);
        int update = departmentDAO.update(departmentDOById);
        System.out.println(update);
        Assert.assertEquals(1, update);
    }

    @Test
    public void dGetByStaffId() {
        DepartmentDO departmentDOByStaffId = departmentDAO.getDepartmentDOByStaffId(LEADING);
        System.out.println(departmentDOByStaffId);
        Assert.assertNotNull(departmentDOByStaffId);
    }

    @Test
    public void eDeleteById() {
        int i = departmentDAO.deleteById(ID);
        Assert.assertEquals(1, i);
        DepartmentDO departmentDOById = departmentDAO.getDepartmentDOById(ID);
        System.out.println(departmentDOById);
        Assert.assertNull(departmentDOById);
    }

}
