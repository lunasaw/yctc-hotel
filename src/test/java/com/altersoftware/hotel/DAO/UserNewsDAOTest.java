package com.altersoftware.hotel.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altersoftware.hotel.dao.UserNewsDAO;
import com.altersoftware.hotel.entity.UserNewsDO;

/**
 * @author czy@win10
 * @date 2020/1/24 13:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserNewsDAOTest {

    private static final long ID      = 1;
    private static final long USER_ID = 10004;
    private static final long NEWS_ID = 1;
    private static final int  STATE   = 1;

    @Resource
    private UserNewsDAO       userNewsDAO;

    @Test
    public void aInsert() {
        UserNewsDO userNewsDO = new UserNewsDO();
        userNewsDO.setId(ID);
        userNewsDO.setUserId(USER_ID);
        userNewsDO.setNewsId(NEWS_ID);
        userNewsDAO.insert(userNewsDO);
    }

    @Test
    public void bGetById() {
        UserNewsDO userNewsDOById = userNewsDAO.getUserNewsDOById(ID);
        System.out.println(userNewsDOById);
        Assert.assertNotNull(userNewsDOById);
    }

    @Test
    public void cGetByUserId() {
        List<Long> newsIdByUserId = userNewsDAO.getNewsIdByUserId(USER_ID);
        System.out.println(newsIdByUserId);
        Assert.assertNotNull(newsIdByUserId);
    }

    @Test
    public void eGetByNoRead() {
        List<Long> noReadNewsIdByUserId = userNewsDAO.getNoReadNewsIdByUserId(USER_ID);
        System.out.println(noReadNewsIdByUserId);
        Assert.assertNotNull(noReadNewsIdByUserId);
    }

    @Test
    public void fUpdate() {
        UserNewsDO userNewsDOById = userNewsDAO.getUserNewsDOById(ID);
        userNewsDOById.setState(0);
        int update = userNewsDAO.update(userNewsDOById);
        Assert.assertEquals(1, update);
    }

    @Test
    public void dGetByRead() {
        List<Long> readedNewsIdByUserId = userNewsDAO.getReadedNewsIdByUserId(USER_ID);
        System.out.println(readedNewsIdByUserId);
        Assert.assertNotNull(readedNewsIdByUserId);
    }

    @Test
    public void gGetReadedNewsIdByUserId() {
        UserNewsDO userNewsDOByUserIdAndNewsId = userNewsDAO.getUserNewsDOByUserIdAndNewsId(USER_ID, NEWS_ID);
        System.out.println(userNewsDOByUserIdAndNewsId);
        Assert.assertNotNull(userNewsDOByUserIdAndNewsId);
    }

    @Test
    public void hDeleteById() {
        userNewsDAO.deleteById(ID);
        UserNewsDO userNewsDOById = userNewsDAO.getUserNewsDOById(ID);
        Assert.assertNull(userNewsDOById);
    }

    @Test
    public void iDeleteByUserId() {
        userNewsDAO.deleteAllReadedNewsByUserId(USER_ID);
        List<Long> newsIdByUserId = userNewsDAO.getNewsIdByUserId(USER_ID);
        System.out.println(newsIdByUserId);
        Assert.assertEquals(0, newsIdByUserId.size());
    }
}
