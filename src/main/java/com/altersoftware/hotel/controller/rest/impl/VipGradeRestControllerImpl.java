package com.altersoftware.hotel.controller.rest.impl;

import java.util.ArrayList;
import java.util.List;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.entity.VipDO;
import com.altersoftware.hotel.service.VipGradeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import com.altersoftware.hotel.controller.rest.VipGradeRestController;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.VipGradeDO;

/**
 * @author Iszychen@win10
 * @date 2020/2/6 18:28
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/vipGrade")
public class VipGradeRestControllerImpl implements VipGradeRestController {

    @Autowired
    VipGradeService vipGradeService;

    /**
     * 插入一条等级信息
     *
     * @param vipGradeDO
     * @return
     */
    @Override
    @PostMapping("add-vipgrade")
    public ResultDO<Void> insert(@RequestBody VipGradeDO vipGradeDO) {
        // 参数校验
        if (vipGradeDO.getId() <= 0 || StringUtils.isBlank(vipGradeDO.getGrade()) || StringUtils.isBlank(vipGradeDO.getEquity())
                || vipGradeDO.getDiscount() <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<Void> voidResultDO = vipGradeService.insert(vipGradeDO);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    /**
     * 展示等级信息
     *
     * @param id
     */
    @Override
    @PostMapping("get-byid")
    public ResultDO<VipGradeDO> showVipGrade(long id) {
        // 参数校验
        if (id <= 0) {
            return new ResultDO<VipGradeDO>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<VipGradeDO> vipGradeDOResultDO = vipGradeService.showVipGrade(id);
        if (vipGradeDOResultDO.isSuccess() == false) {
            return new ResultDO<VipGradeDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            VipGradeDO vipGradeDOResultDOModule = vipGradeDOResultDO.getModule();
            return new ResultDO<VipGradeDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, vipGradeDOResultDOModule);
        }
    }

    /**
     * 修改等级信息
     *
     * @param vipGradeDO
     */
    @Override
    @PostMapping("update-vipgrade")
    public ResultDO<Void> updateVipGrade(@RequestBody VipGradeDO vipGradeDO) {
        // 参数校验
        if (vipGradeDO.getId() <= 0 || StringUtils.isBlank(vipGradeDO.getGrade()) || StringUtils.isBlank(vipGradeDO.getEquity())
                || vipGradeDO.getDiscount() <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<VipGradeDO> vipGradeDOResultDO = vipGradeService.showVipGrade(vipGradeDO.getId());
        if (vipGradeDOResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            VipGradeDO doResultDOModule = vipGradeDOResultDO.getModule();
            doResultDOModule.setGrade(vipGradeDO.getGrade());
            doResultDOModule.setDiscount(vipGradeDO.getDiscount());
            doResultDOModule.setEquity(vipGradeDO.getEquity());
            doResultDOModule.setId(vipGradeDO.getId());
            ResultDO<Void> voidResultDO = vipGradeService.updateVipGrade(doResultDOModule);
            if (voidResultDO.isSuccess() == false) {
                return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                        ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            } else {
                return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
            }
        }
    }

    /**
     * 根据等级查询信息
     *
     * @param grade
     */
    @Override
    @PostMapping("getlist-bygrade")
    public ResultDO<List<VipGradeDO>> showVipGradeByGrade(@RequestParam(name = "grade") String grade) {
        // 参数校验
        if (StringUtils.isBlank(grade)) {
            return new ResultDO<List<VipGradeDO>>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<List<VipGradeDO>> listResultDO = vipGradeService.showVipGradeByGrade(grade);
        if (listResultDO.isSuccess() == false) {
            return new ResultDO<List<VipGradeDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<List<VipGradeDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    /**
     * 删除等级信息
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
        ResultDO<Void> voidResultDO = vipGradeService.deleteById(id);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    /**
     *删除多条记录
     * @param numbers
     * @return
     */
    @Override
    @PostMapping("delete-byidlist")
    public ResultDO<Void> deleteList(@RequestBody Long[] numbers) {
        //参数校验
        if (numbers == null || numbers.length == 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        List<Long> resultList = new ArrayList<>(numbers.length);
        for (Long s : numbers) {
            resultList.add(s);
        }
        ResultDO<Void> voidResultDO = vipGradeService.deleteList(resultList);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    /**
     * 查询所有会员权益
     *
     * @return <List<VipGradeDO>>
     */
    @Override
    @PostMapping("get-list")
    public ResultDO<List<VipGradeDO>> showVipGradeList() {
        ResultDO<List<VipGradeDO>> listResultDO = vipGradeService.showVipGradeList();
        if (listResultDO.isSuccess() == false) {
            return new ResultDO<List<VipGradeDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {

            return new ResultDO<List<VipGradeDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, listResultDO.getModule());
        }
    }


}
