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

import com.altersoftware.hotel.entity.RecordDO;

/**
 * @author Iszychen@win10
 * @date 2020/2/7 14:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RecordDAOTest {
    private static final long   ID              = 10;
    private static final int    ROOM_NUMBER     = 442;
    private static final long   CUSTOMER_ID     = 95002;
    private static final long   STAFF_ID        = 95001;
    private static final String CHECKIN_TIME    = "2019-11-1";
    private static final String CHECKOUT_TIME   = "2019-11-2";
    private static final String PRE_CHECKINTIME = "1";
    private static final String RECORD_EVALUATE = "较为舒适";

    @Resource
    private RecordDAO           recordDAO;

    @Test
    public void aInsert() {
        RecordDO recordDO = new RecordDO();
        recordDO.setId(ID);
        recordDO.setRoomNumber(ROOM_NUMBER);
        recordDO.setCustomerId(CUSTOMER_ID);
        recordDO.setStaffId(STAFF_ID);
        recordDO.setCheckInTime(CHECKIN_TIME);
        recordDO.setCheckOutTime(CHECKOUT_TIME);
        recordDO.setPrecheckInTime(PRE_CHECKINTIME);
        recordDO.setEvaluate(RECORD_EVALUATE);
        recordDAO.insert(recordDO);
    }

    @Test
    public void bGetById() {
        RecordDO recordDOById = recordDAO.getRecordDOById(10);
        System.out.println(recordDOById);
        Assert.assertNotNull(recordDOById);
    }

    @Test
    public void cGetAll() {
        List<RecordDO> all = recordDAO.getAll();
        System.out.println(all);
        Assert.assertNotNull(all);
    }

    @Test
    public void dUpdate() {
        RecordDO recordDOById = recordDAO.getRecordDOById(ID);
        System.out.println(recordDOById);
        recordDOById.setPrecheckInTime("3");
        int update = recordDAO.update(recordDOById);
        Assert.assertEquals(1, update);
    }

    @Test
    public void dGetByRoomNumber() {
        List<RecordDO> recordDOByRoomNumber = recordDAO.getRecordDOByRoomNumber(ROOM_NUMBER);
        System.out.println(recordDOByRoomNumber);
        Assert.assertNotNull(recordDOByRoomNumber);
    }

    @Test
    public void dGetByRoomCustomer() {
        List<RecordDO> recordDOByRoomNumber = recordDAO.getRecordDOByCustomerId(10013);
        System.out.println(recordDOByRoomNumber);
        Assert.assertNotNull(recordDOByRoomNumber);
    }

    @Test
    public void dGetByStaff() {
        List<RecordDO> recordDOByCustomerId = recordDAO.getRecordDOByCustomerId(CUSTOMER_ID);
        System.out.println(recordDOByCustomerId);
        Assert.assertNotNull(recordDOByCustomerId);
    }

    @Test
    public void dGetByCustomer() {
        List<RecordDO> recordDOByStaffId = recordDAO.getRecordDOByStaffId(STAFF_ID);
        System.out.println(recordDOByStaffId);
        Assert.assertNotNull(recordDOByStaffId);
    }

    @Test
    public void zDelete() {
        int i = recordDAO.deleteById(ID);
        Assert.assertEquals(1, i);
    }
}
