package com.altersoftware.hotel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.dao.LeaseDAO;
import com.altersoftware.hotel.entity.LeaseDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.LeaseService;

/**
 * @author Iszychen@win10
 * @date 2020/2/21 22:57
 */
@ComponentScan({"com.altersoftware.hotel.dao"})
@Service("leaseService")
public class LeaseServiceImpl implements LeaseService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Resource
    private LeaseDAO            leaseDAO;

    @Override
    public ResultDO<Void> insert(LeaseDO leaseDO) {
        try {
            leaseDAO.insert(leaseDO);
            LOG.info("insert success, leaseDO={}", leaseDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("insert error, leaseDO={}", leaseDO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<LeaseDO> showLease(long id) {
        try {
            LeaseDO leaseDOById = leaseDAO.getLeaseDOById(id);
            LOG.info("getLeaseDOById success, leaseDOById={}", leaseDOById);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, leaseDOById);
        } catch (Exception e) {
            LOG.error("getLeaseDOById error, id={}", id, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<Void> updateLease(LeaseDO leaseDO) {
        int update = leaseDAO.update(leaseDO);
        if (update == 1) {
            LOG.info("updateLease success, leaseDO={}", leaseDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } else {
            LOG.error("getLeaseDOById error, leaseDO={}", leaseDO);
            return new ResultDO<>(false, ResultCode.UPDATE_FAILD,
                ResultCode.MSG_UPDATE_FAILD);
        }
    }

    @Override
    public ResultDO<List<LeaseDO>> showLeaseByCustomerId(long customerId) {
        try {
            List<LeaseDO> leaseDOByRoomId = leaseDAO.getLeaseDOByCustomerId(customerId);
            LOG.info("showLeaseByCustomerId success, leaseDO={}", leaseDOByRoomId);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, leaseDOByRoomId);
        } catch (Exception e) {
            LOG.error("showLeaseByCustomerId error, customerId={}", customerId, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<Void> deleteById(long id) {
        try {
            leaseDAO.deleteById(id);
            LOG.info("deleteById success, leaseDO={}", id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("deleteById error, leaseId={}", id, e);
            return new ResultDO<>(false, ResultCode.DELETE_FAILD,
                ResultCode.MSG_DELETE_FAILD);
        }
    }

    @Override
    public ResultDO<Void> deleteList(List<Long> ids) {
        try {
            for (int i = 0; i < ids.size(); i++) {
                leaseDAO.deleteById(ids.get(i));
            }
            LOG.info("deleteList success, leaseDO={}", ids);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("deleteList error, leaseId={}", ids, e);
            return new ResultDO<>(false, ResultCode.DELETE_FAILD,
                ResultCode.MSG_DELETE_FAILD);
        }
    }

    @Override
    public ResultDO<List<LeaseDO>> getAll() {
        try {
            List<LeaseDO> all = leaseDAO.getLeaseList();
            LOG.info("getAll success, leaseDO list={}", all);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, all);
        } catch (Exception e) {
            LOG.error("getAll error", e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }
}
