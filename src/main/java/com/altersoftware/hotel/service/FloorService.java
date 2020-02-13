package com.altersoftware.hotel.service;

import java.util.List;

import com.altersoftware.hotel.entity.FloorDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author czy@win10
 * @date 2020/1/28 21:19
 */
public interface FloorService {
    /**
     * 插入一条楼层信息
     * 
     * @param floorDO
     * @return
     */
    ResultDO<Void> insert(FloorDO floorDO);

    /**
     * id查询楼层信息
     *
     * @param id
     * @return
     */
    ResultDO<FloorDO> showFloorDO(long id);

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

    /**
     * 删除指定楼层信息
     * 
     * @param id
     */
    ResultDO<Void> delete(long id);

    /**
     * 删除部分指定楼层信息
     *
     * @param ids
     */
    ResultDO<Void> deleteList(List<Long> ids);
}
