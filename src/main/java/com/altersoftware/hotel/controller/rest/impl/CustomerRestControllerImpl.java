package com.altersoftware.hotel.controller.rest.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.controller.rest.CustomerRestController;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;
import com.altersoftware.hotel.service.CustomerService;

/**
 * @author hzx
 * @date 2020/1/30 19:57
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/customer")
public class CustomerRestControllerImpl implements CustomerRestController {
    @Autowired
    CustomerService customerService;

    /**
     * 获取所有客户信息
     *
     * @return
     */
    @Override
    @PostMapping("getall")
    public ResultDO<List<UserDO>> getAllCustomer() {
        ResultDO<List<UserDO>> allCustomer = customerService.getAllCustomer();
        if (allCustomer.isSuccess() == false) {
            return new ResultDO<List<UserDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            List<UserDO> allCustomerModule = allCustomer.getModule();
            return new ResultDO<List<UserDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, allCustomerModule);
        }
    }

    /**
     * 修改客户信息
     *
     * @param userDO
     * @return
     */
    @Override
    @PostMapping("updateone")
    public ResultDO<Void> updateUserDO(@RequestBody UserDO userDO) {
        // 参数校验
        if (userDO.getId() <= 0 || userDO.getDepartmentId() <= 0
            || StringUtils.isBlank(userDO.getNumber())
            || StringUtils.isBlank(userDO.getIdCardNumber())) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<UserDO> byNumber = customerService.getByNumber(userDO.getNumber());
        if (byNumber.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            UserDO userDObyNumber = byNumber.getModule();
            userDObyNumber.setAge(userDO.getAge());
            userDObyNumber.setContactPhone(userDO.getContactPhone());
            userDObyNumber.setAccount(userDO.getAccount());
            userDObyNumber.setEmail(userDO.getEmail());
            userDObyNumber.setIdCardNumber(userDO.getIdCardNumber());
            userDObyNumber.setName(userDO.getName());
            userDObyNumber.setSex(userDO.getSex());
            userDObyNumber.setType(userDO.getType());
            userDObyNumber.setFaceId(userDO.getFaceId());
            userDObyNumber.setDepartmentId(userDO.getDepartmentId());
            ResultDO<Void> voidResultDO = customerService.updateUserDO(userDObyNumber);
            if (voidResultDO.isSuccess()) {
                return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
            } else {
                return new ResultDO<Void>(false, ResultCode.UPDATE_FAILD,
                    ResultCode.MSG_UPDATE_FAILD, null);
            }
        }
    }

    /**
     * 删除指定客户信息
     *
     * @param number
     * @return
     */
    @Override
    @PostMapping("deletebyUserid")
    public ResultDO<Void> deleteByUserId(@RequestParam(name = "number") String number) {
        // 参数校验
        if (StringUtils.isBlank(number)) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<UserDO> byNumber = customerService.getByNumber(number);
        if (byNumber.isSuccess()) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            ResultDO<Void> voidResultDO = customerService.deleteByUserId(number);
            if (voidResultDO.isSuccess() == false) {
                return new ResultDO<Void>(false, ResultCode.DELETE_FAILD, ResultCode.MSG_DELETE_FAILD);
            } else {
                return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
            }
        }

    }

    /**
     * 会员号搜索客户/员工
     *
     * @param number
     * @return
     */
    @Override
    @PostMapping("getbynumber")
    public ResultDO<UserDO> getByNumber(@RequestParam(name = "number") String number) {
        // 参数校验
        if (StringUtils.isBlank(number)) {
            return new ResultDO<UserDO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<UserDO> byNumber = customerService.getByNumber(number);
        if (byNumber.isSuccess() == false) {
            return new ResultDO<UserDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            UserDO byNumberModule = byNumber.getModule();
            return new ResultDO<UserDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, byNumberModule);
        }
    }
}
