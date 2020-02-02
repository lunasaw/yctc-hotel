package com.altersoftware.hotel.controller.rest.impl;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.controller.rest.RoomTypeRestController;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.RoomTypeDO;

/**
 * @author czy@win10
 * @date 2020/2/2 16:35
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/roomTypeInfo")
public class RoomTypeRestControllerImpl implements RoomTypeRestController {

    @Override
    @PostMapping("add-roomtype")
    public ResultDO<Void> insert(RoomTypeDO roomTypeDO) {
        return null;
    }

    @Override
    @PostMapping("get-list")
    public ResultDO<List<RoomTypeDO>> getRoomTypes() {
        return null;
    }

    @Override
    @PostMapping("update-roomtype")
    public ResultDO<Void> updateRoom(RoomTypeDO roomTypeDO) {
        return null;
    }

    @Override
    @PostMapping("delete-roomtype")
    public ResultDO<Void> deleteRoomTypeDO(long id) {
        return null;
    }

    @Override
    @PostMapping("get-byid")
    public ResultDO<RoomTypeDO> getRoomTypeDOById(long id) {
        return null;
    }
}
