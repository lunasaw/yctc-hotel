package com.altersoftware.hotel.service;

import java.util.List;

import com.altersoftware.hotel.entity.GoodsDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author czy@win10
 * @date 2020/1/31 21:23
 */
public interface GoodsService {
    /**
     * 插入一条物品信息
     * 
     * @param goodsDO
     * @return
     */
    ResultDO<Void> insert(GoodsDO goodsDO);

    /**
     * 展示物品信息
     *
     * @param id
     */
    ResultDO<GoodsDO> showGoods(long id);

    /**
     * 修改物品信息
     *
     * @param goodsDO
     */
    ResultDO<Void> updateGoods(GoodsDO goodsDO);

    /**
     * 根据房间查询物品信息
     *
     * @param roomId
     */
    ResultDO<List<GoodsDO>> showGoodsByRoom(long roomId);

    /**
     * 删除物品信息
     *
     * @return
     */
    ResultDO<Void> deleteById(long id);

    /**
     * 查询所有物品信息
     *
     * @return
     */
    ResultDO<List<GoodsDO>> getAll();
}
