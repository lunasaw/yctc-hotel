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
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;
import com.altersoftware.hotel.service.StaffService;

/**
 * @author Iszychen@win10
 * @date 2020/2/6 17:22
 */
@ComponentScan({"com.altersoftware.hotel.dao"})
@Service("staffService")
public class StaffServiceImpl implements StaffService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Resource
    private UserDAO             userDAO;

    @Override
    public ResultDO<List<UserDO>> getStaffByDepartmentId(long departmentId) {
        List<UserDO> staffDOBydepartmentId = new ArrayList<>();
        try {
            staffDOBydepartmentId = userDAO.getStaffDOBydepartmentId(departmentId);
            LOG.info("getStaffByDepartmentId success, StafList={}", staffDOBydepartmentId);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, staffDOBydepartmentId);
        } catch (Exception e) {
            LOG.error("getStaffByDepartmentId error, departmentId={}", departmentId, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<List<UserDO>> getAllStaff() {
        List<UserDO> Staff = new ArrayList();
        try {
            Staff = userDAO.getStaff();
            LOG.info("getAllStaff success, customers={}", Staff);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, Staff);
        } catch (Exception e) {
            LOG.error("getAllStaff error, customers={}", Staff, e);
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
    public ResultDO<Void> deleteByList(List<String> numbers) {
        try {
            for (int i = 0; i < numbers.size(); i++) {
                userDAO.deleteByuserNumber(numbers.get(i));
            }
            LOG.info("deleteByList success, numbers={}", numbers);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("deleteByList error, numbers={}", numbers, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<UserDO> getByNumber(String number) {
        UserDO userDOByNumber = null;
        try {
            userDOByNumber = userDAO.getUserDOByNumber(number);
            LOG.info("getUserDOByNumber success, number={}", number);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, userDOByNumber);
        } catch (Exception e) {
            LOG.error("deleteByuserNumber error, number={}", number, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, userDOByNumber);
        }

    }

    @Override
    public ResultDO<List<UserDO>> getReception() {
        List<UserDO> userGetReception = null;
        try {
            userGetReception = userDAO.getReception();
            LOG.info("userGetReception success, userGetReception={}", userGetReception);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, userGetReception);
        } catch (Exception e) {
            LOG.error("userGetReception error, userGetReception={}", userGetReception, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, userGetReception);
        }
    }

    @Override
    public ResultDO<List<UserDO>> getClean() {
        List<UserDO> userGetClean = null;
        try {
            userGetClean = userDAO.getClean();
            LOG.info("userGetClean success, userGetClean={}", userGetClean);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, userGetClean);
        } catch (Exception e) {
            LOG.error("userGetClean error, userGetClean={}", userGetClean, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, userGetClean);
        }
    }

    @Override
    public ResultDO<List<UserDO>> getProcter() {
        List<UserDO> userGetProctect = null;
        try {
            userGetProctect = userDAO.getProctect();
            LOG.info("userGetProctect success, userGetProctect={}", userGetProctect);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, userGetProctect);
        } catch (Exception e) {
            LOG.error("userGetProctect error, userGetProctect={}", userGetProctect, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, userGetProctect);
        }
    }
}
