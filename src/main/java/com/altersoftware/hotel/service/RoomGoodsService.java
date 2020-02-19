package com.altersoftware.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.RoomGoodsDO;

/**
 * @author Iszychen@win10
 * @date 2020/2/19 15:41
 */
@Service
public interface RoomGoodsService {
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
     * 更新物品状态信息
     *
     * @param roomGoodsDO
     */
    ResultDO<Void> updateGoods(RoomGoodsDO roomGoodsDO);

    /**
     * 根据房间查询物品状态信息
     *
     * @param roomNumber
     */
    ResultDO<List<RoomGoodsDO>> showRoomGoodsByRoomNumber(int roomNumber);

    /**
     * 删除物品状态信息
     *
     * @return
     */
    ResultDO<Void> deleteByRoomNumberAndGoodsName(int roomNumber, String goodsName);

    /**
     * 删除一个房间所有物品物品状态信息
     *
     * @return
     */
    ResultDO<Void> deleteList(int roomNumber);

    /**
     * 查询所有物品状态信息
     *
     * @return
     */
    ResultDO<List<RoomGoodsDO>> showRoomGoodsByGoodsName(String goodsName);
}
