package com.altersoftware.hotel;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altersoftware.hotel.AliPay.AlipayService;

/**
 * @author Iszychen@win10
 * @date 2020/2/7 23:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AliPayTest {

    @Resource
    private AlipayService alipayService;

    @Test
    public void Test() throws Exception {
        alipayService.appPagePay("201923123123123", 44, "ceshi");
    }

}
