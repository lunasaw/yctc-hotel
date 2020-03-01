package com.altersoftware.hotel.controller.rest.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.constant.entity.department.DepartmentType;
import com.altersoftware.hotel.controller.rest.CustomerRestController;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;
import com.altersoftware.hotel.service.CustomerService;
import com.altersoftware.hotel.service.StaffService;

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

    @Autowired
    StaffService    staffService;

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
    @PostMapping("update-userdo")
    public ResultDO<Void> updateUserDO(@RequestBody UserDO userDO) {
        System.out.println(userDO);
        // 参数校验
        if (StringUtils.isBlank(userDO.getNumber())) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<UserDO> byNumber = customerService.getByNumber(userDO.getNumber());
        if (byNumber.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            UserDO userDObyNumber = byNumber.getModule();
            System.out.println(userDObyNumber);
            if (userDO.getAge() != 0) {
                userDObyNumber.setAge(userDO.getAge());
            }
            if (userDO.getContactPhone() != null) {
                userDObyNumber.setContactPhone(userDO.getContactPhone());
            }
            if (userDO.getAccount() != null) {
                userDObyNumber.setAccount(userDO.getAccount());

            }
            if (userDO.getEmail() != null) {
                userDObyNumber.setEmail(userDO.getEmail());

            }
            if (userDO.getIdCardNumber() != null) {
                userDObyNumber.setIdCardNumber(userDO.getIdCardNumber());
            }else{
	            return new ResultDO<Void>(false, ResultCode.UPDATE_FAILD,
			            ResultCode.MSG_UPDATE_FAILD, null);
            }
            if (userDO.getName() != null) {
                userDObyNumber.setName(userDO.getName());

            }
            if (userDO.getSex() != null) {
                userDObyNumber.setSex(userDO.getSex());

            }
            if (userDO.getType() != 0) {
                userDObyNumber.setType(userDO.getType());

            }
            if (userDO.getFaceId() != null) {
                userDObyNumber.setFaceId(userDO.getFaceId());

            }
            if (userDO.getDepartmentId() != 0) {
                userDObyNumber.setDepartmentId(userDO.getDepartmentId());

            }
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
    @PostMapping("delete-byid")
    public ResultDO<Void> deleteByUserId(@RequestBody @RequestParam(name = "number") String number) {
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
     * 删除多条记录
     * 
     * @param numbers
     * @return
     */
    @Override
    @PostMapping("delete-byidlist")
    public ResultDO<Void> deleteList(@RequestBody String[] numbers) {
        // 参数校验
        if (numbers == null || numbers.length == 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        List<String> resultList = new ArrayList<>(numbers.length);
        for (String s : numbers) {
            resultList.add(s);
        }
        ResultDO<Void> voidResultDO = customerService.deleteList(resultList);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DELETE_FAILD, ResultCode.MSG_DELETE_FAILD);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }

    }

    /**
     * 会员号搜索客户/员工
     *
     * @param number
     * @return
     */
    @Override
    @PostMapping("get-bynumber")
    public ResultDO<UserDO> getByNumber(@RequestBody String number) {
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

    /**
     * 客户编号搜索客户
     * 
     * @param customerId
     * @return
     */
    @Override
    @PostMapping("get-byId")
    public ResultDO<UserDO> getByCustomerId(long customerId) {
        // 参数校验
        if (customerId < 0) {
            return new ResultDO<UserDO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<UserDO> byNumber = customerService.getByCustomerId(customerId);
        if (byNumber.isSuccess() == false) {
            return new ResultDO<UserDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            UserDO byNumberModule = byNumber.getModule();
            return new ResultDO<UserDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, byNumberModule);
        }
    }

    @Override
    @PostMapping("check-time")
    public ResultDO<Boolean> checkMyRoom() {
        return null;
    }

    /**
     * 返回所有清洁部员工
     *
     * @return
     */
    @Override
    @PostMapping("get-cleanlist")
    public ResultDO<List<Long>> returnCleanStaffIdList() {
        List<Long> list = new ArrayList<>();

        // 返回所有清洁部人员
        ResultDO<List<UserDO>> staffByDepartmentId =
            staffService.getStaffByDepartmentId(DepartmentType.LOGISTICS);
        // 向所有清洁部发送
        for (int i = 0; i < staffByDepartmentId.getModule().size(); i++) {
            list.add(staffByDepartmentId.getModule().get(i).getId());
        }
        if (list.size() == 0) {
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        }
        return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
    }

}
