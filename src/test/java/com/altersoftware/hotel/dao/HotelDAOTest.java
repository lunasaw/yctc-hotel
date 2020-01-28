package com.altersoftware.hotel.dao;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altersoftware.hotel.entity.HotelDO;

/**
 * @author czy@win10
 * @date 2020/1/25 22:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HotelDAOTest {

    private static final long   ID           = 1;
    private static final String NAME         = "AlterSoftware";
    private static final int    FLOOR_NUMBER = 1;
    private static final int    ROOM_NUMBER  = 50;
    private static final int    MOBILE       = 95500103;
    private static final String ADDRESS      = "江苏省盐城市亭湖区";
    private static final String RULES        =
        "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1579971832231&di=85e9655f5c04b89e80334e1aa31b7369&imgtype=0&src=http%3A%2F%2Fpic168.nipic.com%2Ffile%2F20180609%2F6538788_101241292000_2.jpg";

    @Resource
    private HotelDAO            hotelDAO;

    @Test
    public void aInsert() {
        HotelDO hotelDO = new HotelDO();
        hotelDO.setId(ID);
        hotelDO.setAddress(ADDRESS);
        hotelDO.setName(NAME);
        hotelDO.setFloorNumbers(FLOOR_NUMBER);
        hotelDO.setRoomNumbers(ROOM_NUMBER);
        hotelDO.setRules(RULES);
        hotelDO.setMobile(MOBILE);
        hotelDAO.insert(hotelDO);
    }

    @Test
    public void bGetById() {
        HotelDO hotelDOById = hotelDAO.getHotelDOById(ID);
        System.out.println(hotelDOById);
        Assert.assertNotNull(hotelDOById);
    }

    @Test
    public void cUpdate() {
        HotelDO hotelDOById = hotelDAO.getHotelDOById(ID);
        hotelDOById.setAddress(hotelDOById.getAddress() + "通榆校区");
        int update = hotelDAO.update(hotelDOById);
        System.out.println(update);
        Assert.assertEquals(1, update);
    }

    @Test
    public void dDeleteById() {
        int i = hotelDAO.deleteById(ID);
        Assert.assertEquals(1, i);
        HotelDO hotelDOById = hotelDAO.getHotelDOById(ID);
        System.out.println(hotelDOById);
        Assert.assertNull(hotelDOById);
    }

}
