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

import com.altersoftware.hotel.entity.MenuDO;

/**
 * @author czy@win10
 * @date 2020/1/30 14:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MenuDAOTest {

    private static final long   ID      = 2;
    private static final String NAME    = "红烧肉";
    private static final Double PRICE   = 23.0;
    private static final int    NUMBERS = 20;
    private static final String PICTURE =
        "https://i8.meishichina.com/attachment/recipe/201112/13/201112131158155.jpg?x-oss-process=style/p800";

    @Resource
    private MenuDAO             menuDAO;

    @Test
    public void aInsert() {
        MenuDO menuDO = new MenuDO();
        menuDO.setId(ID);
        menuDO.setName(NAME);
        menuDO.setPrice(PRICE);
        menuDO.setNumbers(NUMBERS);
        menuDO.setPicture(PICTURE);
        menuDAO.insert(menuDO);
    }

    @Test
    public void bGetById() {
        MenuDO menuDOById = menuDAO.getMenuDOById(ID);
        System.out.println(menuDOById);
        Assert.assertNotNull(menuDOById);
    }

    @Test
    public void cUpdate() {
        MenuDO menuDOById = menuDAO.getMenuDOById(ID);
        menuDOById.setPrice(25.0);
        int update = menuDAO.update(menuDOById);
        System.out.println(update);
        Assert.assertEquals(1, update);
    }

    @Test
    public void dGetIdList() {
        List<MenuDO> menuDOS = menuDAO.getMenuDOList();
        System.out.println(menuDOS);
        Assert.assertNotNull(menuDOS);
    }

    @Test
    public void eDeleteById() {
        int i = menuDAO.deleteById(ID);
        Assert.assertEquals(1, i);
        MenuDO menuDOById = menuDAO.getMenuDOById(ID);
        System.out.println(menuDOById);
        Assert.assertNull(menuDOById);
    }
}
