package com.altersoftware.hotel.controller.rest.impl;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.controller.rest.PlaceAnOrderRestController;
import com.altersoftware.hotel.entity.RecordDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.RoomDO;
import com.altersoftware.hotel.service.RecordService;
import com.altersoftware.hotel.service.RoomService;
import com.altersoftware.hotel.vo.RecordVO;

import java.util.List;

/**
 * @author hzx
 * @date 2020/2/7 22:18
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/placeorder")
public class PlaceAnOrderRestControllerImpl implements PlaceAnOrderRestController {

    @Resource
    private RecordService recordService;

    @Resource
    private RoomService roomService;

    @Override
    @PostMapping("accept-order")
    public ResultDO<RecordDO> acceptOrder(@RequestBody RecordVO recordVO) {
        //参数校验
        if (recordVO.getCustomerId() <= 0 || StringUtils.isBlank(recordVO.getPrecheckInTime()) || StringUtils.isBlank(recordVO.getRoomTypeName())
                || StringUtils.isBlank(recordVO.getCheckOutTime()) || recordVO.getStaffId() <= 0) {
            return new ResultDO<RecordDO>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        //  1.从前端接受类型名称
        // 2.在roomService中返回一个房间
        ResultDO<RoomDO> roomDOByRoomType1 = roomService.getRoomDOByRoomType(recordVO.getRoomTypeName());
        if (roomDOByRoomType1.isSuccess() == false) {
            return new ResultDO<RecordDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            ResultDO<Double> actualMoney = recordService.getActualMoney(recordVO.getCustomerId(), roomDOByRoomType1.getModule().getRoomNumber());
            if (actualMoney.isSuccess() == false) {
                return new ResultDO<RecordDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                        ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            }
            // 3.将RecordDO构造插入订单
            RecordDO recordDO = new RecordDO();
            recordDO.setStaffId(recordVO.getStaffId());
            recordDO.setRoomNumber(roomDOByRoomType1.getModule().getRoomNumber());
            recordDO.setCustomerId(recordVO.getCustomerId());
            recordDO.setPrecheckInTime(recordVO.getPrecheckInTime());
            recordDO.setCheckInTime(recordVO.getCheckInTime());
            recordDO.setCheckOutTime(recordVO.getCheckOutTime());
            recordDO.setPayMoney(actualMoney.getModule());

            ResultDO<Void> recordServiceRecord = recordService.createRecord(recordDO);
            if (recordServiceRecord.isSuccess() == false) {
                return new ResultDO<RecordDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                        ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            } else {
                return new ResultDO<RecordDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, recordDO);
            }

        }

    }
}
