package com.altersoftware.hotel.controller.rest.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.controller.rest.StateSetController;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.RoomGoodsDO;
import com.altersoftware.hotel.service.RoomGoodsService;

/**
 * @author hzx
 * @date 2020/2/6 17:28
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/state")
public class StateSetControllerImpl implements StateSetController {

    @Autowired
    RoomGoodsService roomGoodsService;

    /**
     * 接收物品状态值
     *
     */
    @Override
    @PostMapping("update-state")
    public ResultDO<Void> updateGoodsDO(@RequestBody List<RoomGoodsDO> roomGoodsDOS) {
        System.out.println(roomGoodsDOS);
        // 参数校验
        if (roomGoodsDOS.size() <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        for (int i = 0; i < roomGoodsDOS.size(); i++) {
            RoomGoodsDO roomGoodsDO = roomGoodsDOS.get(i);
            ResultDO<RoomGoodsDO> roomGoodsDOResultDO = roomGoodsService
                .showGoodsByRoomNumberAndGoodsName(roomGoodsDO.getRoomNumber(), roomGoodsDO.getGoodsName());
            if (roomGoodsDOResultDO.isSuccess() == false) {
                return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            }
            if (roomGoodsDOResultDO.getModule() == null) {
                ResultDO<Void> insert = roomGoodsService.insert(roomGoodsDO);
                if (insert.isSuccess()) {
                    return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
                } else {
                    return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                        ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
                }
            } else {
                RoomGoodsDO goodsDOResultDOModule = roomGoodsDOResultDO.getModule();
                String state = roomGoodsDO.getState();
                if (state.equals("1")) {
                    goodsDOResultDOModule.setState("开启");
                } else if (state.equals("0")) {
                    goodsDOResultDOModule.setState("关闭");
                } else {
                    goodsDOResultDOModule.setState(state);
                }
                ResultDO<Void> voidResultDO = roomGoodsService.updateGoods(goodsDOResultDOModule);
                if (voidResultDO.isSuccess() == false) {
                    return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                        ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
                }
            }
        }
        return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
    }

    @Override
    @PostMapping("add-state")
    public ResultDO<Void> insert(@RequestBody RoomGoodsDO roomGoodsDO) {
        // 参数校验
        if (StringUtils.isBlank(roomGoodsDO.getGoodsName()) || roomGoodsDO.getRoomNumber() <= 0
            || StringUtils.isBlank(roomGoodsDO.getState())) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<Void> voidResultDO = roomGoodsService.insert(roomGoodsDO);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    @Override
    @PostMapping("show-goods")
    public ResultDO<RoomGoodsDO> showGoodsByRoomNumberAndGoodsName(int roomNumber, String goodsName) {
        // 参数校验
        if (roomNumber <= 0 || StringUtils.isBlank(goodsName)) {
            return new ResultDO<RoomGoodsDO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<RoomGoodsDO> roomGoodsDOResultDO =
            roomGoodsService.showGoodsByRoomNumberAndGoodsName(roomNumber, goodsName);
        if (roomGoodsDOResultDO.isSuccess() == false) {
            return new ResultDO<RoomGoodsDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<RoomGoodsDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
                roomGoodsDOResultDO.getModule());
        }
    }

    @Override
    @PostMapping("show-goodsbyroomNumber")
    public ResultDO<List<RoomGoodsDO>> showRoomGoodsByRoomNumber(int roomNumber) {
        // 参数校验
        if (roomNumber <= 0) {
            return new ResultDO<List<RoomGoodsDO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<List<RoomGoodsDO>> listResultDO = roomGoodsService.showRoomGoodsByRoomNumber(roomNumber);
        if (listResultDO.isSuccess() == false) {
            return new ResultDO<List<RoomGoodsDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {

            return new ResultDO<List<RoomGoodsDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
                listResultDO.getModule());
        }
    }

    @Override
    @PostMapping("show-goodsbygoodsName")
    public ResultDO<List<RoomGoodsDO>> showRoomGoodsByGoodsName(String goodsName) {
        // 参数校验
        if (StringUtils.isBlank(goodsName)) {
            return new ResultDO<List<RoomGoodsDO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<List<RoomGoodsDO>> listResultDO = roomGoodsService.showRoomGoodsByGoodsName(goodsName);
        if (listResultDO.isSuccess() == false) {
            return new ResultDO<List<RoomGoodsDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {

            return new ResultDO<List<RoomGoodsDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
                listResultDO.getModule());
        }
    }

    @Override
    public ResultDO<List<RoomGoodsDO>> showGoodsStateList() {
        return null;
    }
}
