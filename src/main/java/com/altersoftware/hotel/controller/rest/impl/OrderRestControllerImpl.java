package com.altersoftware.hotel.controller.rest.impl;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.controller.rest.OrderRestController;
import com.altersoftware.hotel.entity.OrderDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.vo.OrderVO;

/**
 * @author Iszychen@win10
 * @date 2020/2/10 22:55
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/order")
public class OrderRestControllerImpl implements OrderRestController {

    @Override
    @PostMapping("add-order")
    public ResultDO<Void> createOrder(OrderVO orderVO) {
        return null;
    }

    @Override
    @PostMapping("get-byid")
    public ResultDO<OrderDO> showOrder(long id) {
        return null;
    }

    @Override
    @PostMapping("get-listbycustomerid")
    public ResultDO<List<OrderDO>> showOrderByCustomerId(long customerId) {
        return null;
    }

    @Override
    @PostMapping("update")
    public ResultDO<Void> updateOrder(OrderDO orderDO) {
        return null;
    }

    @Override
    @PostMapping("get-idlist")
    public ResultDO<List<Long>> showOrderIdList() {
        return null;
    }

    @Override
    @PostMapping("delete-byid")
    public ResultDO<Void> deleteById(long id) {
        return null;
    }

    @Override
    @PostMapping("get-list")
    public ResultDO<List<OrderDO>> getAll() {
        return null;
    }
}
