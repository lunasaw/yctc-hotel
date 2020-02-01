package com.altersoftware.hotel.controller.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.controller.rest.GoodsRestController;
import com.altersoftware.hotel.entity.GoodsDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.GoodsService;

/**
 * @author hzx
 * @date 2020/1/31 21:53
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/goods")
public class GoodsRestControllerImpl implements GoodsRestController {

    @Autowired
    GoodsService goodsService;

    /**
     * 插入一条物品信息
     *
     * @param goodsDO
     * @return
     */
    @Override
    @PostMapping("add-goods")
    public ResultDO<GoodsDO> insert(@RequestBody GoodsDO goodsDO) {
        // 参数校验
        if (goodsDO.getId() <= 0 || goodsDO.getroomId() <= 0) {
            return new ResultDO<GoodsDO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<Void> voidResultDO = goodsService.insert(goodsDO);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<GoodsDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<GoodsDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    /**
     * 展示物品信息
     *
     * @param id
     */
    @Override
    @PostMapping("show-goods")
    public ResultDO<GoodsDO> showGoods(long id) {
        // 参数校验
        if (id <= 0) {
            return new ResultDO<GoodsDO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<GoodsDO> goodsDOResultDO = goodsService.showGoods(id);
        if (goodsDOResultDO.isSuccess() == false) {
            return new ResultDO<GoodsDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            GoodsDO doResultDOModule = goodsDOResultDO.getModule();
            return new ResultDO<GoodsDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, doResultDOModule);
        }

    }

    /**
     * 修改物品信息
     *
     * @param goodsDO
     */
    @Override
    @PostMapping("update-goods")
    public ResultDO<Void> updateGoods(@RequestBody GoodsDO goodsDO) {
        // 参数校验
        if (goodsDO.getId() <= 0 || goodsDO.getroomId() <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<GoodsDO> goodsDOResultDO = goodsService.showGoods(goodsDO.getId());
        if (goodsDOResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            GoodsDO doResultDOModule = goodsDOResultDO.getModule();
            doResultDOModule.setCompensationMoeny(goodsDO.getCompensationMoeny());
            doResultDOModule.setName(goodsDO.getName());
            doResultDOModule.setId(goodsDO.getId());
            doResultDOModule.setPrice(goodsDO.getPrice());
            doResultDOModule.setroomId(goodsDO.getroomId());
            doResultDOModule.setState(goodsDO.getState());
            doResultDOModule.setbuyTime(goodsDO.getbuyTime());

            ResultDO<Void> voidResultDO = goodsService.updateGoods(doResultDOModule);
            if (voidResultDO.isSuccess() == false) {
                return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            } else {
                return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
            }
        }
    }

    /**
     * 根据房间查询物品信息
     *
     * @param roomId
     */
    @Override
    @PostMapping("show-goodsbyroomid")
    public ResultDO<List<GoodsDO>> showGoodsByRoom(@RequestParam(name = "roomId") long roomId) {
        // 参数校验
        if (roomId <= 0) {
            return new ResultDO<List<GoodsDO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<List<GoodsDO>> listResultDO = goodsService.showGoodsByRoom(roomId);
        if (listResultDO.isSuccess() == false) {
            return new ResultDO<List<GoodsDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            List<GoodsDO> resultDOModule = listResultDO.getModule();
            return new ResultDO<List<GoodsDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, resultDOModule);
        }
    }

    /**
     * 删除物品信息
     *
     * @return
     */
    @Override
    @PostMapping("delete-goods")
    public ResultDO<Void> deleteById(long id) {
        // 参数校验
        if (id <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<Void> voidResultDO = goodsService.deleteById(id);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }

    }

    /**
     * 查询所有物品信息
     *
     * @return
     */
    @Override
    @PostMapping("show-goodslist")
    public ResultDO<List<GoodsDO>> getAll() {
        ResultDO<List<GoodsDO>> goodsServiceAll = goodsService.getAll();
        if (goodsServiceAll.isSuccess() == false) {
            return new ResultDO<List<GoodsDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            List<GoodsDO> serviceAllModule = goodsServiceAll.getModule();
            return new ResultDO<List<GoodsDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, serviceAllModule);
        }
    }
}
