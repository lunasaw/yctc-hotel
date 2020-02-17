package com.altersoftware.hotel.controller.rest.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.constant.entity.department.DepartmentType;
import com.altersoftware.hotel.controller.rest.OrderRestController;
import com.altersoftware.hotel.entity.*;
import com.altersoftware.hotel.service.*;
import com.altersoftware.hotel.vo.OrderVO;

/**
 * @author Iszychen@win10
 * @date 2020/2/14 19:14
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/order")
public class OrderRestControllerImpl implements OrderRestController {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Autowired
    MenuService                 menuService;

    @Autowired
    OrderService                orderService;

    @Resource
    MealdistributionService     mealdistributionService;

    @Resource
    RecordService               recordService;

    @Resource
    StaffService                staffService;

    /**
     *
     * @param orderVO
     * @return
     */
    @Override
    @PostMapping("add-order")
    public ResultDO<RecordDO> createOrder(@RequestBody List<OrderVO> orderVO) {
        System.out.println(orderVO);
        long customerId = orderVO.get(0).getCustomerId();

        // 参数校验
        if (orderVO.size() <= 0 || customerId <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        long staffId = 0;
        for (int i = 0; i < orderVO.size(); i++) {
            ResultDO<Long> order = orderService.createOrder(orderVO.get(i));
            Long orderModule = order.getModule();
            if (order.isSuccess()) {
                // 生成配送订单
                MealdistributionDO mealdistributionDO = new MealdistributionDO();
                mealdistributionDO.setRoomNumber(orderVO.get(i).getRoomNumber());
                UserDO userDO = returnOneMealStaff(orderVO.get(i).getRoomNumber());
                staffId = userDO.getId();
                mealdistributionDO.setStaffId(userDO.getId());
                mealdistributionDO.setOrderId(orderModule);
                mealdistributionService.createMealdistribution(mealdistributionDO);
                // TODO 这里需要给该员工发送配送信息
                // 设置支付金额
                orderService.changeMenuMoneyPay(orderModule, orderVO.get(i).getNumbers(), orderVO.get(i).getMenuId());
            }
        }
        LOG.info("createOrder success, orderVO={}", orderVO);
        // // 拿到订购的菜品
        // ResultDO<Double> actualMoney = orderService.getActualMoney(customerId);
        double x;// 支付总金额
        x = orderService.allOnceMoney(customerId);
        RecordDO recordDO = new RecordDO();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String appId = format.format(date);
        recordDO.setId(Long.parseLong(appId));
        recordDO.setCustomerId(customerId);
        recordDO.setRoomNumber(orderVO.get(0).getRoomNumber());
        if (staffId == 0) {
            LOG.info("createOrder error, staffId={}", staffId);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        recordDO.setStaffId(staffId);
        recordDO.setPayMoney(x);
        ResultDO<Void> record = recordService.createRecord(recordDO);
        if (record.isSuccess() == false) {
            LOG.info("createOrder error, recordDO={}", recordDO);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        LOG.info("createOrder success, recordDO={}", recordDO);
        return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, recordDO);
    }

    /**
     * 返回一个当前时间未派送员工
     *
     * @return
     */
    public UserDO returnOneMealStaff(int roomNmber) {
        UserDO staffDO = null;
        boolean tag = true;

        // 返回一个前台餐饮部门未送菜的员工
        Date date = new Date();
        // 返回所有餐饮部人员
        ResultDO<List<UserDO>> staffByDepartmentId =
            staffService.getStaffByDepartmentId(DepartmentType.FOOD_AND_BEVERAGE_DEPARTMENT);
        // 遍历
        for (int i = 0; i < staffByDepartmentId.getModule().size(); i++) {
            // 获取其中一人
            UserDO userDO = staffByDepartmentId.getModule().get(i);
            // 获取他的配送订单
            ResultDO<List<MealdistributionDO>> listByStaffId = mealdistributionService.getListByStaffId(userDO.getId());
            // 遍历他的订单
            for (int i1 = 0; i1 < listByStaffId.getModule().size(); i1++) {
                List<MealdistributionDO> module = listByStaffId.getModule();
                // 订单所有送餐完成时间在今天之前, 并且当前没有送餐
                MealdistributionDO mealDO = module.get(i);
                if ((mealDO.getRoomNumber() == roomNmber && mealDO.getInTime() == null)
                    || mealDO.getOutTime().before(date)) {
                    continue;
                } else {
                    tag = false;
                }
            }
            if (tag = true) {
                staffDO = userDO;
            } else {
                continue;
            }
        }
        return staffDO;
    }

    /**
     * 展示菜品订单信息
     *
     * @param id
     */
    @Override
    @PostMapping("get-byid")
    public ResultDO<OrderDO> showOrder(@RequestBody long id) {
        // 参数校验
        if (id <= 0) {
            return new ResultDO<OrderDO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<OrderDO> orderDOResultDO = orderService.showOrder(id);
        if (orderDOResultDO.isSuccess() == false) {
            return new ResultDO<OrderDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<OrderDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, orderDOResultDO.getModule());
        }
    }

    /**
     * 根据客户编号查询菜品订单信息List
     *
     * @param customerId
     */
    @Override
    @PostMapping("get-listbycustomerid")
    public ResultDO<List<OrderDO>> showOrderByCustomerId(@RequestParam(name = "customerId") long customerId) {
        // 参数校验
        if (customerId <= 0) {
            return new ResultDO<List<OrderDO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<List<OrderDO>> listResultDO = orderService.showOrderByCustomerId(customerId);
        if (listResultDO.isSuccess() == false) {
            return new ResultDO<List<OrderDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<List<OrderDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
                listResultDO.getModule());
        }
    }

    /**
     * 修改菜品订单信息
     *
     * @param orderDO
     */
    @Override
    @PostMapping("update")
    public ResultDO<Void> updateOrder(@RequestBody OrderDO orderDO) {
        // 参数校验
        if (orderDO.getNumbers() <= 0 || orderDO.getCustomerId() <= 0 || orderDO.getPayMoney() <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<OrderDO> orderDOResultDO = orderService.showOrder(orderDO.getId());
        if (orderDOResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            OrderDO doResultDOModule = orderDOResultDO.getModule();
            doResultDOModule.setId(orderDO.getId());
            doResultDOModule.setCustomerId(orderDO.getCustomerId());
            doResultDOModule.setNumbers(orderDO.getNumbers());
            doResultDOModule.setMenuId(orderDO.getMenuId());
            doResultDOModule.setPayMoney(orderDO.getPayMoney());
            doResultDOModule.setState(orderDO.getState());

            ResultDO<Void> voidResultDO = orderService.updateOrder(doResultDOModule);
            if (voidResultDO.isSuccess() == false) {
                return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            } else {
                return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, voidResultDO.getModule());
            }
        }
    }

    /**
     * 返回所有订单编号
     *
     *
     */
    @Override
    @PostMapping("get-idlist")
    public ResultDO<List<Long>> showOrderIdList() {
        ResultDO<List<Long>> listResultDO = orderService.showOrderIdList();
        if (listResultDO.isSuccess() == false) {
            return new ResultDO<List<Long>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<List<Long>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, listResultDO.getModule());
        }
    }

    /**
     * 删除菜品订单信息
     *
     * @return
     */
    @Override
    @PostMapping("delete-byid")
    public ResultDO<Void> deleteById(@RequestBody long id) {
        // 参数校验
        if (id <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<Void> voidResultDO = orderService.deleteById(id);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    @Override
    @GetMapping("delete-statezero")
    public ResultDO<Void> deleteStateZero() {
        ResultDO<List<Long>> listResultDO = orderService.showOrderIdList();
        for (int i = 0; i < listResultDO.getModule().size(); i++) {
            List<Long> module = listResultDO.getModule();
            ResultDO<OrderDO> orderDOResultDO = orderService.showOrder(module.get(i));
            if (orderDOResultDO.getModule().getState() == 0) {
                mealdistributionService.deleteByOrder(orderDOResultDO.getModule().getId());
            }
        }
        ResultDO<Void> voidResultDO = orderService.deleteList();
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
        ResultDO<Void> voidResultDO = orderService.deleteList(resultList);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    /**
     * 查询所有菜品订单信息
     *
     * @return
     */
    @Override
    @PostMapping("get-list")
    public ResultDO<List<OrderDO>> getAll() {
        ResultDO<List<OrderDO>> orderServiceAll = orderService.getAll();
        if (orderServiceAll.isSuccess() == false) {
            return new ResultDO<List<OrderDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<List<OrderDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
                orderServiceAll.getModule());
        }
    }
}
