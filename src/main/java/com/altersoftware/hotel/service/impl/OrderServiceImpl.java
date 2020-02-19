package com.altersoftware.hotel.service.impl;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.altersoftware.hotel.util.RandomNumber;
import com.altersoftware.hotel.vo.OrderVO;

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
    public ResultDO<Long> createOrder(OrderVO orderVO) {
        try {
            long customerId = orderVO.getCustomerId();
            int numbers = orderVO.getNumbers();
            long menuId = orderVO.getMenuId();
            // 生成随机数
            RandomNumber menuOrder = new RandomNumber();
            String s = menuOrder.GetRandomOrder();
            long l = Long.parseLong(s);
            OrderDO orderDO = new OrderDO(l, menuId, numbers, customerId);
            // 生成订单存入数据库
            orderDAO.insert(orderDO);
            LOG.info("createOrder success, OrderDO={}", orderDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, orderDO.getId());
        } catch (Exception e) {
            LOG.error("createOrder error, orderVO={}", orderVO, e);
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
            List<OrderDO> list = new ArrayList<>();
            orderDOByCustomerId = orderDAO.getOrderDOByCustomerId(customerId);
            for (int i = 0; i < orderDOByCustomerId.size(); i++) {
                if (orderDOByCustomerId.get(i).getState() == 1) {
                    list.add(orderDOByCustomerId.get(i));
                }
            }
            LOG.info("showOrderBystaffId success, customerId={},list={}", list, customerId);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
        } catch (Exception e) {
            LOG.error("showOrderBystaffId error, customerId={}", customerId, e);
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
    public ResultDO<Void> deleteList(List<Long> ids) {
        try {
            for (int i = 0; i < ids.size(); i++) {
                orderDAO.deleteById(ids.get(i));
            }
            LOG.info("deleteList success, ids={}", ids);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("deleteList error, ids={}", ids, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<Void> deleteList() {
        try {
            orderDAO.deleteStateZero();
            LOG.info("deleteStateZero success");
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("deleteStateZero error, e");
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
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, all);
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

    @Override
    public ResultDO<Void> changeMenuMoneyPay(long orderId, int number, long menuId) {
        try {
            MenuDO menuDOById = menuDAO.getMenuDOById(menuId);
            Double price = menuDOById.getPrice();
            OrderDO orderDOById = orderDAO.getOrderDOById(orderId);
            orderDOById.setPayMoney(price * number);
            int update = orderDAO.update(orderDOById);
            if (update == 1) {
                LOG.info("changeMenuMoneyPay success, orderId={},menuId={},numbers={}", orderId, menuId, number);
            }
            return new ResultDO<>(true, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        } catch (Exception e) {
            LOG.info("changeMenuMoneyPay success, orderId={},menuId={},numbers={}", orderId, menuId, number);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    @Override
    public Double allOnceMoney(long customerId) {
        List<OrderDO> orderDOByCustomerId = orderDAO.getOrderDOByCustomerId(customerId);
        Date date = new Date();
        double x = 0;
        for (int i = 0; i < orderDOByCustomerId.size(); i++) {
            OrderDO orderDO = orderDOByCustomerId.get(i);
            if (orderDO.getState() == 1) {
                continue;
            } else {
                x += orderDO.getPayMoney();
            }
        }
        return x;
    }

    /**
     * 获取当前时间前1分钟
     * 
     * @param
     * @return
     */
    public Date getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar beforeTime = Calendar.getInstance();
        beforeTime.add(Calendar.MINUTE, -1);// 支付宝支付限定时间为9
        Date beforeD = beforeTime.getTime();
        System.out.println(beforeD + "===================================================>");
        return beforeD;
    }
}
