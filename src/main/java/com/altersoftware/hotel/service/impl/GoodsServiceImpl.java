package com.altersoftware.hotel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.dao.GoodsDAO;
import com.altersoftware.hotel.entity.GoodsDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.GoodsService;

/**
 * @author czy@win10
 * @date 2020/1/31 21:39
 */
@ComponentScan({"com.altersoftware.hotel.dao"})
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Resource
    private GoodsDAO            goodsDAO;

    @Override
    public ResultDO<Void> insert(GoodsDO goodsDO) {
        try {
            goodsDAO.insert(goodsDO);
            LOG.info("insert success, goodsDO={}", goodsDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("insert error, goodsDO={}", goodsDO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<GoodsDO> showGoods(long id) {
        try {
            GoodsDO goodsDOById = goodsDAO.getGoodsDOById(id);
            LOG.info("getGoodsDOById success, goodsDOById={}", goodsDOById);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, goodsDOById);
        } catch (Exception e) {
            LOG.error("getGoodsDOById error, id={}", id, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<Void> updateGoods(GoodsDO goodsDO) {
        int update = goodsDAO.update(goodsDO);
        if (update == 1) {
            LOG.info("updateGoods success, goodsDO={}", goodsDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } else {
            LOG.error("getGoodsDOById error, goodsDO={}", goodsDO);
            return new ResultDO<>(false, ResultCode.UPDATE_FAILD,
                ResultCode.MSG_UPDATE_FAILD);
        }
    }

    @Override
    public ResultDO<List<GoodsDO>> showGoodsByRoom(long roomId) {
        try {
            List<GoodsDO> goodsDOByRoomId = goodsDAO.getGoodsDOByRoomId(roomId);
            LOG.info("getGoodsDOByRoomId success, goodsDO={}", goodsDOByRoomId);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, goodsDOByRoomId);
        } catch (Exception e) {
            LOG.error("getGoodsDOByRoomId error, roomId={}", roomId, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }


    @Override
    public ResultDO<Void> deleteById(long id) {
        try {
            goodsDAO.deleteById(id);
            LOG.info("deleteById success, goodsDO={}", id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("deleteById error, goodsId={}", id, e);
            return new ResultDO<>(false, ResultCode.DELETE_FAILD,
                ResultCode.MSG_DELETE_FAILD);
        }
    }

    @Override
    public ResultDO<Void> deleteList(List<Long> ids) {
        try {
            for (int i = 0; i < ids.size(); i++) {
                goodsDAO.deleteById(ids.get(i));
            }
            LOG.info("deleteList success, goodsDO={}", ids);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("deleteList error, goodsId={}", ids, e);
            return new ResultDO<>(false, ResultCode.DELETE_FAILD,
                ResultCode.MSG_DELETE_FAILD);
        }
    }

    @Override
    public ResultDO<List<GoodsDO>> getAll() {
        try {
            List<GoodsDO> all = goodsDAO.getAll();
            LOG.info("getAll success, goodsDO list={}", all);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("getAll error", e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }
}
