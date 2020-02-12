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

import com.altersoftware.hotel.entity.RecordDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author czy@win10
 * @date 2020/1/31 22:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RecordServiceTest {

    @Resource
    private RecordService recordService;

    @Test
    public void aShowRecord() {
        ResultDO<RecordDO> recordDOResultDO = recordService.showRecord(92073248147L);
        Assert.assertEquals(true, recordDOResultDO.isSuccess());
    }

    @Test
    public void bGetAll() {
        ResultDO<List<RecordDO>> all = recordService.getAll();
        Assert.assertEquals(true, all.isSuccess());

    }

    @Test
    public void cUpdate() {
        ResultDO<RecordDO> recordDOResultDO = recordService.showRecord(1);
        RecordDO module = recordDOResultDO.getModule();
        module.setState(1);
        ResultDO<Void> voidResultDO = recordService.updateRecord(module);
        Assert.assertEquals(true, voidResultDO.isSuccess());
    }

    @Test
    public void eshowRecordByRoomNumber() {
        ResultDO<List<RecordDO>> listResultDO = recordService.showRecordByRoomNumber(442);
        Assert.assertEquals(true, listResultDO.isSuccess());
    }

    @Test
    public void fInsert() {
        RecordDO recordDO = new RecordDO();
        recordDO.setId(11);
        recordDO.setPayMoney(99);
        ResultDO<Void> insert = recordService.createRecord(recordDO);
        Assert.assertEquals(true, insert.isSuccess());
    }

    @Test
    public void zDelete() {
        ResultDO<Void> voidResultDO = recordService.deleteById(11);
        Assert.assertEquals(true, voidResultDO.isSuccess());
    }

    @Test
    public void gReturnActualMoney() {
        ResultDO<Double> actualMoney = recordService.getActualMoney(10013, 111);
        Assert.assertEquals(true, actualMoney.isSuccess());
    }
}
