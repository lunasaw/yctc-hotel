package com.altersoftware.hotel.controller.rest.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.controller.rest.RecordRestController;
import com.altersoftware.hotel.entity.RecordDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.RecordService;

/**
 * @author hzx
 * @date 2020/2/7 22:07
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/record")
public class RecordRestControllerImpl implements RecordRestController {

    @Autowired
    RecordService recordService;

    /**
     * 展示订单信息
     *
     * @param id
     */
    @Override
    @PostMapping("get-byid")
    public ResultDO<RecordDO> showRecord(long id) {
        // 参数校验
        if (id <= 0) {
            return new ResultDO<RecordDO>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<RecordDO> recordDOResultDO = recordService.showRecord(id);
        if (recordDOResultDO.isSuccess() == false) {
            return new ResultDO<RecordDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<RecordDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, recordDOResultDO.getModule());
        }
    }

    /**
     * 根据员工编号查询订单信息List
     *
     * @param staffId
     */
    @Override
    @PostMapping("get-bystaff")
    public ResultDO<List<RecordDO>> showRecordBystaffId(@RequestParam(name = "staffId") long staffId) {
        // 参数校验
        if (staffId <= 0) {
            return new ResultDO<List<RecordDO>>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<List<RecordDO>> listResultDO = recordService.showRecordBystaffId(staffId);
        if (listResultDO.isSuccess() == false) {
            return new ResultDO<List<RecordDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<List<RecordDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, listResultDO.getModule());
        }
    }

    /**
     * 修改订单信息
     *
     * @param recordDO
     */
    @Override
    @PostMapping("update")
    public ResultDO<Void> updateRecord(@RequestBody RecordDO recordDO) {
        // 参数校验
        if (recordDO.getId() <= 0 || recordDO.getRoomNumber() <= 0 || recordDO.getStaffId() <= 0
                || recordDO.getCustomerId() <= 0 || StringUtils.isBlank(recordDO.getEvaluate())) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<RecordDO> recordDOResultDO = recordService.showRecord(recordDO.getId());
        if (recordDOResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            RecordDO doResultDOModule = recordDOResultDO.getModule();
            doResultDOModule.setPrecheckInTime(recordDO.getPrecheckInTime());
            doResultDOModule.setCheckInTime(recordDO.getCheckInTime());
            doResultDOModule.setCheckOutTime(recordDO.getCheckOutTime());
            doResultDOModule.setEvaluate(recordDO.getEvaluate());
            doResultDOModule.setCustomerId(recordDO.getCustomerId());
            doResultDOModule.setId(recordDO.getId());
            doResultDOModule.setRoomNumber(recordDO.getRoomNumber());
            doResultDOModule.setStaffId(recordDO.getStaffId());

            ResultDO<Void> voidResultDO = recordService.updateRecord(doResultDOModule);
            if (voidResultDO.isSuccess() == false) {
                return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                        ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            } else {
                return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
            }
        }
    }

    /**
     * 根据房间门牌号查询订单信息
     *
     * @param roomNumber
     */
    @Override
    @PostMapping("get-byroom")
    public ResultDO<List<RecordDO>> showRecordByRoomNumber(@RequestParam(name = "roomNumber") int roomNumber) {
        if (roomNumber <= 0) {
            return new ResultDO<List<RecordDO>>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<List<RecordDO>> listResultDO = recordService.showRecordByRoomNumber(roomNumber);
        if (listResultDO.isSuccess() == false) {
            return new ResultDO<List<RecordDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<List<RecordDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, listResultDO.getModule());
        }
    }

    /**
     * 删除订单信息
     *
     * @return
     */
    @Override
    @PostMapping("delete-byid")
    public ResultDO<Void> deleteById(long id) {
        // 参数校验
        if (id <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<Void> voidResultDO = recordService.deleteById(id);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    /**
     *删除多条记录
     * @param ids
     * @return
     */
    @Override
    @PostMapping("delete-byidlist")
    public ResultDO<Void> deleteList(@RequestBody Long[] ids) {
        //参数校验
        if (ids == null || ids.length == 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        List<Long> resultList = new ArrayList<>(ids.length);
        for (Long s : ids) {
            resultList.add(s);
        }
        ResultDO<Void> voidResultDO = recordService.deleteList(resultList);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    /**
     * 查询所有订单信息
     *
     * @return
     */
    @Override
    @PostMapping("get-list")
    public ResultDO<List<RecordDO>> getAll() {
        ResultDO<List<RecordDO>> listResultDO = recordService.getAll();
        if (listResultDO.isSuccess() == false) {
            return new ResultDO<List<RecordDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<List<RecordDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, listResultDO.getModule());
        }
    }
}
