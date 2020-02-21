package com.altersoftware.hotel.controller.rest.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.controller.rest.LeaseRestController;
import com.altersoftware.hotel.entity.LeaseDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.LeaseService;

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

    @Override
    public ResultDO<LeaseDO> insert(LeaseDO leaseDO) {
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
    public ResultDO<Void> updateLease(LeaseDO leaseDO) {

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
    public ResultDO<Void> deleteList(Long[] ids) {
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
