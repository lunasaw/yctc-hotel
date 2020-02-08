package com.altersoftware.hotel.controller.rest.impl;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.controller.rest.RecordRestController;
import com.altersoftware.hotel.entity.RecordDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author Iszychen@win10
 * @date 2020/2/7 22:07
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/record")
public class RecordRestControllerImpl implements RecordRestController {

    @Override
    @PostMapping("get-byid")
    public ResultDO<RecordDO> showRecord(long id) {
        return null;
    }

    @Override
    @PostMapping("get-bystaff")
    public ResultDO<List<RecordDO>> showRecordBystaffId(long staffId) {
        return null;
    }

    @Override
    @PostMapping("update")
    public ResultDO<Void> updateRecord(RecordDO recordDO) {
        return null;
    }

    @Override
    @PostMapping("get-byroom")
    public ResultDO<List<RecordDO>> showRecordByRoomNumber(int roomNumber) {
        return null;
    }

    @Override
    @PostMapping("delete-byid")
    public ResultDO<Void> deleteById(long id) {
        return null;
    }

    @Override
    @PostMapping("get-list")
    public ResultDO<List<RecordDO>> getAll() {
        return null;
    }
}
