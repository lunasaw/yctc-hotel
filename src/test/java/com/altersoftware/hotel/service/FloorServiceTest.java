package com.altersoftware.hotel.service;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altersoftware.hotel.entity.FloorDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author czy@win10
 * @date 2020/1/28 21:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FloorServiceTest {

    @Resource
    private FloorService floorService;

    @Test
    public void aGet2d() {
        ResultDO<String> stringResultDO = floorService.show2D(1);
        System.out.println(stringResultDO);
        Assert.assertNotNull(stringResultDO);
    }

    @Test
    public void bGet3D() {
        ResultDO<String> stringResultDO = floorService.show3D(1);
        System.out.println(stringResultDO);
        Assert.assertNotNull(stringResultDO.getModule());
    }

    @Test
    public void cGetFire() {
        ResultDO<String> stringResultDO = floorService.showFire(1);
        System.out.println(stringResultDO);
        Assert.assertNotNull(stringResultDO.getModule());
    }

    @Test
    public void dInsert() {
        FloorDO floorDO = new FloorDO();
        floorDO.setPlan("1.jpg");
        floorDO.setFireDiagram("2.jpg");
        floorDO.setThreeDDiagram("3.jpg");
        floorDO.setroomNumbers(1);
        floorDO.setId(2);
        ResultDO<Void> insert = floorService.insert(floorDO);
    }

    @Test
    public void eDelete() {
        ResultDO<Void> delete = floorService.delete(2);
    }
}
