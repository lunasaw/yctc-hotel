package com.altersoftware.hotel.controller.rest.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.controller.rest.VipRestController;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.VipDO;
import com.altersoftware.hotel.service.VipService;

/**
 * @author hzx
 * @date
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/vip")
public class VipRestControllerImpl implements VipRestController {
    @Autowired
    VipService vipService;

    /**
     * 插入一条会员信息
     *
     * @param vipDO
     * @return
     */
    @Override
    @PostMapping("add-vip")
    public ResultDO<Void> insert(@RequestBody VipDO vipDO) {
        // 参数校验
        if (vipDO.getId() <= 0 || vipDO.getCustomerNumber() <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<Void> voidResultDO = vipService.insert(vipDO);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }


    /**
     * 展示会员信息
     *
     * @param id
     */
    @Override
    @PostMapping("get-vip")
    public ResultDO<VipDO> showVip(long id) {
        // 参数校验
        if (id <= 0) {
            return new ResultDO<VipDO>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<VipDO> vipDOResultDO = vipService.showVip(id);
        if (vipDOResultDO.isSuccess() == false) {
            return new ResultDO<VipDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            VipDO doResultDOModule = vipDOResultDO.getModule();
            return new ResultDO<VipDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, doResultDOModule);
        }
    }

    @Override
    @PostMapping("get-bycustomerId")
    public ResultDO<VipDO> showVipByCustomerId(long customerId) {
        // 参数校验
        if (customerId < 0) {
            return new ResultDO<VipDO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<VipDO> vipDOResultDO = vipService.showVipByCustomerId(customerId);
        if (vipDOResultDO.isSuccess() == false) {
            return new ResultDO<VipDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            VipDO doResultDOModule = vipDOResultDO.getModule();
            return new ResultDO<VipDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, doResultDOModule);
        }
    }


    /**
     * 修改会员信息
     *
     * @param vipDO
     */
    @Override
    @PostMapping("update-vip")
    public ResultDO<Void> updateVip(@RequestBody VipDO vipDO) {
        // 参数校验
        if (vipDO.getId() <= 0 || vipDO.getCustomerNumber() <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<VipDO> vipDOResultDO = vipService.showVip(vipDO.getId());
        if (vipDOResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            VipDO vipDOResultDOModule = vipDOResultDO.getModule();
            vipDOResultDOModule.setAmount(vipDO.getAmount());
            vipDOResultDOModule.setGrade(vipDO.getGrade());
            vipDOResultDOModule.setId(vipDO.getId());
            vipDOResultDOModule.setCustomerNumber(vipDO.getCustomerNumber());

            ResultDO<Void> voidResultDO = vipService.updateVip(vipDO);
            if (voidResultDO.isSuccess() == false) {
                return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                        ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            } else {
                return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
            }
        }
    }


    /**
     * 根据房间查询会员信息
     *
     * @return <List<VipDO>>
     */
    @Override
    @PostMapping("get-list")
    public ResultDO<List<VipDO>> showVipList() {
        ResultDO<List<VipDO>> listResultDO = vipService.showVipList();
        if (listResultDO.isSuccess() == false) {
            return new ResultDO<List<VipDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            List<VipDO> listResultDOModule = listResultDO.getModule();
            return new ResultDO<List<VipDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, listResultDOModule);
        }
    }


    /**
     * 删除会员信息
     *
     * @return
     */
    @Override
    @PostMapping("delete-byid")
    public ResultDO<Void> deleteById(long id) {
        // 参数校验
        if (id < 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<Void> voidResultDO = vipService.deleteById(id);
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
        ResultDO<Void> voidResultDO = vipService.deleteList(resultList);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }


    /**
     * 查询所有会员编号
     *
     * @return <List<VipDO>>
     */
    @Override
    @PostMapping("get-bynumber")
    public ResultDO<List<Long>> getAllNumberList() {
        ResultDO<List<Long>> allNumberList = vipService.getAllNumberList();
        if (allNumberList.isSuccess() == false) {
            return new ResultDO<List<Long>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            List<Long> allNumberListModule = allNumberList.getModule();
            return new ResultDO<List<Long>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, allNumberListModule);
        }
    }



}
