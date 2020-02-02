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
import com.altersoftware.hotel.entity.RoomTypeDO;

/**
 * @author czy@win10
 * @date 2020/2/2 16:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoomTypeServiceTest {
    private static final int    ID                = 3;
    private static final String GOOD_BEDROOM_TYPE = "500";

    @Resource
    private RoomTypeService     roomTypeService;

    @Test
    public void aInsert() {
        RoomTypeDO roomTypeDO = new RoomTypeDO();
        roomTypeDO.setId(ID);
        roomTypeDO.setRoomType(GOOD_BEDROOM_TYPE);
        ResultDO<Void> insert = roomTypeService.insert(roomTypeDO);
        Assert.assertEquals(true, insert.isSuccess());
    }

    @Test
    public void bGetById() {
        ResultDO<RoomTypeDO> roomTypeDOById = roomTypeService.getRoomTypeDOById(ID);
        Assert.assertEquals(true, roomTypeDOById.isSuccess());
    }

    @Test
    public void cUpdate() {
        ResultDO<RoomTypeDO> roomTypeDOById = roomTypeService.getRoomTypeDOById(ID);
        RoomTypeDO typeDO = roomTypeDOById.getModule();
        typeDO.setName("总统套房");
        ResultDO<Void> voidResultDO = roomTypeService.updateRoom(typeDO);
        Assert.assertEquals(true, voidResultDO.isSuccess());
    }

    @Test
    public void dGetList() {
        ResultDO<List<RoomTypeDO>> roomTypes = roomTypeService.getRoomTypes();
        Assert.assertEquals(true, roomTypes.isSuccess());
    }

    @Test
    public void eDelete() {
        ResultDO<Void> voidResultDO = roomTypeService.deleteRoomTypeDO(ID);
        Assert.assertEquals(true, voidResultDO.isSuccess());
    }
}
