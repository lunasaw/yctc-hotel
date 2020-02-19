package com.altersoftware.hotel.controller.rest.impl;

import java.util.List;

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
import com.altersoftware.hotel.service.GoodsService;

/**
 * @author hzx
 * @date 2020/2/6 17:28
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/state")
public class StateSetControllerImpl implements StateSetController {

    @Autowired
    GoodsService goodsService;

    /**
     * 接收物品状态值
     *
     */
    @Override
    @PostMapping("update-state")
    public ResultDO<Void> updateGoodsDO(@RequestBody List<RoomGoodsDO> roomGoodsDOS) {
        //参数校验
        if (roomGoodsDOS.size() <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }

        for (int i = 0; i < roomGoodsDOS.size(); i++) {

        }
        return null;
    }

    @Override
    public ResultDO<Void> insert(RoomGoodsDO roomGoodsDO) {
        return null;
    }

    @Override
    public ResultDO<RoomGoodsDO> showGoodsByRoomNumberAndGoodsName(int roomNumber, String goodsName) {
        return null;
    }

    @Override
    public ResultDO<List<RoomGoodsDO>> showRoomGoodsByRoomNumber(int roomNumber) {
        return null;
    }

    @Override
    public ResultDO<List<RoomGoodsDO>> showRoomGoodsByGoodsName(String goodsName) {
        return null;
    }
}
