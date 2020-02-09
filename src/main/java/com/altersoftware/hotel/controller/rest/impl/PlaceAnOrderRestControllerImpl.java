package com.altersoftware.hotel.controller.rest.impl;

import javax.annotation.Resource;

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
    private RoomService   roomService;

    @Override
    @PostMapping("accept-order")
    public ResultDO<RecordVO> acceptOrder(@RequestBody RecordVO recordVO) {

        //  1.从前端接受类型名称
        // 2.在roomService中返回一个房间
        ResultDO<RoomDO> roomDOByRoomType1 = roomService.getRoomDOByRoomType(recordVO.getRoomTypeName());
        if (roomDOByRoomType1.isSuccess() == false) {
            return new ResultDO<RecordVO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        }
        else {
            // 3.将RecordDO构造插入订单
            RecordDO recordDO = new RecordDO();
            recordDO.setStaffId(recordVO.getStaffId());
            recordDO.setRoomNumber(recordVO.getRoomNumber());
            recordDO.setCustomerId(recordVO.getCustomerId());
            recordDO.setPrecheckInTime(recordVO.getPrecheckInTime());
            ResultDO<Void> recordServiceRecord = recordService.createRecord(recordDO);

        }

        return null;
    }
}
