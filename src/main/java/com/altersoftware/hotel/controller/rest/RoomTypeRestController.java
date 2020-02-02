package com.altersoftware.hotel.controller.rest;

import java.util.List;

import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.RoomTypeDO;

/**
 * @author czy@win10
 * @date 2020/2/2 16:34
 */
public interface RoomTypeRestController {

    /**
     * 插入一个类别信息
     * 
     * @param roomTypeDO
     * @return
     */
    ResultDO<Void> insert(RoomTypeDO roomTypeDO);

    /**
     * 查询所有房间类别信息
     * 
     * @return
     */
    ResultDO<List<RoomTypeDO>> getRoomTypes();

    /**
     * 更新房间类别状态
     * 
     * @param roomTypeDO
     * @return
     */
    ResultDO<Void> updateRoom(RoomTypeDO roomTypeDO);

    /**
     * 删除指定房间类别数据
     * 
     * @param id
     * @return
     */
    ResultDO<Void> deleteRoomTypeDO(long id);

    /**
     * 房间类别id查询房间类别信息
     * 
     * @param id
     * @return
     */
    ResultDO<RoomTypeDO> getRoomTypeDOById(long id);

}
