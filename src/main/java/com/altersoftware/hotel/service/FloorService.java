package com.altersoftware.hotel.service;

import java.util.List;

import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author czy@win10
 * @date 2020/1/28 21:19
 */
public interface FloorService {

    /**
     * 展示平面图
     *
     * @param id
     */
    ResultDO<String> show2D(long id);

    /**
     * 展示消防图
     *
     * @param id
     */
    ResultDO<String> showFire(long id);

    /**
     * 展示3D图
     *
     * @param id
     */
    ResultDO<String> show3D(long id);

    /**
     * 返回idList
     * 
     * @return
     */
    ResultDO<List<Long>> showFloorId();
}
