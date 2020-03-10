package com.altersoftware.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.dao.UserDAO;
import com.altersoftware.hotel.dao.VipDAO;
import com.altersoftware.hotel.dao.VipGradeDAO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;
import com.altersoftware.hotel.entity.VipDO;
import com.altersoftware.hotel.service.CustomerService;

/**
 * @author czy@win10
 * @date 2020/1/30 20:40
 */
@ComponentScan({"com.altersoftware.hotel.dao"})
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Resource
    private UserDAO             userDAO;

    @Resource
    private VipDAO              vipDAO;

    @Resource
    private VipGradeDAO         vipGradeDAO;

    @Override
    public ResultDO<List<UserDO>> getAllCustomer() {
        List<UserDO> customer = new ArrayList();
        try {
            customer = userDAO.getCustomer();
            LOG.info("getcustomers success, customers={}", customer);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, customer);
        } catch (Exception e) {
            LOG.error("getcustomers error, customers={}", customer, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<Void> updateUserDO(UserDO userDO) {
        try {
            int update = userDAO.update(userDO);
            if (update == 1) {
                LOG.info("updateuserDO success, userDO={}", userDO);
                return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
            } else {
                LOG.info("updateuserDO woring, userDO={}", userDO);
                return new ResultDO<>(false, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
            }
        } catch (Exception e) {
            LOG.error("updateuserDO error, userDO={}", userDO, e);
            return new ResultDO<>(false, ResultCode.UPDATE_FAILD,
                ResultCode.MSG_UPDATE_FAILD);
        }
    }

    @Override
    public ResultDO<Void> deleteByUserId(String number) {
        try {
            userDAO.deleteByuserNumber(number);
            LOG.info("deleteByuserNumber success, number={}", number);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("deleteByuserNumber error, number={}", number, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<Void> deleteList(List<String> numbers) {
        try {
            for (int i = 0; i < numbers.size(); i++) {
                userDAO.deleteByuserNumber(numbers.get(i));
            }
            LOG.info("deleteByuserNumber success, numbers={}", numbers);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("deleteByuserNumber error, numbers={}", numbers, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<UserDO> getByNumber(String number) {
        UserDO userDOByNumber = null;
        try {
            userDOByNumber = userDAO.getUserDOByNumber(number);
            if (userDOByNumber == null) {
                LOG.info("getByNumber error, number={}", number);
                return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            }
            LOG.info("getUserDOByNumber success, number={}", userDOByNumber);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, userDOByNumber);
        } catch (Exception e) {
            LOG.error("deleteByuserNumber error, number={}", number, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, userDOByNumber);
        }

    }

    @Override
    public ResultDO<UserDO> getByCustomerId(long customerId) {
        UserDO userDOByNumber = null;
        try {
            userDOByNumber = userDAO.getUserDOById(customerId);
            if (userDOByNumber == null) {
                LOG.info("getByCustomerId error, customerId={}", customerId);
                return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            }
            LOG.info("getByCustomerId success, userDOByNumber={}", userDOByNumber);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, userDOByNumber);
        } catch (Exception e) {
            LOG.error("getByCustomerId error, customerId={}", customerId, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, userDOByNumber);
        }
    }

    @Override
    public ResultDO<Void> insertVipDO(long custoemrId) {
        VipDO vipDOByCustomerId = vipDAO.getVipDOByCustomerId(custoemrId);
        if (vipDOByCustomerId == null) {
            try {
                UserDO userDOById = userDAO.getUserDOById(custoemrId);
                VipDO vipDO = new VipDO();
                vipDO.setCustomerNumber(custoemrId);
                vipDO.setGrade("星会员");
                vipDO.setId(Long.parseLong(userDOById.getNumber()));
                vipDO.setAmount(0);
                vipDAO.insert(vipDO);
                LOG.info("insertVipDO success, custoemrId={}", custoemrId);
                return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
            } catch (NumberFormatException e) {
                LOG.info("insertVipDO error, custoemrId={}", custoemrId);
                return new ResultDO<>(false, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
            }
        } else {
            LOG.info("insertVipDO success, custoemrId={}", custoemrId);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }
}
