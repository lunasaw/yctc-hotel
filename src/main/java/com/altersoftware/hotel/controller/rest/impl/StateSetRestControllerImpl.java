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
public class StateSetRestControllerImpl implements StateSetController {

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
            // 去数据库查出相关状态
            ResultDO<RoomGoodsDO> roomGoodsDOResultDO = roomGoodsService
                .showGoodsByRoomNumberAndGoodsName(roomGoodsDO.getRoomNumber(), roomGoodsDO.getGoodsName());
            // 如果为false 则跳出
            if (roomGoodsDOResultDO.isSuccess() == false) {
                return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            }
            // 为True 则更新状态
            RoomGoodsDO goodsDOResultDOModule = roomGoodsDOResultDO.getModule();
            String state = roomGoodsDO.getState();
            if (state.equals("1")) {
                roomGoodsDO.setState("开启");
            } else if (state.equals("0")) {
                roomGoodsDO.setState("关闭");
            } else {
                roomGoodsDO.setState(state);
            }
            // 如果数据库没有数据,则插入
            if (goodsDOResultDOModule == null) {
                ResultDO<Void> insert = roomGoodsService.insert(roomGoodsDO);
                if (insert.isSuccess()) {
                    return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
                } else {
                    return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                        ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
                }
            } else {
                ResultDO<Void> voidResultDO = roomGoodsService.updateGoods(roomGoodsDO);
                if (voidResultDO.isSuccess() == false) {
                    return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                        ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
                }
            }
        }
        return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
    }

    /**
     * 更新物品状态
     */
    @Override
    @PostMapping("update-onestate")
    public ResultDO<Void> updateOneGoodsDO(@RequestBody RoomGoodsDO roomGoodsDO) {
        // 参数校验
        if (StringUtils.isBlank(roomGoodsDO.getState()) || roomGoodsDO.getRoomNumber() <= 0 || StringUtils.isBlank(roomGoodsDO.getGoodsName())) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<RoomGoodsDO> roomGoodsDOResultDO = roomGoodsService.showGoodsByRoomNumberAndGoodsName(roomGoodsDO.getRoomNumber(), roomGoodsDO.getGoodsName());
        if (roomGoodsDOResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            RoomGoodsDO doResultDOModule = roomGoodsDOResultDO.getModule();
            doResultDOModule.setState(roomGoodsDO.getState());
            doResultDOModule.setRoomNumber(roomGoodsDO.getRoomNumber());
            doResultDOModule.setGoodsName(roomGoodsDO.getGoodsName());

            ResultDO<Void> voidResultDO = roomGoodsService.updateGoods(doResultDOModule);
            if (voidResultDO.isSuccess() == false) {
                return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                        ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            } else {
                return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
            }
        }
    }





    /**
     * 增加物品状态
     * @param roomGoodsDO
     * @return
     */
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

    /**
     * 通过房间号和物品名
     * @param roomNumber
     * @param goodsName
     * @return
     */
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

    /**
     * 通过房间号返回物品状态
     * @param roomNumber
     * @return
     */
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

    /**
     * 通过物品名返回物品状态
     * @param goodsName
     * @return
     */
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

    /**
     * 获取所有物品及状态
     * @return
     */
    @Override
    @PostMapping("get-list")
    public ResultDO<List<RoomGoodsDO>> showGoodsStateList() {
        ResultDO<List<RoomGoodsDO>> listResultDO = roomGoodsService.showRoomGoodsList();
        if (listResultDO.isSuccess() == false) {
            return new ResultDO<List<RoomGoodsDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {

            return new ResultDO<List<RoomGoodsDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
                    listResultDO.getModule());
        }
    }

    /**
     * 删除物品状态
     * @param roomNumber
     * @param goodsName
     * @return
     */
    @Override
    @PostMapping("delet-goods")
    public ResultDO<Void> deleteByRoomNumberAndGoodsName( int roomNumber, String goodsName) {
        //参数校验
        if (roomNumber <= 0 || StringUtils.isBlank(goodsName)){
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<Void> voidResultDO = roomGoodsService.deleteByRoomNumberAndGoodsName(roomNumber, goodsName);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }
}
