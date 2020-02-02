package com.altersoftware.hotel.dao;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altersoftware.hotel.entity.RoomTypeDO;

/**
 * @author czy@win10
 * @date 2020/2/2 14:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoomTypeDAOTest {

    private static final long   ID               = 1;
    private static final String NAME             = "大床房";
    private static final String BIG_BEDROOM_TYPE = "501";
    private static final int    USER_NUMBER      = 2;
    private static final String DESCRIPTION      = "真心为您服务，期待与您相识，为您的旅途保驾护航";
    private static final String WIDE             = "20m2";
    private static final String ADD_BED          = "是";

    @Resource
    private RoomTyoeDAO         roomTyoeDAO;

    @Test
    public void aInsert() {
        RoomTypeDO roomTypeDO = new RoomTypeDO();
        roomTypeDO.setId(ID);
        roomTypeDO.setRoomType(BIG_BEDROOM_TYPE);
        roomTypeDO.setName(NAME);
        roomTypeDO.setUserNumber(USER_NUMBER);
        roomTypeDO.setDescribe(DESCRIPTION);
        roomTypeDO.setWide(WIDE);
        roomTypeDO.setAddBed(ADD_BED);
        roomTyoeDAO.insert(roomTypeDO);
    }

    @Test
    public void bGetById() {
        RoomTypeDO roomTypeDOById = roomTyoeDAO.getRoomTypeDOById(ID);
        System.out.println(roomTypeDOById);
        Assert.assertNotNull(roomTypeDOById);
    }

    @Test
    public void cUpdat() {
        RoomTypeDO roomTypeDOById = roomTyoeDAO.getRoomTypeDOById(ID);
        roomTypeDOById.setAddBed("是");
        int update = roomTyoeDAO.update(roomTypeDOById);
        Assert.assertEquals(1, update);
    }

    @Test
    public void dDelete() {
        int i = roomTyoeDAO.deleteById(ID);
        RoomTypeDO roomTypeDOById = roomTyoeDAO.getRoomTypeDOById(ID);
        Assert.assertNull(roomTypeDOById);
    }

}
