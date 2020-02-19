package com.altersoftware.hotel.controller.rest;

import java.util.List;

import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.RoomGoodsDO;

/**
 * @author hzx
 * @date
 */
public interface StateSetController {
    /**
     * 接收物品状态值
     *
     */
    ResultDO<Void> updateGoodsDO(List<RoomGoodsDO> roomGoodsDOS);

    /**
     * 插入一条物品状态信息
     *
     * @param roomGoodsDO
     * @return
     */
    ResultDO<Void> insert(RoomGoodsDO roomGoodsDO);

    /**
     * 展示物品状态信息
     *
     * @param roomNumber
     * @param goodsName
     * @return
     */
    ResultDO<RoomGoodsDO> showGoodsByRoomNumberAndGoodsName(int roomNumber, String goodsName);

    /**
     * 根据房间查询物品状态信息
     *
     * @param roomNumber
     */
    ResultDO<List<RoomGoodsDO>> showRoomGoodsByRoomNumber(int roomNumber);

    /**
     * 查询所有相同物品的状态信息
     *
     * @return
     */
    ResultDO<List<RoomGoodsDO>> showRoomGoodsByGoodsName(String goodsName);

    /**
     * 查询所有物品的状态信息
     *
     * @return
     */
    ResultDO<List<RoomGoodsDO>> showGoodsStateList();
}
