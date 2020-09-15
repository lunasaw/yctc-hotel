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
     * @return
     */
    ResultDO<List<RoomDO>> showRoomList();

    /**
     * 更新房间信息
     * 
     * @param roomVO
     * @return
     */
    ResultDO<Void> updateRoom(RoomVO roomVO);

    /**
     * 返回指定房间数据
     * 
     * @param id
     * @return
     */
    ResultDO<RoomDO> getRoomDO(long id);

    /**
     * 通过房间号搜索房间
     * 
     * @param roomNumber
     * @return
     */
    ResultDO<RoomDO> getRoomByNumber(int roomNumber);


    /**
     * 插入一个房间信息
     * 
     * @param roomDO
     * @return
     */
    ResultDO<Void> insert(RoomDO roomDO);

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
    ResultDO<Void> deleteList(Long[] ids);
}
