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

import com.altersoftware.hotel.entity.LeaseDO;

/**
 * @author czy@win10
 * @date 2020/1/30 14:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LeaseDAOTest {

    private static final long   ID          = 2;
    private static final long   GOODS_ID    = 1;
    private static final long   CUSTOMER_ID = 100003;
    private static final String RENTAL_TIME = "24h";

    @Resource
    private LeaseDAO            leaseDAO;

    @Test
    public void aInsert() {
        LeaseDO leaseDO = new LeaseDO();
        leaseDO.setId(ID);
        leaseDO.setGoodsId(GOODS_ID);
        leaseDO.setRentalTime(RENTAL_TIME);
        leaseDO.setCustomerId(CUSTOMER_ID);
        leaseDAO.insert(leaseDO);
    }

    @Test
    public void bGetById() {
        LeaseDO leaseDOById = leaseDAO.getLeaseDOById(ID);
        System.out.println(leaseDOById);
        Assert.assertNotNull(leaseDOById);
    }

    @Test
    public void cUpdate() {
        LeaseDO leaseDOById = leaseDAO.getLeaseDOById(ID);
        leaseDOById.setRentalTime("36h");
        int update = leaseDAO.update(leaseDOById);
        System.out.println(update);
        Assert.assertEquals(1, update);
    }

    @Test
    public void dSetRetrun() {
        int i = leaseDAO.returnGoods(ID);
        System.out.println(i);
        Assert.assertEquals(1, i);
    }

    @Test
    public void eGetByCustomer() {
        List<LeaseDO> leaseDOByCustomerId = leaseDAO.getLeaseDOByCustomerId(CUSTOMER_ID);
        System.out.println(leaseDOByCustomerId);
        Assert.assertNotNull(leaseDOByCustomerId);
    }

    @Test
    public void zDeleteById() {
        int i = leaseDAO.deleteById(ID);
        Assert.assertEquals(1, i);
        LeaseDO leaseDOById = leaseDAO.getLeaseDOById(ID);
        System.out.println(leaseDOById);
        Assert.assertNull(leaseDOById);
    }

}
