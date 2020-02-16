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

import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.RoomDO;

/**
 * @author czy@win10
 * @date 2020/1/29 21:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoomServiceTest {

    @Resource
    private RoomService roomService;

    @Test
    public void aGetAllRooms() {
        ResultDO<List<RoomDO>> rooms = roomService.getRooms();
        Assert.assertEquals(true, rooms.isSuccess());
    }

    @Test
    public void bUpdate() {
        ResultDO<RoomDO> roomDO = roomService.getRoomDO(1);
        RoomDO module = roomDO.getModule();
        module.setPrice(190);
        ResultDO<Void> voidResultDO = roomService.updateRoom(module);
        Assert.assertEquals(true, voidResultDO.isSuccess());
    }

    @Test
    public void cGetByNumber() {
        ResultDO<RoomDO> roomDOByNumber = roomService.getRoomDOByNumber(101);
        RoomDO roomDO = roomDOByNumber.getModule();
        Assert.assertEquals(true, roomDOByNumber.isSuccess());
    }

    @Test
    public void Test() {
        RoomDO roomDO = new RoomDO();
        roomService.insert(roomDO);
    }

    @Test
    public void dGetById() {
        ResultDO<RoomDO> roomDO = roomService.getRoomDO(1);
        Assert.assertEquals(true, roomDO.isSuccess());
    }
}
