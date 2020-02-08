package com.altersoftware.hotel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.dao.RecordDAO;
import com.altersoftware.hotel.entity.RecordDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.RecordService;

/**
 * @author Iszychen@win10
 * @date 2020/2/7 21:48
 */
@ComponentScan({"com.altersoftware.hotel.dao"})
@Service("recordService")
public class RecordServiceImpl implements RecordService {
    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Resource
    private RecordDAO           recordDAO;

    @Override
    public ResultDO<Void> createRecord(RecordDO recordDO) {
        try {
            recordDAO.insert(recordDO);
            LOG.info("createRecord success, RecordDO={}", recordDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("createRecord error, RecordDO={}", recordDO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<RecordDO> showRecord(long id) {
        RecordDO recordDOById = null;
        try {
            recordDOById = recordDAO.getRecordDOById(id);
            LOG.info("showRecord success, id={}", id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, recordDOById);
        } catch (Exception e) {
            LOG.error("showRecord error, RecordDO={}", recordDOById, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<List<RecordDO>> showRecordBystaffId(long staffId) {
        List<RecordDO> recordDOByStaffId = null;
        try {
            recordDOByStaffId = recordDAO.getRecordDOByStaffId(staffId);
            LOG.info("showRecordBystaffId success, staffId={}", staffId);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, recordDOByStaffId);
        } catch (Exception e) {
            LOG.error("showRecordBystaffId error, recordDOByStaffId={}", recordDOByStaffId, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<Void> updateRecord(RecordDO recordDO) {
        int update = recordDAO.update(recordDO);
        if (update == 1) {
            LOG.info("updateRecord success, recordDO={}", recordDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
        LOG.error("updateRecord error, recordDO={}", recordDO);
        return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
            ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
    }

    @Override
    public ResultDO<List<RecordDO>> showRecordByRoomNumber(int roomNumber) {
        List<RecordDO> recordDOByRoomNumber = null;
        try {
            recordDOByRoomNumber = recordDAO.getRecordDOByRoomNumber(roomNumber);
            LOG.info("showRecordByRoomNumber success, roomNumber={}", roomNumber);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, recordDOByRoomNumber);
        } catch (Exception e) {
            LOG.error("showRecordByRoomNumber error, List<RecordDO>={}", recordDOByRoomNumber, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<Void> deleteById(long id) {
        try {
            recordDAO.deleteById(id);
            LOG.info("deleteById success, id={}", id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("deleteById error, id={}", id, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<List<RecordDO>> getAll() {
        List<RecordDO> all = null;
        try {
            all = recordDAO.getAll();
            LOG.info("getAll success, all={}", all);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("getAll error, all={}", all, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }
}
