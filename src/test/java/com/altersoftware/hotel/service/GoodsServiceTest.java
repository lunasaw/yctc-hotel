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

import com.altersoftware.hotel.constant.entity.goods.GoodsState;
import com.altersoftware.hotel.entity.GoodsDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author czy@win10
 * @date 2020/1/31 22:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoodsServiceTest {

    @Resource
    private GoodsService goodsService;

    @Test
    public void aShowGoods() {
        ResultDO<GoodsDO> goodsDOResultDO = goodsService.showGoods(1);
        Assert.assertEquals(true, goodsDOResultDO.isSuccess());
    }

    @Test
    public void bGetAll() {
        ResultDO<List<GoodsDO>> all = goodsService.getAll();
        Assert.assertEquals(true, all.isSuccess());

    }

    @Test
    public void cUpdate() {
        ResultDO<GoodsDO> goodsDOResultDO = goodsService.showGoods(1);
        GoodsDO module = goodsDOResultDO.getModule();
        module.setState(GoodsState.LENDED);
        ResultDO<Void> voidResultDO = goodsService.updateGoods(module);
        Assert.assertEquals(true, voidResultDO.isSuccess());
    }

    @Test
    public void eShowByRoom() {
        ResultDO<List<GoodsDO>> listResultDO = goodsService.showGoodsByRoom(1);
        Assert.assertEquals(true, listResultDO.isSuccess());
    }

    @Test
    public void fInsert() {
        GoodsDO goodsDO = new GoodsDO();
        goodsDO.setId(3);
        goodsDO.setName("ipda pro 2018");
        ResultDO<Void> insert = goodsService.insert(goodsDO);
        Assert.assertEquals(true, insert.isSuccess());
    }

    @Test
    public void gDelete() {
        ResultDO<Void> voidResultDO = goodsService.deleteById(3);
        Assert.assertEquals(true, voidResultDO.isSuccess());
    }
}
