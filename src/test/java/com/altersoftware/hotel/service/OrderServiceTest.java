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

import com.altersoftware.hotel.entity.OrderDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author czy@win10
 * @date 2020/1/31 22:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderServiceTest {

    @Resource
    private OrderService orderService;

    @Test
    public void aShowOrder() {
        ResultDO<OrderDO> orderDOResultDO = orderService.showOrder(1);
        Assert.assertEquals(true, orderDOResultDO.isSuccess());
    }

    @Test
    public void bGetAll() {
        ResultDO<List<OrderDO>> all = orderService.getAll();
        Assert.assertEquals(true, all.isSuccess());

    }

    @Test
    public void cUpdate() {
        ResultDO<OrderDO> orderDOResultDO = orderService.showOrder(2);
        OrderDO module = orderDOResultDO.getModule();
        module.setState(1);
        ResultDO<Void> voidResultDO = orderService.updateOrder(module);
        Assert.assertEquals(true, voidResultDO.isSuccess());
    }

    @Test
    public void eshowOrderByRoomNumber() {
        ResultDO<List<OrderDO>> listResultDO = orderService.showOrderByCustomerId(10026);
        Assert.assertEquals(true, listResultDO.isSuccess());
    }

    @Test
    public void fInsert() {
        OrderDO orderDO = new OrderDO();
        orderDO.setId(11);
        orderDO.setPayMoney(99);
        ResultDO<Void> insert = orderService.createOrder(orderDO);
        Assert.assertEquals(true, insert.isSuccess());
    }

    @Test
    public void zDelete() {
        ResultDO<Void> voidResultDO = orderService.deleteById(11);
        Assert.assertEquals(true, voidResultDO.isSuccess());
    }

    @Test
    public void gReturnActualMoney() {
        ResultDO<Double> actualMoney = orderService.getActualMoney(10026);
        Assert.assertEquals(true, actualMoney.isSuccess());
    }
}
