package com.altersoftware.hotel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.dao.DepartmentDAO;
import com.altersoftware.hotel.entity.DepartmentDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.DepartmentService;

/**
 * @author czy@win10
 * @date 2020/2/3 21:12
 */
@ComponentScan({"com.altersoftware.hotel.dao"})
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Resource
    private DepartmentDAO       departmentDAO;

    @Override
    public ResultDO<Void> insert(DepartmentDO departmentDO) {
        try {
            departmentDAO.insert(departmentDO);
            LOG.info("insert success, departmentDO={}", departmentDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("insert error, departmentDO={}", departmentDO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<DepartmentDO> showDepartment(long id) {
        try {
            DepartmentDO departmentDOById = departmentDAO.getDepartmentDOById(id);
            LOG.info("getDepartmentDOById success, departmentDOById={}", departmentDOById);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, departmentDOById);
        } catch (Exception e) {
            LOG.error("getDepartmentDOById error, id={}", id, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<Void> updateDepartmentDO(DepartmentDO departmentDO) {
        int update = departmentDAO.update(departmentDO);
        if (update == 1) {
            LOG.info("updateGoods success, departmentDO={}", departmentDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } else {
            LOG.error("getDepartmentDOById error, departmentDO={}", departmentDO);
            return new ResultDO<>(false, ResultCode.UPDATE_FAILD,
                ResultCode.MSG_UPDATE_FAILD);
        }
    }

    @Override
    public ResultDO<DepartmentDO> showGoodsBystaffId(long staffId) {
        try {
            DepartmentDO departmentDOByRoomId = departmentDAO.getDepartmentDOByStaffId(staffId);
            LOG.info("getDepartmentDOByRoomId success, departmentDO={}", departmentDOByRoomId);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, departmentDOByRoomId);
        } catch (Exception e) {
            LOG.error("getDepartmentDOByRoomId error, staffId={}", staffId, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<Void> deleteById(long id) {
        try {
            departmentDAO.deleteById(id);
            LOG.info("deleteById success, departmentDO={}", id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("deleteById error, goodsId={}", id, e);
            return new ResultDO<>(false, ResultCode.DELETE_FAILD,
                ResultCode.MSG_DELETE_FAILD);
        }
    }

    @Override
    public ResultDO<Void> deleteList(List<Long> ids) {
        try {
            for (int i = 0; i < ids.size(); i++) {
                departmentDAO.deleteById(ids.get(i));
            }
            LOG.info("deleteList success, departmentDO={}", ids);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("deleteList error, goodsId={}", ids, e);
            return new ResultDO<>(false, ResultCode.DELETE_FAILD,
                ResultCode.MSG_DELETE_FAILD);
        }
    }

    @Override
    public ResultDO<List<DepartmentDO>> getAll() {
        try {
            List<DepartmentDO> all = departmentDAO.getDepartmentDOList();
            LOG.info("getAll success, departmentDO list={}", all);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("getAll error", e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }
}
