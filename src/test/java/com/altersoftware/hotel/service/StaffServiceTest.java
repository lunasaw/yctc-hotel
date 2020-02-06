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

import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;

/**
 * @author czy@win10
 * @date 2020/1/31 22:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StaffServiceTest {

    @Resource
    private StaffService staffService;

    @Test
    public void aShowStaff() {
        ResultDO<UserDO> byNumber = staffService.getByNumber("95002");
        Assert.assertEquals(true, byNumber.isSuccess());
    }

    @Test
    public void bGetAll() {
        ResultDO<List<UserDO>> allStaff = staffService.getAllStaff();
        Assert.assertEquals(true, allStaff.isSuccess());

    }

    @Test
    public void cUpdate() {
        ResultDO<UserDO> staffDOResultDO = staffService.getByNumber("95002");
        UserDO module = staffDOResultDO.getModule();
        module.setAccount(999.7);
        ResultDO<Void> voidResultDO = staffService.updateUserDO(module);
        Assert.assertEquals(true, voidResultDO.isSuccess());
    }

    @Test
    public void eShowByRoom() {
        ResultDO<List<UserDO>> listResultDO = staffService.getStaffByDepartmentId(1);
        Assert.assertEquals(true, listResultDO.isSuccess());
    }

    @Test
    public void gDelete() {
        ResultDO<Void> voidResultDO = staffService.deleteByUserId("10038");
        Assert.assertEquals(true, voidResultDO.isSuccess());
    }
}
