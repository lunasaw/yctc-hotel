package com.altersoftware.hotel.controller.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.controller.rest.RoomRestController;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.RoomDO;
import com.altersoftware.hotel.service.RoomService;
import com.altersoftware.hotel.vo.RoomVO;

/**
 * @author hzx
 * @date
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/room")
public class RoomRestControllerImpl implements RoomRestController {

    @Autowired
    RoomService roomService;

    /**
     * 显示所有房间信息
     * 
     * @return
     */
    @Override
    @PostMapping("show-listRoom")
    public ResultDO<List<RoomDO>> showRoomList() {
        ResultDO<List<RoomDO>> resultDO = roomService.getRooms();
        if (resultDO.isSuccess() == false) {
            return new ResultDO<List<RoomDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            List<RoomDO> rooms = resultDO.getModule();
            return new ResultDO<List<RoomDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, rooms);
        }
    }

    /**
     * 更新房间信息
     * 
     * @return
     */
    @Override
    @PostMapping("update-room")
    public ResultDO<Void> updateRoom(@RequestBody RoomVO roomVO) {
        // 参数校验
        if (roomVO.getRoomNumber() <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<RoomDO> roomDOByNumber = roomService.getRoomDOByNumber(roomVO.getRoomNumber());

        if (roomDOByNumber.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            RoomDO roomDO = roomDOByNumber.getModule();
            roomDO.setRoomNumber(roomVO.getRoomNumber());
            roomDO.setState(roomVO.getState());
            roomDO.setType(roomVO.getType());
            roomDO.setPrice(roomVO.getPrice());
            roomDO.setDeposit(roomVO.getDeposit());
            roomDO.setType(roomVO.getType());
            ResultDO<Void> voidResultDO = roomService.updateRoom(roomDO);
            if ( voidResultDO.isSuccess() == false ){
                return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                        ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            }
            else {
                return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
            }

        }
    }

    /**
     *
     * 按照房间号查找房间信息
     * 
     * @return
     */
    @Override
    @GetMapping("get-byNumber")
    public ResultDO<RoomDO> getRoomByNumber(@RequestParam(name = "roomNumber") int roomNumber) {
        // 参数校验
        if (roomNumber <= 0) {
            return new ResultDO<RoomDO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<RoomDO> roomDOByNumber = roomService.getRoomDOByNumber(roomNumber);
        if (roomDOByNumber.isSuccess() == false) {
            return new ResultDO<RoomDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<RoomDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, roomDOByNumber.getModule());
        }

    }
}
