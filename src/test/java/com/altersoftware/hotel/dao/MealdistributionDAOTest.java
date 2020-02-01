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

import com.altersoftware.hotel.entity.MealdistributionDO;

/**
 * @author czy@win10
 * @date 2020/2/1 15:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MealdistributionDAOTest {

    private static final long   ID       = 1;
    private static final long   ROOOM_ID = 1;
    private static final long   STAFF_ID = 10005;
    private static final long   ORDER_ID = 1;

    @Resource
    private MealdistributionDAO mealdistributionDAO;

    @Test
    public void aInsert() {
        MealdistributionDO mealdistributionDO = new MealdistributionDO();
        mealdistributionDO.setId(ID);
        mealdistributionDO.setRoomID(ROOOM_ID);
        mealdistributionDO.setStaffID(STAFF_ID);
        mealdistributionDO.setMenuID(ORDER_ID);
        mealdistributionDAO.insert(mealdistributionDO);
    }

    @Test
    public void bGetById() {
        MealdistributionDO mealdistributionDOById = mealdistributionDAO.getMealdistributionDOById(ID);
        System.out.println(mealdistributionDOById);
        Assert.assertNotNull(mealdistributionDOById);
    }

    @Test
    public void cGetByRoomId() {
        List<MealdistributionDO> mealdistributionDOByRoomId =
            mealdistributionDAO.getMealdistributionDOByRoomId(ROOOM_ID);
        System.out.println(mealdistributionDOByRoomId);
        Assert.assertNotNull(mealdistributionDOByRoomId);
    }

    @Test
    public void dGetByStaffId() {
        List<MealdistributionDO> mealdistributionDOByStaffId =
            mealdistributionDAO.getMealdistributionDOByStaffId(STAFF_ID);
        System.out.println(mealdistributionDOByStaffId);
        Assert.assertNotNull(mealdistributionDOByStaffId);
    }

    @Test
    public void eStart() {
        int start = mealdistributionDAO.start(STAFF_ID);
        Assert.assertEquals(start, 1);
    }

    @Test
    public void fEnd() {
        int end = mealdistributionDAO.end(STAFF_ID);
        Assert.assertEquals(end, 1);
    }

    @Test
    public void gUpdate() {
        MealdistributionDO mealdistributionDOById = mealdistributionDAO.getMealdistributionDOById(ID);
        mealdistributionDOById.setMenuID(2);
        int update = mealdistributionDAO.update(mealdistributionDOById);
        Assert.assertEquals(1, update);
    }

    @Test
    public void hDelete() {
        int i = mealdistributionDAO.deleteById(ID);
        Assert.assertEquals(1, i);
    }
}
