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

import com.altersoftware.hotel.entity.VipGradeDO;

/**
 * @author czy@win10
 * @date 2020/1/26 14:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VipGradeDAOTest {

    private static final long   ID       = 1;
    private static final String EQUITY   = "快速退房:无需人员查房,一点即退";
    private static final String GRADE    = "至尊会员";
    private static final Double DISCOUNT = 0.8;

    @Resource
    private VipGradeDAO         vipGradeDAO;

    @Test
    public void aInsert() {
        VipGradeDO vipGradeDO = new VipGradeDO();
        vipGradeDO.setId(ID);
        vipGradeDO.setEquity(EQUITY);
        vipGradeDO.setGrade(GRADE);
        vipGradeDO.setDiscount(DISCOUNT);
        vipGradeDAO.insert(vipGradeDO);
    }

    @Test
    public void bGetById() {
        VipGradeDO vipGradeDOById = vipGradeDAO.getVipGradeDOById(ID);
        System.out.println(vipGradeDOById);
        Assert.assertNotNull(vipGradeDOById);
    }

    @Test
    public void cUpdate() {
        VipGradeDO vipGradeDOById = vipGradeDAO.getVipGradeDOById(ID);
        vipGradeDOById.setGrade("至尊会员");
        int update = vipGradeDAO.update(vipGradeDOById);
        System.out.println(update);
        Assert.assertEquals(1, update);
    }

    @Test
    public void dGetIdList() {
        List<VipGradeDO> floorIdList = vipGradeDAO.getVipIdList("至尊会员");
        System.out.println(floorIdList);
        Assert.assertNotNull(floorIdList);
    }

    @Test
    public void eDeleteById() {
        int i = vipGradeDAO.deleteById(ID);
        Assert.assertEquals(1, i);
        VipGradeDO vipGradeDOById = vipGradeDAO.getVipGradeDOById(ID);
        Assert.assertNull(vipGradeDOById);
    }

}
