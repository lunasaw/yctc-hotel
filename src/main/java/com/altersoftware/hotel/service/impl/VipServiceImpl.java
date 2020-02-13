package com.altersoftware.hotel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.dao.VipDAO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.VipDO;
import com.altersoftware.hotel.service.VipService;

/**
 * @author Iszychen@win10
 * @date 2020/2/4 15:18
 */
@ComponentScan({"com.altersoftware.hotel.dao"})
@Service("vipService")
public class VipServiceImpl implements VipService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Resource
    private VipDAO              vipDAO;

    @Override
    public ResultDO<Void> insert(VipDO vipDO) {
        try {
            vipDAO.insert(vipDO);
            LOG.info("insert success, vipDO={}", vipDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("insert error, vipDO={}", vipDO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<VipDO> showVip(long id) {
        try {
            VipDO vipDOById = vipDAO.getVipDOById(id);
            LOG.info("getVipDOById success, id={}", id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, vipDOById);
        } catch (Exception e) {
            LOG.error("getVipDOById error, id={}", id, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<Void> updateVip(VipDO vipDO) {
        int update = vipDAO.update(vipDO);
        if (update == 1) {
            LOG.info("updateVip success, vipDO={}", vipDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } else {
            LOG.error("updateVip error, vipDO={}", vipDO);
            return new ResultDO<>(false, ResultCode.UPDATE_FAILD,
                ResultCode.MSG_UPDATE_FAILD);
        }
    }

    @Override
    public ResultDO<List<VipDO>> showVipList() {
        try {
            List<VipDO> vipDOByRoomId = vipDAO.getVipDOList();
            LOG.info("getVipDOByRoomId success, vipDO={}", vipDOByRoomId);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, vipDOByRoomId);
        } catch (Exception e) {
            LOG.error("getVipDOByRoomId error ", e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<Void> deleteById(String id) {
        long Id = Long.parseLong(id);
        try {
            vipDAO.deleteById(Id);
            LOG.info("deleteById success, vipDO={}", id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("deleteById error, goodsId={}", id, e);
            return new ResultDO<>(false, ResultCode.DELETE_FAILD,
                ResultCode.MSG_DELETE_FAILD);
        }
    }

    @Override
    public ResultDO<Void> deleteList(List<String> ids) {
        try {
            for (int i = 0; i < ids.size(); i++) {
                long l = Long.parseLong(ids.get(i));
                vipDAO.deleteById(l);
            }
            LOG.info("deleteList success, ids={}", ids);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("deleteList error, ids={}", ids, e);
            return new ResultDO<>(false, ResultCode.DELETE_FAILD,
                ResultCode.MSG_DELETE_FAILD);
        }
    }

    @Override
    public ResultDO<List<Long>> getAllNumberList() {
        try {
            List<Long> all = vipDAO.getVipIdList();
            LOG.info("getAll success, vipDO list={}", all);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("getAll error", e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }
}
