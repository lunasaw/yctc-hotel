package com.altersoftware.hotel.service;

import com.altersoftware.hotel.entity.ResultDO;

import java.util.List;

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

    ResultDO<List<Long>> showFloorId();
}
