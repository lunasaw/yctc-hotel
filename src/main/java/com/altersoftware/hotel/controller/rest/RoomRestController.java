package com.altersoftware.hotel.controller.rest;

import java.util.List;

import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.RoomDO;
import com.altersoftware.hotel.vo.RoomVO;

/**
 * @author czy@win10
 * @date 2020/1/29 21:18
 */
public interface RoomRestController {
    /**
     * 展示所有房间信息
     *
     */
    ResultDO<List<RoomDO>> showRoomList();

    /**
     * 更新房间信息
     *
     */
    ResultDO<Void> updateRoom(RoomVO roomVO);

    /**
     * 通过房间号搜索房间
     */
    ResultDO<RoomDO> getRoomByNumber(long id,int roomNumber);
}
