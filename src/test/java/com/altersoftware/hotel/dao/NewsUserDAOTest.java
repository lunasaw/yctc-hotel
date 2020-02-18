package com.altersoftware.hotel.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Iszychen@win10
 * @date 2020/2/18 20:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NewsUserDAOTest {

    @Resource
    private UserNewsDAO userNewsDAO;

    @Test
    public void Test() {
        List<Long> noReadNewsIdByUserId = userNewsDAO.getNoReadNewsIdByUserId(10013);
        System.out.println(noReadNewsIdByUserId);
    }

}
