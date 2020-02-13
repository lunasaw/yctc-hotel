package com.altersoftware.hotel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.dao.VipGradeDAO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.VipGradeDO;
import com.altersoftware.hotel.service.VipGradeService;

/**
 * @author Iszychen@win10
 * @date 2020/2/6 18:20
 */
@ComponentScan({"com.altersoftware.hotel.dao"})
@Service("vipGradeService")
public class VipGradeServiceImpl implements VipGradeService {
    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Resource
    private VipGradeDAO         vipGradeDAO;

    @Override
    public ResultDO<Void> insert(VipGradeDO vipGradeDO) {
        try {
            vipGradeDAO.insert(vipGradeDO);
            LOG.info("insert success, vipGradeDO={}", vipGradeDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("insert error, vipGradeDO={}", vipGradeDO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<VipGradeDO> showVipGrade(long id) {
        try {
            VipGradeDO vipGradeDOById = vipGradeDAO.getVipGradeDOById(id);
            LOG.info("getVipGradeDOById success, vipGradeDOById={}", vipGradeDOById);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, vipGradeDOById);
        } catch (Exception e) {
            LOG.error("getVipGradeDOById error, id={}", id, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<Void> updateVipGrade(VipGradeDO vipGradeDO) {
        int update = vipGradeDAO.update(vipGradeDO);
        if (update == 1) {
            LOG.info("updatevipGrade success, vipGradeDO={}", vipGradeDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } else {
            LOG.error("getVipGradeDOById error, vipGradeDO={}", vipGradeDO);
            return new ResultDO<>(false, ResultCode.UPDATE_FAILD,
                ResultCode.MSG_UPDATE_FAILD);
        }
    }

    @Override
    public ResultDO<List<VipGradeDO>> showVipGradeByGrade(String grade) {
        try {
            List<VipGradeDO> showVipGradeByGrade = vipGradeDAO.getVipIdList(grade);
            LOG.info("getVipGradeDOByRoomId success, vipGradeDO={}", showVipGradeByGrade);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, showVipGradeByGrade);
        } catch (Exception e) {
            LOG.error("showVipGradeByGrade error, grade={}", grade, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<List<VipGradeDO>> showVipGradeList() {
        List<VipGradeDO> showVipGradeList = null;
        try {
            showVipGradeList = vipGradeDAO.getVipGradeList();
            LOG.info("getVipGradeDOByRoomId success, showVipGradeList={}", showVipGradeList);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, showVipGradeList);
        } catch (Exception e) {
            LOG.error("showVipGradeByGrade error, showVipGradeList={}", showVipGradeList, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<Void> deleteById(long id) {
        try {
            vipGradeDAO.deleteById(id);
            LOG.info("deleteById success, id={}", id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("deleteById error, id={}", id, e);
            return new ResultDO<>(false, ResultCode.DELETE_FAILD,
                ResultCode.MSG_DELETE_FAILD);
        }
    }

    @Override
    public ResultDO<Void> deleteList(List<Long> ids) {
        try {
            for (int i = 0; i < ids.size(); i++) {
                vipGradeDAO.deleteById(ids.get(i));
            }
            LOG.info("deleteList success, ids={}", ids);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("deleteList error, ids={}", ids, e);
            return new ResultDO<>(false, ResultCode.DELETE_FAILD,
                ResultCode.MSG_DELETE_FAILD);
        }
    }

}
