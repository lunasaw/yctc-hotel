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
import com.altersoftware.hotel.entity.VipDO;

/**
 * @author czy@win10
 * @date 2020/1/31 22:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VipServiceTest {

    @Resource
    private VipService vipService;

    @Test
    public void aInsert() {
        VipDO vipDO = new VipDO();
        vipDO.setId(1);
        vipDO.setCustomerNumber(95002);
        vipDO.setGrade("普通会员");
        ResultDO<Void> insert = vipService.insert(vipDO);
        Assert.assertEquals(true, insert.isSuccess());
    }

    @Test
    public void bGetAll() {
        ResultDO<List<VipDO>> all = vipService.showVipList();
        Assert.assertEquals(true, all.isSuccess());

    }

    @Test
    public void cUpdate() {
        ResultDO<VipDO> vipDOResultDO = vipService.showVip(1);
        VipDO module = vipDOResultDO.getModule();
        module.setGrade("至尊会员");
        ResultDO<Void> voidResultDO = vipService.updateVip(module);
        Assert.assertEquals(true, voidResultDO.isSuccess());
    }

    @Test
    public void eGetLongListByCustomerNumber() {
        ResultDO<List<Long>> listResultDO = vipService.getAllNumberList();
        Assert.assertEquals(true, listResultDO.isSuccess());
    }

    @Test
    public void fShowVip() {
        ResultDO<VipDO> vipDOResultDO = vipService.showVip(1);
        Assert.assertEquals(true, vipDOResultDO.isSuccess());
    }

    @Test
    public void gDelete() {
        ResultDO<Void> voidResultDO = vipService.deleteById(1);
        ResultDO<VipDO> vipDOResultDO = vipService.showVip(1);
        Assert.assertEquals(null, vipDOResultDO.getModule());
        Assert.assertEquals(true, voidResultDO.isSuccess());
    }
}
