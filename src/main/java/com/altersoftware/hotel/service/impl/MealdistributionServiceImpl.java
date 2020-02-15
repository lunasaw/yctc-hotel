package com.altersoftware.hotel.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.dao.MealdistributionDAO;
import com.altersoftware.hotel.entity.MealdistributionDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.MealdistributionService;

/**
 * @author Iszychen@win10
 * @date 2020/2/14 19:14
 */
@ComponentScan({"com.altersoftware.hotel.dao"})
@Service("mealService")
public class MealdistributionServiceImpl implements MealdistributionService {
    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Resource
    private MealdistributionDAO mealdistributionDAO;

    @Override
    public ResultDO<Void> createMealdistribution(MealdistributionDO mealdistributionDO) {
        try {
            mealdistributionDAO.insert(mealdistributionDO);
            LOG.info("createMealdistribution success, MealdistributionDO={}", mealdistributionDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("createMealdistribution error, MealdistributionDO={}", mealdistributionDO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<MealdistributionDO> showMealdistribution(long id) {
        MealdistributionDO mealdistributionDOById = null;
        try {
            mealdistributionDOById = mealdistributionDAO.getMealdistributionDOById(id);
            LOG.info("showMealdistribution success, mealdistributionDOById={}", mealdistributionDOById);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, mealdistributionDOById);
        } catch (Exception e) {
            LOG.error("showMealdistribution error, id={}", id, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<MealdistributionDO> showMealdistributionByOrder(long order) {
        MealdistributionDO mealdistributionDOByOrderId = null;
        try {
            mealdistributionDOByOrderId = mealdistributionDAO.getMealdistributionDOByOrderId(order);
            LOG.info("showMealdistributionByOrder success, mealdistributionDOById={}", mealdistributionDOByOrderId);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, mealdistributionDOByOrderId);
        } catch (Exception e) {
            LOG.error("showMealdistributionByOrder error, order={}", order, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<Void> updateMealdistribution(MealdistributionDO mealdistributionDO) {
        int update = mealdistributionDAO.update(mealdistributionDO);
        if (update == 1) {
            LOG.info("updateMealdistribution success, mealdistributionDO={}", mealdistributionDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
        LOG.error("updateMealdistribution error, mealdistributionDO={}", mealdistributionDO);
        return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
            ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
    }

    @Override
    public ResultDO<Void> deleteById(long id) {
        try {
            mealdistributionDAO.deleteById(id);
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
                mealdistributionDAO.deleteById(ids.get(i));
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
    public ResultDO<List<MealdistributionDO>> getAll() {
        List<MealdistributionDO> all = null;
        try {
            all = mealdistributionDAO.getMealList();
            LOG.info("getAll success, all={}", all);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, all);
        } catch (Exception e) {
            LOG.error("getAll error, all={}", all, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<List<MealdistributionDO>> getListByStaffId(long staffId) {
        List<MealdistributionDO> getListByStaffId = null;
        try {
            getListByStaffId = mealdistributionDAO.getMealdistributionDOByStaffId(staffId);
            LOG.info("getListByStaffId success, all={}", getListByStaffId);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, getListByStaffId);
        } catch (Exception e) {
            LOG.error("getListByStaffId error, all={}", getListByStaffId, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<List<MealdistributionDO>> getListByRoom(long roomId) {
        List<MealdistributionDO> getListByRoomId = null;
        try {
            getListByRoomId = mealdistributionDAO.getMealdistributionDOByRoomId(roomId);
            LOG.info("getListByRoom success, getListByRoomId={}", getListByRoomId);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, getListByRoomId);
        } catch (Exception e) {
            LOG.error("getListByRoom error, roomId={}", roomId, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<MealdistributionDO> getNow(long staffId) {
        List<MealdistributionDO> getListByStaffId = null;
        try {
            Date outTime = null;
            Date inTime = null;
            MealdistributionDO mealdistributionDO = null;
            getListByStaffId = mealdistributionDAO.getMealdistributionDOByStaffId(staffId);
            for (int i = 0; i < getListByStaffId.size(); i++) {
                mealdistributionDO = getListByStaffId.get(i);
                // 获取完成时间
                outTime = mealdistributionDO.getOutTime();
                // 获取送出时间
                inTime = mealdistributionDO.getInTime();
                Date now = new Date();
                if (outTime == null && inTime.before(now)) {
                    // 订单没有送达时间和开始配送时间都在当前时间之前
                    LOG.info("find MealdistributionDO  success, mealdistributionDO={},intime={}", mealdistributionDO,
                        inTime);
                    break;
                }
            }
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, mealdistributionDO);
        } catch (Exception e) {
            LOG.error("find MealdistributionDO error, staffId={}", staffId, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<Void> end(long id) {
        try {
            int end = mealdistributionDAO.end(id);
            if (end != 1) {
                LOG.info(" MealdistributionDO over error, id={} ", id);
            }
            LOG.info(" MealdistributionDO over success, id={} ", id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("MealdistributionDO over error, id={}", id, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<Void> start(long id) {
        try {
            int start = mealdistributionDAO.start(id);
            if (start != 1) {
                LOG.info(" MealdistributionDO start error, id={}", id, id);
            }
            LOG.info(" MealdistributionDO start success, id={}", id, id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("MealdistributionDO start error, id={}", id, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }
}
