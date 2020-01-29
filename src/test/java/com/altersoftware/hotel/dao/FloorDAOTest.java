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

import com.altersoftware.hotel.entity.FloorDO;

/**
 * @author czy@win10
 * @date 2020/1/26 14:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FloorDAOTest {

    private static final int    ID            = 1;
    private static final int    ROOMNUMBERS   = 30;
    private static final String FIRE_DIAGRAM  =
        "http://g.search.alicdn.com/img/bao/uploaded/i4/i3/TB1HbD9HXXXXXahXpXXXXXXXXXX_!!0-item_pic.jpg";
    private static final String PLAN_DIAGRAM  =
        "http://img5.imgtn.bdimg.com/it/u=1035415831,1465727770&fm=26&gp=0.jpg";
    private static final String THREED_DAGRAM =
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQaOdo98dbzDKaRlQnRNaTqHrEgfI0MKg_vxV83YWzSDpPO3GnjaQ&s";

    @Resource
    private FloorDAO            floorDAO;

    @Test
    public void aInsert() {
        FloorDO floorDO = new FloorDO();
        floorDO.setId(ID);
        floorDO.setPlan(PLAN_DIAGRAM);
        floorDO.setroomNumbers(ROOMNUMBERS);
        floorDO.setFireDiagram(FIRE_DIAGRAM);
        floorDO.setThreeDDiagram(THREED_DAGRAM);
        floorDAO.insert(floorDO);
    }

    @Test
    public void bGetById() {
        FloorDO floorDOById = floorDAO.getFloorDOById(ID);
        System.out.println(floorDOById);
        Assert.assertNotNull(floorDOById);
    }

    @Test
    public void cUpdate() {
        FloorDO floorDOById = floorDAO.getFloorDOById(ID);
        floorDOById.setroomNumbers(floorDOById.getroomNumbers() + 1);
        int update = floorDAO.update(floorDOById);
        System.out.println(update);
        Assert.assertEquals(1, update);
    }

    @Test
    public void dGetIdList() {
        List<Long> floorIdList = floorDAO.getFloorIdList();
        System.out.println(floorIdList);
        Assert.assertNotNull(floorIdList);
    }

    @Test
    public void eDeleteById() {
        int i = floorDAO.deleteById(ID);
        Assert.assertEquals(1, i);
        FloorDO floorDOById = floorDAO.getFloorDOById(ID);
        System.out.println(floorDOById);
        Assert.assertNull(floorDOById);
    }

}
