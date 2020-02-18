package com.altersoftware.hotel.controller.rest;

import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;
import com.altersoftware.hotel.vo.GoodsVO;

import java.util.List;

/**
 * @author hzx
 * @date
 */
public interface StateSetController {
    /**
     * 接收物品状态值
     *
     */
    ResultDO<Void> updateGoodsDO(List<GoodsVO> goodsVOS);
}
