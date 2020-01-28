package com.altersoftware.hotel.dao;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altersoftware.hotel.constant.entity.room.RoomState;
import com.altersoftware.hotel.constant.entity.room.RoomType;
import com.altersoftware.hotel.entity.RoomDO;

/**
 * @author czy@win10
 * @date 2020/1/27 16:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RommDAOTest {
    private static final int    ID       = 1;
    private static final int    FLOOR_ID = 1;
    private static final String TYPE     = RoomType.BIG_BEDROOM;
    private static final double PRICE    = RoomType.BIG_BEDROOM_PRICE;
    private static final double DEPOSIT  = RoomType.BIG_BEDROOM_DEPOSIT;
    private static final int    state    = RoomState.CHECK_IN;

    @Resource
    private RoomDAO             roomDAO;

    @Test
    public void aInsert() {
        RoomDO roomDO = new RoomDO();
        roomDO.setId(ID);
        roomDO.setFloorID(FLOOR_ID);
        roomDO.setType(TYPE);
        roomDO.setPrice(PRICE);
        roomDO.setDeposit(DEPOSIT);
        roomDO.setState(state);
        roomDAO.insert(roomDO);
    }

    @Test
    public void bGetById() {
        RoomDO roomDOById = roomDAO.getRoomDOById(ID);
        System.out.println(roomDOById);
        Assert.assertNotNull(roomDOById);
    }

    @Test
    public void cUpdate() {
        RoomDO roomDOById = roomDAO.getRoomDOById(ID);
        roomDOById.setState(RoomState.CHECK_OUT);
        int update = roomDAO.update(roomDOById);
        Assert.assertEquals(1, update);
    }

    @Test
    public void dDelete() {
        int i = roomDAO.deleteById(ID);
        Assert.assertEquals(1, i);
    }
}
