package com.altersoftware.hotel.controller.rest.impl;

import java.util.List;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.entity.RoomDO;
import com.altersoftware.hotel.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.controller.rest.RoomTypeRestController;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.RoomTypeDO;

/**
 * @author hzx
 * @date
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/roomTypeInfo")
public class RoomTypeRestControllerImpl implements RoomTypeRestController {

    @Autowired
    RoomTypeService roomTypeService;

    /**
     * 插入一个类别信息
     *
     * @param roomTypeDO
     * @return
     */
    @Override
    @PostMapping("add-roomtype")
    public ResultDO<Void> insert(@RequestBody RoomTypeDO roomTypeDO) {
        //参数校验
        if (roomTypeDO.getId() <= 0 || roomTypeDO.getUserNumber() <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<Void> voidResultDO = roomTypeService.insert(roomTypeDO);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    /**
     * 查询所有房间类别信息
     *
     * @return
     */
    @Override
    @PostMapping("get-list")
    public ResultDO<List<RoomTypeDO>> getRoomTypes() {

        ResultDO<List<RoomTypeDO>> roomTypes = roomTypeService.getRoomTypes();
        if (roomTypes.isSuccess() == false) {
            return new ResultDO<List<RoomTypeDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            List<RoomTypeDO> roomTypesModule = roomTypes.getModule();
            return new ResultDO<List<RoomTypeDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, roomTypesModule);
        }
    }

    /**
     * 更新房间类别状态
     *
     * @param roomTypeDO
     * @return
     */
    @Override
    @PostMapping("update-roomtype")
    public ResultDO<Void> updateRoom(@RequestBody RoomTypeDO roomTypeDO) {
        //参数校验
        if (roomTypeDO.getId() <= 0 || roomTypeDO.getUserNumber() <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<RoomTypeDO> roomTypeDOById = roomTypeService.getRoomTypeDOById(roomTypeDO.getId());
        if (roomTypeDOById.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            RoomTypeDO doByIdModule = roomTypeDOById.getModule();
            doByIdModule.setAddBed(roomTypeDO.getAddBed());
            doByIdModule.setDescribe(roomTypeDO.getDescribe());
            doByIdModule.setId(roomTypeDO.getId());
            doByIdModule.setName(roomTypeDO.getName());
            doByIdModule.setRoomType(roomTypeDO.getRoomType());
            doByIdModule.setUserNumber(roomTypeDO.getUserNumber());
            doByIdModule.setWide(roomTypeDO.getWide());
            ResultDO<Void> voidResultDO = roomTypeService.updateRoom(doByIdModule);
            if (voidResultDO.isSuccess() == false) {
                return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                        ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            } else {
                return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
            }
        }
    }

    /**
     * 删除指定房间类别数据
     *
     * @param id
     * @return
     */
    @Override
    @PostMapping("delete-roomtype")
    public ResultDO<Void> deleteRoomTypeDO(long id) {
        //参数校验
        if (id <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<Void> voidResultDO = roomTypeService.deleteRoomTypeDO(id);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    /**
     * 房间类别id查询房间类别信息
     *
     * @param id
     * @return
     */
    @Override
    @PostMapping("get-byid")
    public ResultDO<RoomTypeDO> getRoomTypeDOById(long id) {
        //参数校验
        if (id <= 0) {
            return new ResultDO<RoomTypeDO>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<RoomTypeDO> roomTypeDOById = roomTypeService.getRoomTypeDOById(id);
        if (roomTypeDOById.isSuccess() == false) {
            return new ResultDO<RoomTypeDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            RoomTypeDO doByIdModule = roomTypeDOById.getModule();
            return new ResultDO<RoomTypeDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, doByIdModule);
        }
    }
}
