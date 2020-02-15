package com.altersoftware.hotel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.dao.RoomTypeDAO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.RoomTypeDO;
import com.altersoftware.hotel.service.RoomTypeService;

/**
 * @author czy@win10
 * @date 2020/2/2 15:51
 */
@ComponentScan({"com.altersoftware.hotel.dao"})
@Service("roomTyoeService")
public class RoomTypeServiceImpl implements RoomTypeService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Resource
    private RoomTypeDAO         roomTypeDAO;

    @Override
    public ResultDO<Void> insert(RoomTypeDO roomTypeDO) {
        try {
            roomTypeDAO.insert(roomTypeDO);
            LOG.info("insert success, roomTypeDO={}", roomTypeDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("insert error, roomTypeDO={}", roomTypeDO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<List<RoomTypeDO>> getRoomTypes() {
        try {
            List<RoomTypeDO> roomTypeDOList = roomTypeDAO.getRoomTypeDOList();
            LOG.info("getRoomTypes success, allRoomDo={}", roomTypeDOList);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, roomTypeDOList);
        } catch (Exception e) {
            LOG.error("getRoomTypes error, roomTypeDOList={}", e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<Void> updateRoom(RoomTypeDO roomTypeDO) {
        int update = roomTypeDAO.update(roomTypeDO);
        if (update == 1) {
            LOG.info("updateRoom success, update={}", update);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } else {
            LOG.error("updateRoom error");
            return new ResultDO<>(false, ResultCode.UPDATE_FAILD,
                ResultCode.MSG_UPDATE_FAILD);
        }
    }

    @Override
    public ResultDO<Void> updatFile(long id, String fileName) {
        int update = roomTypeDAO.updateFile(fileName, id);
        if (update == 1) {
            LOG.info("updateRoom success, update={}", update);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } else {
            LOG.error("updateRoom error");
            return new ResultDO<>(false, ResultCode.UPDATE_FAILD,
                ResultCode.MSG_UPDATE_FAILD);
        }
    }

    @Override
    public ResultDO<RoomTypeDO> getRoomTypeDOById(long id) {
        try {
            RoomTypeDO roomTypeDOById = roomTypeDAO.getRoomTypeDOById(id);
            LOG.info("getRoomTypeDO success, roomTypeDOById={}", roomTypeDOById);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, roomTypeDOById);
        } catch (Exception e) {
            LOG.error("getallRoomDo error", e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<Void> deleteRoomTypeDO(long id) {
        try {
            int i = roomTypeDAO.deleteById(id);
            LOG.info("deleteRoomTypeDO success, id={}", id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("deleteRoomTypeDO error", e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<Void> deleteList(List<Long> ids) {
        try {
            for (int i = 0; i < ids.size(); i++) {
                roomTypeDAO.deleteById(ids.get(i));
            }
            LOG.info("deleteList success, ids={}", ids);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("deleteList error", e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }
}
