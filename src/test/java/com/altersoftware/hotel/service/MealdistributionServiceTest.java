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

import com.altersoftware.hotel.entity.MealdistributionDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author czy@win10
 * @date 2020/1/31 22:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MealdistributionServiceTest {

    @Resource
    private MealdistributionService mealdistributionService;

    @Test
    public void aShowMealdistribution() {
        ResultDO<MealdistributionDO> mealdistributionDOResultDO = mealdistributionService.showMealdistribution(2);
        Assert.assertEquals(true, mealdistributionDOResultDO.isSuccess());
    }

    @Test
    public void bGetAll() {
        ResultDO<List<MealdistributionDO>> all = mealdistributionService.getAll();
        Assert.assertEquals(true, all.isSuccess());

    }

    @Test
    public void cUpdate() {
        ResultDO<MealdistributionDO> mealdistributionDOResultDO = mealdistributionService.showMealdistribution(2);
        MealdistributionDO module = mealdistributionDOResultDO.getModule();
        module.setOrderId(2);
        ResultDO<Void> voidResultDO = mealdistributionService.updateMealdistribution(module);
        Assert.assertEquals(true, voidResultDO.isSuccess());
    }

    @Test
    public void eshowMealdistributionByRoomId() {
        ResultDO<List<MealdistributionDO>> listByRoom = mealdistributionService.getListByRoom(2);
        Assert.assertEquals(true, listByRoom.isSuccess());
    }

    @Test
    public void eshowMealdistributionByStaff() {
        ResultDO<List<MealdistributionDO>> listByRoom = mealdistributionService.getListByStaffId(10024);
        Assert.assertEquals(true, listByRoom.isSuccess());
    }

    @Test
    public void fInsert() {
        MealdistributionDO mealdistributionDO = new MealdistributionDO();
        mealdistributionDO.setId(11);
        mealdistributionDO.setOrderId(99);
        mealdistributionDO.setStaffId(9911);
        ResultDO<Void> insert = mealdistributionService.createMealdistribution(mealdistributionDO);
        Assert.assertEquals(true, insert.isSuccess());
    }

    @Test
    public void zDelete() {
        ResultDO<Void> voidResultDO = mealdistributionService.deleteById(11);
        Assert.assertEquals(true, voidResultDO.isSuccess());
    }

    @Test
    public void gStart() {
        ResultDO<Void> actualMoney = mealdistributionService.start(11);
        Assert.assertEquals(true, actualMoney.isSuccess());
    }

    @Test
    public void hEnd() {
        ResultDO<Void> actualMoney = mealdistributionService.end(2);
        Assert.assertEquals(true, actualMoney.isSuccess());
    }

    @Test
    public void iGetNow() {
        ResultDO<MealdistributionDO> now = mealdistributionService.getNow(9911);
        System.out.println(now.getModule());
        Assert.assertEquals(true, now.isSuccess());
    }
}
