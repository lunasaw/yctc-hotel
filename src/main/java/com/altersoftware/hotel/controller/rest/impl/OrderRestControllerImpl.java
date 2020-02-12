package com.altersoftware.hotel.controller.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.controller.rest.OrderRestController;
import com.altersoftware.hotel.entity.OrderDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.MenuService;
import com.altersoftware.hotel.service.OrderService;
import com.altersoftware.hotel.util.RandomNumber;
import com.altersoftware.hotel.vo.OrderVO;

/**
 * @author hzx
 * @date 2020/2/10 22:55
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/order")
public class OrderRestControllerImpl implements OrderRestController {
    @Autowired
    MenuService menuService;

    @Autowired
    OrderService orderService;

    @Override
    @PostMapping("add-order")
    public ResultDO<Void> createOrder(@RequestBody OrderVO orderVO) {
        //生成随机数
        RandomNumber menuOrder = new RandomNumber();
        //参数校验
        if (orderVO.getNumbers() <= 0 || orderVO.getCustomerId() <= 0){
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        //还要补充
        ResultDO<Double> actualMoney = orderService.getActualMoney(orderVO.getCustomerId());
        OrderDO orderDO = new OrderDO();
        orderDO.setNumbers(orderVO.getNumbers());
        orderDO.setCustomerId(orderVO.getCustomerId());
        orderDO.setId(Long.parseLong(menuOrder.GetRandomOrder()));
        orderDO.setPayMoney(actualMoney.getModule());
        orderDO.setMenuId(orderVO.getMenuId());
        ResultDO<Void> orderServiceOrder = orderService.createOrder(orderDO);

        if (orderServiceOrder.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    /**
     * 展示菜品订单信息
     *
     * @param id
     */
    @Override
    @PostMapping("get-byid")
    public ResultDO<OrderDO> showOrder(long id) {
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
            return new ResultDO<OrderDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,orderDOResultDO.getModule());
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
            return new ResultDO<List<OrderDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,listResultDO.getModule());
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
        //参数校验
        if (orderDO.getNumbers() <= 0 || orderDO.getCustomerId() <= 0 || orderDO.getPayMoney() <= 0){
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
                return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,voidResultDO.getModule());
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
            return new ResultDO<List<Long>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,listResultDO.getModule());
        }
    }

    /**
     * 删除菜品订单信息
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

        ResultDO<Void> voidResultDO = orderService.deleteById(id);
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
            return new ResultDO<List<OrderDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,orderServiceAll.getModule());
        }
    }
}
