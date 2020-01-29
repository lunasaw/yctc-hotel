package com.altersoftware.hotel.controller.rest.impl;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.controller.rest.RoomRestController;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.RoomDO;

/**
 * @author czy@win10
 * @date 2020/1/29 21:20
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/room")
public class RoomRestControllerImpl implements RoomRestController {

    @Override
    @PostMapping("show-listRoom")
    public ResultDO<List<RoomDO>> showRoomList() {
        return null;
    }

    @Override
    @PostMapping("update-room")
    public ResultDO<Void> updateRoom() {
        return null;
    }

    @Override
    @PostMapping("get-byNumber")
    public ResultDO<RoomDO> getRoomByNumber() {
        return null;
    }
}
