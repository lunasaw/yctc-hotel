package com.altersoftware.hotel.service;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altersoftware.hotel.entity.HotelDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author czy@win10
 * @date 2020/1/30 21:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HotelServiceTest {

    @Resource
    private HotelService hotelService;

    @Test
    public void aGetHotel() {
        ResultDO<HotelDO> hotelDOResultDO = hotelService.showHotel(1);
        Assert.assertNotNull(hotelDOResultDO);
    }

    @Test
    public void bUpdate() {
        ResultDO<HotelDO> hotelDOResultDO = hotelService.showHotel(1);
        hotelDOResultDO.getModule().setRoomNumbers(600);
        ResultDO<Void> voidResultDO = hotelService.updateHotel(hotelDOResultDO.getModule());
    }

    @Test
    public void cInsert() {
        ResultDO<HotelDO> hotelDOResultDO = hotelService.showHotel(1);
        long id = hotelDOResultDO.getModule().getId();
        HotelDO module = hotelDOResultDO.getModule();
        module.setId(id + 1);
        ResultDO<Void> voidResultDO = hotelService.insertHotel(module);
    }
}
