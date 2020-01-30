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
     * 查询所有房间信息
     */
    ResultDO<List<RoomDO>> getRooms();

    /**
     * 更新房间状态
     */
    ResultDO<Void> updateRoom(RoomDO roomDO);

    /**
     * 返回指定房间数据
     */
    ResultDO<RoomDO> getRoomDO(long id);

    /**
     * 房间号查询房间信息
     */
    ResultDO<RoomDO> getRoomDOByNumber(int roomNumber);

}
