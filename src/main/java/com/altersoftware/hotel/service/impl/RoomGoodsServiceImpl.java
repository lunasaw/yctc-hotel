package com.altersoftware.hotel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.dao.RoomGoodsDAO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.RoomGoodsDO;
import com.altersoftware.hotel.service.RoomGoodsService;

/**
 * @author Iszychen@win10
 * @date 2020/2/19 15:46
 */
@ComponentScan({"com.altersoftware.hotel.dao"})
@Service("roomGoodsService")
public class RoomGoodsServiceImpl implements RoomGoodsService {
    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Resource
    private RoomGoodsDAO        roomGoodsDAO;

    @Override
    public ResultDO<Void> insert(RoomGoodsDO roomGoodsDO) {
        try {
            roomGoodsDAO.insert(roomGoodsDO);
            LOG.info("insertRoomGoodsDO success, roomGoodsDO={}", roomGoodsDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("insertRoomGoodsDO error, roomGoodsDO={}", roomGoodsDO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<RoomGoodsDO> showGoodsByRoomNumberAndGoodsName(int roomNumber, String goodsName) {
        RoomGoodsDO roomGoodsDOResultDO = null;
        if (roomNumber < 0 | goodsName.equals("")) {
            LOG.error("showGoodsByRoomNumberAndGoodsName error, roomNumber={},goodsName={}", roomNumber, goodsName);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
        try {
            RoomGoodsDO roomGoodsDOByRoomNumberAndGoodsName =
                roomGoodsDAO.getRoomGoodsDOByRoomNumberAndGoodsName(roomNumber, goodsName);
            if (roomGoodsDOByRoomNumberAndGoodsName == null) {
                LOG.info("showGoodsByRoomNumberAndGoodsName error, roomGoodsDOByRoomNumberAndGoodsName={}",
                    roomGoodsDOByRoomNumberAndGoodsName);
                return new ResultDO<>(true, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
            }
            LOG.info("showGoodsByRoomNumberAndGoodsName success, roomGoodsDOByRoomNumberAndGoodsName={}",
                roomGoodsDOResultDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
                roomGoodsDOByRoomNumberAndGoodsName);
        } catch (Exception e) {
            LOG.error("showGoodsByRoomNumberAndGoodsName error, roomNumber={},goodsName={}", roomNumber, goodsName, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<Void> updateGoods(RoomGoodsDO roomGoodsDO) {
        int update = roomGoodsDAO.update(roomGoodsDO);
        if (update == 1) {
            LOG.info("updateGoods success, roomGoodsDO={}", roomGoodsDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } else {
            LOG.error("updateGoods error, roomGoodsDO={}", roomGoodsDO);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<List<RoomGoodsDO>> showRoomGoodsByRoomNumber(int roomNumber) {
        List<RoomGoodsDO> goodsStateListByRoom = null;
        try {
            goodsStateListByRoom = roomGoodsDAO.getGoodsStateListByRoom(roomNumber);
            LOG.info("showRoomGoodsByRoomNumber success, goodsStateListByRoom={}", goodsStateListByRoom);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, goodsStateListByRoom);
        } catch (Exception e) {
            LOG.error("showRoomGoodsByRoomNumber error, roomNumber={}", roomNumber, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<Void> deleteByRoomNumberAndGoodsName(int roomNumber, String goodsName) {
        try {
            roomGoodsDAO.deleteByRoomNumberAndGoodsName(roomNumber, goodsName);
            LOG.info("deleteByRoomNumberAndGoodsName success, roomNumber={},goodsName={}", roomNumber, goodsName);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("deleteByRoomNumberAndGoodsName error, roomNumber={},goodsName={}", roomNumber, goodsName, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<Void> deleteList(int roomNumber) {
        try {
            roomGoodsDAO.deleteByRooomNumber(roomNumber);
            LOG.info("deleteList success, roomNumber={}", roomNumber);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("deleteList error, roomNumber={}", roomNumber, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<List<RoomGoodsDO>> showRoomGoodsByGoodsName(String goodsName) {
        List<RoomGoodsDO> oneGoodsStateListByName = null;
        try {
            oneGoodsStateListByName = roomGoodsDAO.getOneGoodsStateListByName(goodsName);
            LOG.info("showRoomGoodsByGoodsName success, oneGoodsStateListByName={}", oneGoodsStateListByName);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, oneGoodsStateListByName);
        } catch (Exception e) {
            LOG.error("showRoomGoodsByGoodsName error, goodsName={}", goodsName, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }
}
