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

import com.altersoftware.hotel.entity.VipDO;

/**
 * @author czy@win10
 * @date 2020/1/26 14:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VipDAOTest {

    private static final long   ID              = 1;
    private static final long   CUSTOMER_NUMBER = 95002;
    private static final String GRADE           = "普通会员";
    private static final Double PAY_AMOUNT      = 35800.0;

    @Resource
    private VipDAO              vipDAO;

    @Test
    public void aInsert() {
        VipDO vipDO = new VipDO();
        vipDO.setId(ID);
        vipDO.setCustomerNumber(CUSTOMER_NUMBER);
        vipDO.setGrade(GRADE);
        vipDO.setAmount(PAY_AMOUNT);
        vipDAO.insert(vipDO);
    }

    @Test
    public void bGetById() {
        VipDO vipDOById = vipDAO.getVipDOById(10013);
        System.out.println(vipDOById);
        Assert.assertNotNull(vipDOById);
    }

    @Test
    public void cUpdate() {
        VipDO vipDOById = vipDAO.getVipDOById(ID);
        vipDOById.setGrade("至尊会员");
        int update = vipDAO.update(vipDOById);
        System.out.println(update);
        Assert.assertEquals(1, update);
    }

    @Test
    public void dGetIdList() {
        List<Long> floorIdList = vipDAO.getVipIdList();
        System.out.println(floorIdList);
        Assert.assertNotNull(floorIdList);
    }

    @Test
    public void eDeleteById() {
        int i = vipDAO.deleteById(ID);
        Assert.assertEquals(1, i);
        VipDO vipDOById = vipDAO.getVipDOById(ID);
        Assert.assertNull(vipDOById);
    }

}
