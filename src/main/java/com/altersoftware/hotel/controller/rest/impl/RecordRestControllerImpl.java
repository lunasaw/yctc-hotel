package com.altersoftware.hotel.controller.rest.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            return new ResultDO<RecordDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
                recordDOResultDO.getModule());
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
            return new ResultDO<List<RecordDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
                listResultDO.getModule());
        }
    }

    /**
     * 根据用户编号查询订单信息List
     *
     * @param customerId
     */
    @Override
    @PostMapping("get-bycustomerId")
    public ResultDO<List<RecordDO>> showRecordByCustomer(long customerId) {
        // 参数校验
        if (customerId <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<List<RecordDO>> listResultDO = recordService.showRecordListByCustomer(customerId);
        if (listResultDO.isSuccess() == false) {
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, listResultDO.getModule());
        }
    }

    @Override
    @PostMapping("get-bynowcustomer")
    public ResultDO<List<RecordDO>> showRecordNowByCustomer(long customerId) {
        // 参数校验
        if (customerId <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            ResultDO<List<RecordDO>> listResultDO = recordService.showRecordByCustomer(customerId);
            List<RecordDO> module = listResultDO.getModule();
            List<RecordDO> nowToLive = new ArrayList<>();
            for (int i = 0; i < module.size(); i++) {
                nowToLive.add(module.get(i));
            }
            if (listResultDO.isSuccess() == false) {
                return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            } else {
                return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, nowToLive);
            }
        } catch (Exception e) {
            return new ResultDO<>(false, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, null);
        }
    }

    @Override
    @PostMapping("getnumbers-bycustomer")
    public ResultDO<List<Integer>> getRoomByCustomerId(long customerId) {
        // 参数校验
        if (customerId <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            ResultDO<List<RecordDO>> listResultDO = recordService.showRecordByCustomer(customerId);
            List<RecordDO> module = listResultDO.getModule();
            List<Integer> strings = new ArrayList<>();
            for (int i = 0; i < module.size(); i++) {
                strings.add(module.get(i).getRoomNumber());
            }
            if (listResultDO.isSuccess() == false) {
                return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            } else {
                return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, strings);
            }
        } catch (Exception e) {
            return new ResultDO<>(false, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, null);
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
            return new ResultDO<List<RecordDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
                listResultDO.getModule());
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
     * 删除多条记录
     * 
     * @param ids
     * @return
     */
    @Override
    @PostMapping("delete-byidlist")
    public ResultDO<Void> deleteList(@RequestBody Long[] ids) {
        // 参数校验
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
            return new ResultDO<List<RecordDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
                listResultDO.getModule());
        }
    }

    @Override
    @PostMapping("get-nowtocustomerid")
    public ResultDO<Long> overClean(int roomNumber) throws ParseException {
        ResultDO<List<RecordDO>> listResultDO = recordService.showRecordByRoomNumber(roomNumber);
        List<RecordDO> module = listResultDO.getModule();
        long id = 0;
        for (int i = 0; i < module.size(); i++) {
            String checkOutTime = module.get(i).getCheckOutTime();
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = sdf.parse(checkOutTime);
            // 如果退房时间在当前时间之前 则无视
            if (parse.before(now) || module.get(i).getState() == 0) {
                continue;
            } else {
                id = module.get(i).getCustomerId();
            }
        }
        if (id != 0) {
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, id);
        } else {
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        }
    }

    /**
     * 更新退房时间
     * @param id
     * @return
     */
    @Override
    @PostMapping("update-nowtime")
    public ResultDO<Void> updateOutime(long id,String evaluate) {
        //参数校验
        if (id <= 0 || StringUtils.isBlank(evaluate)) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<RecordDO> recordDOResultDO = recordService.showRecord(id);
        if (recordDOResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = new java.util.Date();
            String now = sdf.format(date);
            RecordDO doResultDOModule = recordDOResultDO.getModule();
            doResultDOModule.setCheckOutTime(now);
            doResultDOModule.setEvaluate(evaluate);

            ResultDO<Void> voidResultDO = recordService.updateRecord(doResultDOModule);
            if (voidResultDO.isSuccess() == false) {
                return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                        ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            } else {
                return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
            }

        }
    }
}
