package com.altersoftware.hotel.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altersoftware.hotel.entity.StaffDataDO;

/**
 * @author czy@win10
 * @date 2020/2/3 19:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StaffDataDAOTest {

    private static final long   ID          = 1;
    private static final long   STAFF_ID    = 95001;
    private static final double SALARY      = 4500.0;
    private static final String SALARY_TIME = "每月15日";
    private static final int    DAY_TIME    = 2;
    private static final int    STAFF_YEARS = 3;
    private static final String ADDRESS     = "天河路58号";

    @Resource
    private StaffDataDAO        staffDataDAO;

    @Test
    public void ainsert() {
        StaffDataDO staffDataDO = new StaffDataDO();
        staffDataDO.setId(ID);
        staffDataDO.setStaffId(STAFF_ID);
        staffDataDO.setSalary(SALARY);
        staffDataDO.setSalaryTime(SALARY_TIME);
        staffDataDO.setDayTime(DAY_TIME);
        staffDataDO.setStaffTears(STAFF_YEARS);
        staffDataDO.setStaffAddress(ADDRESS);
        staffDataDAO.insert(staffDataDO);
    }

    @Test
    public void bGetById() {
        StaffDataDO staffDataDOById = staffDataDAO.getStaffDataDOById(ID);
        System.out.println(staffDataDOById);
        Assert.assertNotNull(staffDataDOById);
    }

    @Test
    public void cUpdat() {
        StaffDataDO staffDataDOById = staffDataDAO.getStaffDataDOById(ID);
        staffDataDOById.setStaffAddress("东风路75号");
        int update = staffDataDAO.update(staffDataDOById);
        Assert.assertEquals(1, update);
    }

    @Test
    public void dGetList() {
        List<StaffDataDO> staffDataDOList = staffDataDAO.getStaffDataDOList();
        System.out.println(staffDataDOList);
        Assert.assertNotNull(staffDataDOList);
    }

    @Test
    public void dGetIdList() {
        List<Long> floorIdList = staffDataDAO.getFloorIdList();
        System.out.println(floorIdList);
        Assert.assertNotNull(floorIdList);
    }

    @Test
    public void eDeleteById() {
        int i = staffDataDAO.deleteById(ID);
        Assert.assertEquals(1, i);
    }

}
