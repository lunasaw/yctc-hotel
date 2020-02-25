package com.altersoftware.hotel.service;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altersoftware.hotel.entity.CheckInWithDO;

/**
 * @author Iszychen@win10
 * @date 2020/2/25 21:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CheckInWirhServiceTest {

    @Resource
    private CheckInWithService checkInWithService;

    @Test
    public void aTest() {
        CheckInWithDO checkInWithDO = new CheckInWithDO();
        checkInWithDO.setCustomerId(10013);
        checkInWithService.insert(checkInWithDO);
    }

}
