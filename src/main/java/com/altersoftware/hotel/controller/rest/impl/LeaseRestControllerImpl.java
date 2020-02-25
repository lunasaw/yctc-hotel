package com.altersoftware.hotel.controller.rest.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.controller.rest.LeaseRestController;
import com.altersoftware.hotel.entity.LeaseDO;
import com.altersoftware.hotel.entity.RecordDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.LeaseService;
import com.altersoftware.hotel.service.RecordService;
import com.altersoftware.hotel.util.CaculateTotalTime;
import com.altersoftware.hotel.util.RandomNumber;
import com.altersoftware.hotel.vo.LeaseVO;

/**
 * @author czy@win10
 * @date 2020/1/31 21:53
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/lease")
public class LeaseRestControllerImpl implements LeaseRestController {
    @Autowired
    LeaseService leaseService;

    @Autowired
    RecordService recordService;

    @Override
    @PostMapping("accept-lease")
    public ResultDO<Void> addlease(@RequestBody List<LeaseVO> leaseVOS) {
        //参数校验
        if (leaseVOS.size() <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        for (int i = 0; i < leaseVOS.size(); i++) {
            LeaseVO leaseVO = leaseVOS.get(i);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formatDate = dateFormat.format(new Date());
            // 生成随机数
            RandomNumber randomNumber = new RandomNumber();
            CaculateTotalTime caculate = new CaculateTotalTime();
            ResultDO<List<RecordDO>> listResultDO = recordService.showRecordByCustomer(leaseVO.getCustomerId());
            String checkOutTime = listResultDO.getModule().get(0).getCheckOutTime();
            int totalTime = caculate.caculateTotalTime(formatDate, checkOutTime);
            Date returndate = new Date();
            try {
                Date date = dateFormat.parse(checkOutTime);
                returndate = date;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            LeaseDO leaseDO = new LeaseDO();
            leaseDO.setId(Long.parseLong(randomNumber.GetRandom()));
            leaseDO.setCustomerId(leaseVO.getCustomerId());
            leaseDO.setGoodsId(leaseVO.getGoodsId());
            leaseDO.setRentalTime(String.valueOf(totalTime));
            leaseDO.setReturnTime(returndate);
            ResultDO<Void> voidResultDO = leaseService.insert(leaseDO);
            if (voidResultDO.isSuccess() == false) {
                return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                        ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            } else {
                return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
            }
        }
       return null;
    }

    @Override
    @PostMapping("add-lease")
    public ResultDO<LeaseDO> insert(@RequestBody LeaseDO leaseDO) {
        // 参数校验
        if (leaseDO.getId() <= 0 || StringUtils.isBlank(leaseDO.getRentalTime())) {
            return new ResultDO<LeaseDO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<Void> voidResultDO = leaseService.insert(leaseDO);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<LeaseDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<LeaseDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    @Override
    @PostMapping("show-leasebyid")
    public ResultDO<LeaseDO> showLease(long id) {
        // 参数校验
        if (id <= 0) {
            return new ResultDO<LeaseDO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<LeaseDO> leaseDOResultDO = leaseService.showLease(id);
        if (leaseDOResultDO.isSuccess() == false) {
            return new ResultDO<LeaseDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            LeaseDO doResultDOModule = leaseDOResultDO.getModule();
            return new ResultDO<LeaseDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, doResultDOModule);
        }

    }

    @Override
    @PostMapping("update-lease")
    public ResultDO<Void> updateLease(@RequestBody LeaseDO leaseDO) {

        // 参数校验
        if (leaseDO.getId() <= 0 || StringUtils.isBlank(leaseDO.getRentalTime())) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<LeaseDO> leaseDOResultDO = leaseService.showLease(leaseDO.getId());
        if (leaseDOResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            LeaseDO doResultDOModule = leaseDOResultDO.getModule();

            doResultDOModule.setCustomerId(leaseDO.getCustomerId());
            doResultDOModule.setReturnTime(leaseDO.getReturnTime());
            doResultDOModule.setGoodsId(leaseDO.getGoodsId());
            doResultDOModule.setReturnTime(leaseDO.getReturnTime());
            ResultDO<Void> voidResultDO = leaseService.updateLease(doResultDOModule);
            if (voidResultDO.isSuccess() == false) {
                return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            } else {
                return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
            }
        }
    }

    @Override
    @PostMapping("show-leasebycustomerId")
    public ResultDO<List<LeaseDO>> showLeaseByCustomerId(long customerId) {
        // 参数校验
        if (customerId <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<List<LeaseDO>> listResultDO = leaseService.showLeaseByCustomerId(customerId);
        if (listResultDO.isSuccess() == false) {
            return new ResultDO<List<LeaseDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            List<LeaseDO> resultDOModule = listResultDO.getModule();
            return new ResultDO<List<LeaseDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, resultDOModule);
        }
    }

    @Override
    @PostMapping("delete-lease")
    public ResultDO<Void> deleteById(long id) {
        // 参数校验
        if (id <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<Void> voidResultDO = leaseService.deleteById(id);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }

    }

    @Override
    @PostMapping("get-list")
    public ResultDO<List<LeaseDO>> getAll() {
        ResultDO<List<LeaseDO>> leaseServiceAll = leaseService.getAll();
        if (leaseServiceAll.isSuccess() == false) {
            return new ResultDO<List<LeaseDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            List<LeaseDO> serviceAllModule = leaseServiceAll.getModule();
            return new ResultDO<List<LeaseDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, serviceAllModule);
        }
    }

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
        ResultDO<Void> voidResultDO = leaseService.deleteList(resultList);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }
}
