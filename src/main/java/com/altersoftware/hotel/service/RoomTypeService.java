package com.altersoftware.hotel.service;

import java.util.List;

import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.RoomTypeDO;

/**
 * @author czy@win10
 * @date 2020/2/2 15:48
 */
public interface RoomTypeService {
    /**
     * 插入一个类别信息
     * 
     * @return
     */
    ResultDO<Void> insert(RoomTypeDO roomTypeDO);

    /**
     * 查询所有房间类别信息
     */
    ResultDO<List<RoomTypeDO>> getRoomTypes();

    /**
     * 更新房间类别状态
     */
    ResultDO<Void> updateRoom(RoomTypeDO roomTypeDO);

    /**
     * 删除指定房间类别数据
     */
    ResultDO<Void> deleteRoomTypeDO(long id);

    /**
     * 删除部分房间类别数据
     */
    ResultDO<Void> deleteList(List<Long> ids);

    /**
     * 房间类别id查询房间类别信息
     */
    ResultDO<RoomTypeDO> getRoomTypeDOById(long id);
}
