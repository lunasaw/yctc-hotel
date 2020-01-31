package com.altersoftware.hotel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.dao.FloorDAO;
import com.altersoftware.hotel.entity.FloorDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.FloorService;

/**
 * FloorService接口实现
 * 
 * @author czy@win10
 * @date 2020/1/28 21:20
 */
@ComponentScan({"com.altersoftware.hotel.dao"})
@Service("floorService")
public class FloorServiceImpl implements FloorService {
    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Resource
    private FloorDAO            floorDAO;

    @Override
    public ResultDO<Void> insert(FloorDO floorDO) {
        try {
            floorDAO.insert(floorDO);
            LOG.info("insert success, floorDO={}", floorDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("insert error, floorDO={}", floorDO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<String> show2D(long id) {
        FloorDO floorDOById = null;
        try {
            floorDOById = floorDAO.getFloorDOById(id);
            LOG.info("getfloorDOById success, floorDO={}", floorDOById);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, floorDOById.getPlan());
        } catch (Exception e) {
            LOG.error("getfloorDOById error, floorDO={}", floorDOById, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<String> showFire(long id) {
        FloorDO floorDOById = null;
        try {
            floorDOById = floorDAO.getFloorDOById(id);
            LOG.info("getfloorDOById success, floorDO={}", floorDOById);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, floorDOById.getFireDiagram());
        } catch (Exception e) {
            LOG.error("getfloorDOById error, floorDO={}", floorDOById, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<String> show3D(long id) {
        FloorDO floorDOById = null;
        try {
            floorDOById = floorDAO.getFloorDOById(id);
            LOG.info("getfloorDOById success, floorDO={}", floorDOById);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, floorDOById.getThreeDDiagram());
        } catch (Exception e) {
            LOG.error("getfloorDOById error, mail={}", floorDOById, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<List<Long>> showFloorId() {
        List<Long> floorIdList = null;
        try {
            floorIdList = floorDAO.getFloorIdList();
            LOG.info("get floorIdList success, floorIdList={}", floorIdList);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, floorIdList);
        } catch (Exception e) {
            LOG.error("getfloorDOById error, floorIdList={}", floorIdList, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<Void> delete(long id) {
        try {
            int i = floorDAO.deleteById(id);
            LOG.info("delete floorDO success, id={}", id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("delete floorDO success, id={}", id, e);
            return new ResultDO<>(false, ResultCode.DELETE_FAILD,
                ResultCode.MSG_DELETE_FAILD);
        }
    }
}
