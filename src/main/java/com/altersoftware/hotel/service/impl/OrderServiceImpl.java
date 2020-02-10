package com.altersoftware.hotel.service.impl;

import java.text.NumberFormat;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.dao.MenuDAO;
import com.altersoftware.hotel.dao.OrderDAO;
import com.altersoftware.hotel.dao.VipDAO;
import com.altersoftware.hotel.dao.VipGradeDAO;
import com.altersoftware.hotel.entity.*;
import com.altersoftware.hotel.service.OrderService;

/**
 * @author Iszychen@win10
 * @date 2020/2/7 21:48
 */
@ComponentScan({"com.altersoftware.hotel.dao"})
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Resource
    private OrderDAO            orderDAO;

    @Resource
    private MenuDAO             menuDAO;

    @Resource
    private VipGradeDAO         vipGradeDAO;

    @Resource
    private VipDAO              vipDAO;

    @Override
    public ResultDO<Void> createOrder(OrderDO orderDO) {
        try {
            orderDAO.insert(orderDO);
            LOG.info("createOrder success, OrderDO={}", orderDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("createOrder error, OrderDO={}", orderDO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<OrderDO> showOrder(long id) {
        OrderDO orderDOById = null;
        try {
            orderDOById = orderDAO.getOrderDOById(id);
            LOG.info("showOrder success, id={}", id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, orderDOById);
        } catch (Exception e) {
            LOG.error("showOrder error, OrderDO={}", orderDOById, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<List<OrderDO>> showOrderByCustomerId(long customerId) {
        List<OrderDO> orderDOByCustomerId = null;
        try {
            orderDOByCustomerId = orderDAO.getOrderDOByCustomerId(customerId);
            LOG.info("showOrderBystaffId success, customerId={}", customerId);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, orderDOByCustomerId);
        } catch (Exception e) {
            LOG.error("showOrderBystaffId error, orderDOByCustomerId={}", orderDOByCustomerId, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<Void> updateOrder(OrderDO orderDO) {
        int update = orderDAO.update(orderDO);
        if (update == 1) {
            LOG.info("updateOrder success, orderDO={}", orderDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
        LOG.error("updateOrder error, orderDO={}", orderDO);
        return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
            ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
    }

    @Override
    public ResultDO<List<Long>> showOrderIdList() {
        List<Long> OrderIdList = null;
        try {
            OrderIdList = orderDAO.getOrderIdList();
            LOG.info("showOrderByRoomNumber success, roomNumber={}", OrderIdList);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, OrderIdList);
        } catch (Exception e) {
            LOG.error("showOrderByRoomNumber error, List<Long>={}", OrderIdList, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<Void> deleteById(long id) {
        try {
            orderDAO.deleteById(id);
            LOG.info("deleteById success, id={}", id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("deleteById error, id={}", id, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<List<OrderDO>> getAll() {
        List<OrderDO> all = null;
        try {
            all = orderDAO.getOrderDOList();
            LOG.info("getAll success, all={}", all);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("getAll error, all={}", all, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<Double> getActualMoney(long customerId) {
        VipDO vipDOById = null;
        double actualMoney = 0.0;
        try {
            vipDOById = vipDAO.getVipDOByCustomerId(customerId);
            if (vipDOById != null) {
                LOG.info("getVipDOById success, vipDOById={}", vipDOById);
                String grade = vipDOById.getGrade();
                VipGradeDO vipGradeDOByGrade = null;
                vipGradeDOByGrade = vipGradeDAO.getVipGradeDOByGrade(grade);
                if (vipGradeDOByGrade != null) {
                    LOG.info("getVipGradeDOByGrade success, VipGradeDO={}", vipGradeDOByGrade);
                    Double discount = vipGradeDOByGrade.getDiscount();
                    List<OrderDO> orderDOByCustomerId = orderDAO.getOrderDOByCustomerId(customerId);
                    for (int i = 0; i < orderDOByCustomerId.size(); i++) {
                        long menuId = orderDOByCustomerId.get(i).getMenuId();
                        MenuDO menuDOById = menuDAO.getMenuDOById(menuId);
                        int numbers = orderDOByCustomerId.get(i).getNumbers();
                        Double price = menuDOById.getPrice();
                        actualMoney += price * numbers;
                    }
                }
            }
            NumberFormat nf = NumberFormat.getNumberInstance();
            nf.setMaximumFractionDigits(2);
            actualMoney = Double.parseDouble(nf.format(actualMoney));
        } catch (Exception e) {
            LOG.error("getActualMoney error, customerId={}, roomNumber={}", customerId, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
        LOG.info("getActualMoney success, money={}", actualMoney);
        return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, actualMoney);
    }
}
