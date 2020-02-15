package com.altersoftware.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.RoomDO;

/**
 * @author czy@win10
 * @date 2020/1/29 20:54
 */
@Service
public interface RoomService {
    /**
     * 插入一个房间信息
     * 
     * @param roomDO
     * @return
     */
    ResultDO<Void> insert(RoomDO roomDO);

    /**
     * 查询所有房间信息
     * 
     * @return
     */
    ResultDO<List<RoomDO>> getRooms();

    /**
     * 更新房间状态
     * 
     * @param roomDO
     * @return
     */
    ResultDO<Void> updateRoom(RoomDO roomDO);

    /**
     * 返回指定房间数据
     * 
     * @param id
     * @return
     */
    ResultDO<RoomDO> getRoomDO(long id);

    /**
     * 房间号查询房间信息
     * 
     * @param roomNumber
     * @return
     */
    ResultDO<RoomDO> getRoomDOByNumber(int roomNumber);


    /**
     * id删除房间信息
     * 
     * @param id
     * @return
     */
    ResultDO<Void> deleteById(long id);

    /**
     * 删除部分房间信息
     *
     * @param ids
     * @return
     */
    ResultDO<Void> deleteList(List<Long> ids);

    /**
     * 根据类别找出一个未入住房间
     *
     * @param roomTypeName
     * @return
     */
    ResultDO<RoomDO> getRoomDOByRoomType(String roomTypeName);

}
