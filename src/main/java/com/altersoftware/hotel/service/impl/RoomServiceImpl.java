package com.altersoftware.hotel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.constant.entity.room.RoomState;
import com.altersoftware.hotel.dao.RoomDAO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.RoomDO;
import com.altersoftware.hotel.service.RoomService;

/**
 * @author czy@win10
 * @date 2020/1/29 20:55
 */
@ComponentScan({"com.altersoftware.hotel.dao"})
@Service("roomService")
public class RoomServiceImpl implements RoomService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Resource
    private RoomDAO             roomDAO;

    @Override
    public ResultDO<Void> insert(RoomDO roomDO) {
        try {
            roomDAO.insert(roomDO);
            LOG.info("insert success, roomDO={}", roomDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("insert error, roomDO={}", roomDO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<List<RoomDO>> getRooms() {
        List<RoomDO> allRoomDo = null;
        try {
            allRoomDo = roomDAO.getAllRoomDo();
            LOG.info("getallRoomDo success, allRoomDo={}", allRoomDo);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, allRoomDo);
        } catch (Exception e) {
            LOG.error("getallRoomDo error, allRoomDo={}", allRoomDo, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<Void> updateRoom(RoomDO roomDO) {
        try {
            int update = roomDAO.update(roomDO);
            LOG.info("updateRoomDo success, update={}", update);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("getallRoomDo error", e);
            return new ResultDO<>(false, ResultCode.UPDATE_FAILD,
                ResultCode.MSG_UPDATE_FAILD);
        }
    }

    @Override
    public ResultDO<RoomDO> getRoomDO(long id) {
        try {
            RoomDO roomDOById = roomDAO.getRoomDOById(id);
            LOG.info("getroomDOById success, roomDOById={}", roomDOById);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, roomDOById);
        } catch (Exception e) {
            LOG.error("getallRoomDo error", e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<RoomDO> getRoomDOByNumber(int roomNumber) {
        try {
            RoomDO roomDOByNumber = roomDAO.getRoomDOByNumber(roomNumber);
            LOG.info("getroomDOByNumber success, roomDOByNumber={}", roomDOByNumber);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, roomDOByNumber);
        } catch (Exception e) {
            LOG.error("getallRoomDo error", e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<Void> deleteById(long id) {
        try {
            int i = roomDAO.deleteById(id);
            LOG.info("deleteById success, id={}", id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("getallRoomDo error", e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<Void> deleteList(List<Long> ids) {
        try {
            for (int i = 0; i < ids.size(); i++) {
                roomDAO.deleteById(ids.get(i));
            }
            LOG.info("deleteById success, id={}", ids);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("getallRoomDo error", e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<RoomDO> getRoomDOByRoomType(String roomTypeName) {
        try {

            List<RoomDO> roomDOByRoomType = roomDAO.getRoomDOByRoomType(roomTypeName);
            for (int i = 0; i < roomDOByRoomType.size(); i++) {
                if (roomDOByRoomType.get(i).getState() == RoomState.UNCHECKED) {
                    LOG.info("getRoomDOByRoomType success, roomTypeName={}", roomDOByRoomType.get(i));
                    return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, roomDOByRoomType.get(i));
                }
            }
            LOG.info("getRoomDOByRoomType warning, roomTypeName={}", roomDOByRoomType);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } catch (Exception e) {
            LOG.error("getallRoomDo error", e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }
}
