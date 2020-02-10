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

import com.altersoftware.hotel.entity.OrderDO;

/**
 * @author czy@win10
 * @date 2020/2/1 20:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderDAOTest {

    private static final long   ID          = 100;
    private static final long   MENU_ID     = 2;
    private static final long   CUSTOMER_ID = 10004;
    private static final double PAY_MONEY   = 560;
    private static final int    STATE       = 0;
    private static final int    NUMBERS     = 2;

    @Resource
    private OrderDAO            orderDAO;

    @Test
    public void aInsert() {
        OrderDO orderDO = new OrderDO();
        orderDO.setId(ID);
        orderDO.setMenuId(MENU_ID);
        orderDO.setCustomerId(CUSTOMER_ID);
        orderDO.setNumbers(NUMBERS);
        orderDO.setPayMoney(PAY_MONEY);
        orderDO.setState(STATE);
        orderDAO.insert(orderDO);
    }

    @Test
    public void bGetById() {
        OrderDO orderDOById = orderDAO.getOrderDOById(ID);
        System.out.println(orderDOById);
        Assert.assertNotNull(orderDOById);
    }

    @Test
    public void bUpdate() {
        OrderDO orderDOById = orderDAO.getOrderDOById(ID);
        orderDOById.setNumbers(3);
        int update = orderDAO.update(orderDOById);
        Assert.assertEquals(1, update);
    }

    @Test
    public void cGetList() {
        List<Long> OrderIdList = orderDAO.getOrderIdList();
        System.out.println(OrderIdList);
        Assert.assertNotNull(OrderIdList);
    }

    @Test
    public void dDelete() {
        int i = orderDAO.deleteById(ID);
        System.out.println(i);
        Assert.assertEquals(1, i);
    }

}
