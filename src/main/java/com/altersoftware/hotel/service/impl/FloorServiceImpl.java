package com.altersoftware.hotel.service.impl;

import java.util.List;

import javax.annotation.Resource;

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

    @Resource
    private FloorDAO floorDAO;

    @Override
    public ResultDO<String> show2D(long id) {
        FloorDO floorDOById = floorDAO.getFloorDOById(id);
        return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, floorDOById.getPlan());
    }

    @Override
    public ResultDO<String> showFire(long id) {
        FloorDO floorDOById = floorDAO.getFloorDOById(id);
        return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, floorDOById.getFireDiagram());
    }

    @Override
    public ResultDO<String> show3D(long id) {
        FloorDO floorDOById = floorDAO.getFloorDOById(id);
        return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, floorDOById.getThreeDDiagram());
    }

    @Override
    public ResultDO<List<Long>> showFloorId() {
        List<Long> floorIdList = floorDAO.getFloorIdList();
        return new ResultDO<List<Long>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, floorIdList);
    }
}
