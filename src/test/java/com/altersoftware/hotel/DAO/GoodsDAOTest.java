package com.altersoftware.hotel.DAO;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altersoftware.hotel.constant.entity.goods.GoodsState;
import com.altersoftware.hotel.dao.GoodsDAO;
import com.altersoftware.hotel.entity.GoodsDO;

/**
 * @author czy@win10
 * @date 2020/1/27 23:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoodsDAOTest {

    private static final int    ID                 = 2;
    private static final int    ROOM_ID            = 1;
    private static final String NAME               = "Type-C充电器";
    private static final Double PRICE              = 33.0;
    private static final Double COMPENSATION_MONEY = 33.0;
    private static final String BUY_TIME           = "2020-1-1";
    private static final int    STATE              = GoodsState.UNLEND;
    private static final int    NEW_STATE          = GoodsState.LENDED;

    @Resource
    private GoodsDAO            goodsDAO;

    @Test
    public void aInsert() {
        GoodsDO goodDO = new GoodsDO();
        goodDO.setId(ID);
        goodDO.setroomId(ROOM_ID);
        goodDO.setName(NAME);
        goodDO.setbuyTime(BUY_TIME);
        goodDO.setPrice(PRICE);
        goodDO.setCompensationMoeny(COMPENSATION_MONEY);
        goodDO.setState(STATE);
        goodsDAO.insert(goodDO);
    }

    @Test
    public void bGetById() {
        GoodsDO goodDOById = goodsDAO.getGoodsDOById(ID);
        System.out.println(goodDOById);
        Assert.assertNotNull(goodDOById);
    }

    @Test
    public void cUpdate() {
        GoodsDO goodDOById = goodsDAO.getGoodsDOById(ID);
        boolean legal = GoodsState.isLegal(NEW_STATE);
        if (legal) {
            goodDOById.setState(GoodsState.LENDED);
        }
        int update = goodsDAO.update(goodDOById);
        System.out.println(update);
        Assert.assertEquals(1, update);
    }

    @Test
    public void dDeleteById() {
        int i = goodsDAO.deleteById(ID);
        Assert.assertEquals(1, i);
        GoodsDO goodDOById = goodsDAO.getGoodsDOById(ID);
        System.out.println(goodDOById);
        Assert.assertNull(goodDOById);
    }

    @Test
    public void testDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }

}
