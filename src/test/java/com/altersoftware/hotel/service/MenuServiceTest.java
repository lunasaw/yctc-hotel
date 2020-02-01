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

import com.altersoftware.hotel.entity.MenuDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author czy@win10
 * @date 2020/2/1 21:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MenuServiceTest {

    private static final long   ID      = 3;
    private static final String NAME    = "清蒸带鱼";
    private static final Double PRICE   = 40.0;
    private static final int    NUMBERS = 20;
    private static final String PICTURE =
        "https://st-cn.meishij.net/r/207/244/2811207/s2811207_155608467356417.jpg";

    @Resource
    private MenuService         menuService;

    @Test
    public void aInsert() {
        MenuDO menuDO = new MenuDO();
        menuDO.setId(ID);
        menuDO.setName(NAME);
        menuDO.setPicture(PICTURE);
        menuDO.setPrice(PRICE);
        menuDO.setNumbers(NUMBERS);
        ResultDO<Void> insert = menuService.insert(menuDO);
        Assert.assertEquals(true, insert.isSuccess());
    }

    @Test
    public void bGetById() {
        ResultDO<MenuDO> menuDOResultDO = menuService.showById(ID);
        Assert.assertEquals(true, menuDOResultDO.isSuccess());
    }

    @Test
    public void cUpdate() {
        ResultDO<MenuDO> menuDOResultDO = menuService.showById(ID);
        MenuDO module = menuDOResultDO.getModule();
        module.setPrice(55.0);
        ResultDO<Void> update = menuService.update(module);
        Assert.assertEquals(true, update.isSuccess());
    }

    @Test
    public void dGetAll() {
        ResultDO<List<MenuDO>> listResultDO = menuService.showAll();
        Assert.assertEquals(true, listResultDO.isSuccess());
    }

    @Test
    public void eDelete() {
        ResultDO<Void> delete = menuService.delete(ID);
        Assert.assertEquals(true, delete.isSuccess());
    }

}
