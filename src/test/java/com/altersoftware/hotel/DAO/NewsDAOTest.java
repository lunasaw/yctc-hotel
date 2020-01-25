package com.altersoftware.hotel.DAO;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altersoftware.hotel.dao.NewsDAO;
import com.altersoftware.hotel.entity.NewsDO;

/**
 * @author czy@win10
 * @date 2020/1/24 14:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NewsDAOTest {

    private static final long   ID      = 1;
    private static final String TITLE   = "测试";
    private static final String CONTENT = "陈章月NewsDAO第一次测试";

    @Resource
    private NewsDAO             newsDAO;

    @Test
    public void aInsert() {
        NewsDO newsDO = new NewsDO();
        newsDO.setId(ID);
        newsDO.setTitle(TITLE);
        newsDO.setContent(CONTENT);
        newsDAO.insert(newsDO);
    }

    @Test
    public void bGetById() {
        NewsDO newsDOById = newsDAO.getNewsDOById(ID);
        System.out.println(newsDOById);
        Assert.assertNotNull(newsDOById);
    }

    @Test
    public void cUpdate() {
        NewsDO newsDOById = newsDAO.getNewsDOById(ID);
        newsDOById.setContent("陈章月第二次测试");
        int update = newsDAO.update(newsDOById);
        Assert.assertEquals(1, update);
    }

    @Test
    public void dDelete() {
        newsDAO.deleteById(ID);
        NewsDO newsDOById = newsDAO.getNewsDOById(ID);
        System.out.println(newsDOById);
        Assert.assertNull(newsDOById);
    }

}
