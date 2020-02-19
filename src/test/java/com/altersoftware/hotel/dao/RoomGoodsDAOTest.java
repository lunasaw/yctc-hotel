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

import com.altersoftware.hotel.constant.entity.goods.GoodsState;
import com.altersoftware.hotel.entity.RoomGoodsDO;

/**
 * @author Iszychen@win10
 * @date 2020/2/18 23:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoomGoodsDAOTest {

    private static final int    ROOM_NUMBER = 111;
    private static final String GOODS_NAME  = "空调";
    private static final String STATE       = GoodsState.TEMPERATURE;

    @Resource
    private RoomGoodsDAO        roomGoodsDAO;

    @Test
    public void aInsert() {
        RoomGoodsDO roomGoodsDO = new RoomGoodsDO();
        roomGoodsDO.setState(STATE);
        roomGoodsDO.setRoomNumber(ROOM_NUMBER);
        roomGoodsDO.setGoodsName(GOODS_NAME);
        roomGoodsDAO.insert(roomGoodsDO);
        RoomGoodsDO roomGoodsDOByRoomNumberAndGoodsName =
            roomGoodsDAO.getRoomGoodsDOByRoomNumberAndGoodsName(ROOM_NUMBER, GOODS_NAME);
        Assert.assertNotNull(roomGoodsDOByRoomNumberAndGoodsName);
    }

    @Test
    public void bGet() {
        RoomGoodsDO roomGoodsDOByRoomNumberAndGoodsName =
            roomGoodsDAO.getRoomGoodsDOByRoomNumberAndGoodsName(ROOM_NUMBER, GOODS_NAME);
        Assert.assertNotNull(roomGoodsDOByRoomNumberAndGoodsName);
    }

    @Test
    public void cGetListByRoom() {
        List<RoomGoodsDO> goodsStateListByRoom = roomGoodsDAO.getGoodsStateListByRoom(ROOM_NUMBER);
        System.out.println(goodsStateListByRoom);
        Assert.assertNotNull(goodsStateListByRoom);
    }

    @Test
    public void dGetListByName() {
        List<RoomGoodsDO> oneGoodsStateListByName = roomGoodsDAO.getOneGoodsStateListByName(GOODS_NAME);
        System.out.println(oneGoodsStateListByName);
        Assert.assertNotNull(oneGoodsStateListByName);
    }

    @Test
    public void eDeleteByRoomAndGoods() {
        int i = roomGoodsDAO.deleteByRoomNumberAndGoodsName(ROOM_NUMBER, GOODS_NAME);
        Assert.assertEquals(1, i);
    }
}
