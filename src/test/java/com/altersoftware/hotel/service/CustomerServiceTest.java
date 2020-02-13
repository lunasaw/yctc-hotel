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
public class CustomerServiceTest {

    @Resource
    private CustomerService customer;

    @Test
    public void aShowCustomer() {
        ResultDO<UserDO> byNumber = customer.getByNumber("95002");
        Assert.assertEquals(true, byNumber.isSuccess());
    }

    @Test
    public void bGetAll() {
        ResultDO<List<UserDO>> allCustomer = customer.getAllCustomer();
        Assert.assertEquals(true, allCustomer.isSuccess());

    }

    @Test
    public void cUpdate() {
        ResultDO<UserDO> staffDOResultDO = customer.getByNumber("95002");
        UserDO module = staffDOResultDO.getModule();
        module.setAccount(999.7);
        ResultDO<Void> voidResultDO = customer.updateUserDO(module);
        Assert.assertEquals(true, voidResultDO.isSuccess());
    }

    @Test
    public void gDelete() {
        ResultDO<Void> voidResultDO = customer.deleteByUserId("10038");
        Assert.assertEquals(true, voidResultDO.isSuccess());
    }
}
