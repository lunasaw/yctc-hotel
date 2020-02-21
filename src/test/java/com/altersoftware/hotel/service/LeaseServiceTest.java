package com.altersoftware.hotel.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altersoftware.hotel.entity.LeaseDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author czy@win10
 * @date 2020/1/31 22:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LeaseServiceTest {

    @Resource
    private LeaseService leaseService;

    @Test
    public void aInsert() {
        LeaseDO leaseDO = new LeaseDO();
        leaseDO.setId(3);
        leaseDO.setCustomerId(10013);
        leaseDO.setReturnTime(new Date());
        ResultDO<Void> insert = leaseService.insert(leaseDO);
        Assert.assertEquals(true, insert.isSuccess());
    }

    @Test
    public void aShowLease() {
        ResultDO<LeaseDO> leaseDOResultDO = leaseService.showLease(1);
        Assert.assertEquals(true, leaseDOResultDO.isSuccess());
    }

    @Test
    public void bGetAll() {
        ResultDO<List<LeaseDO>> all = leaseService.getAll();
        Assert.assertEquals(true, all.isSuccess());

    }

    @Test
    public void cUpdate() {
        ResultDO<LeaseDO> leaseDOResultDO = leaseService.showLease(3);
        LeaseDO module = leaseDOResultDO.getModule();
        module.setReturnTime(new Date());
        ResultDO<Void> voidResultDO = leaseService.updateLease(module);
        Assert.assertEquals(true, voidResultDO.isSuccess());
    }

    @Test
    public void eShowByCustomer() {
        ResultDO<List<LeaseDO>> listResultDO = leaseService.showLeaseByCustomerId(10013);
        Assert.assertEquals(true, listResultDO.isSuccess());
    }

    @Test
    public void gDelete() {
        ResultDO<Void> voidResultDO = leaseService.deleteById(3);
        Assert.assertEquals(true, voidResultDO.isSuccess());
    }
}
