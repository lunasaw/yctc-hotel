package com.altersoftware.hotel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.dao.MenuDAO;
import com.altersoftware.hotel.entity.MenuDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.MenuService;

/**
 * @author czy@win10
 * @date 2020/2/1 21:24
 */
@ComponentScan({"com.altersoftware.hotel.dao"})
@Service("menuService")
public class MenuServiceImpl implements MenuService {
    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Resource
    private MenuDAO             menuDAO;

    @Override
    public ResultDO<Void> insert(MenuDO menuDO) {
        try {
            menuDAO.insert(menuDO);
            LOG.info("insert success, hotelDOById={}", menuDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("insert error, menuDO={}", menuDO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<MenuDO> showById(long id) {
        MenuDO menuDOById = null;
        try {
            menuDOById = menuDAO.getMenuDOById(id);
            LOG.info("getMenuDOById success, hotelDOById={}", menuDOById);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, menuDOById);
        } catch (Exception e) {
            LOG.error("getMenuDOById error, Id={}", id, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<Void> update(MenuDO menuDO) {
        int update = menuDAO.update(menuDO);
        if (update == 1) {
            LOG.info("updateMenuDO success, menuDO={}", menuDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } else {
            LOG.error("updateMenuDO error, menuDO={}", menuDO);
            return new ResultDO<>(false, ResultCode.UPDATE_FAILD,
                ResultCode.MSG_UPDATE_FAILD);
        }
    }

    @Override
    public ResultDO<Void> delete(long id) {
        try {
            int i = menuDAO.deleteById(id);
            LOG.info("deleteMenuDO success, id={}", id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("deleteMenuDO error, menuDO={}", id);
            return new ResultDO<>(false, ResultCode.DELETE_FAILD,
                ResultCode.MSG_DELETE_FAILD);
        }

    }

    @Override
    public ResultDO<List<MenuDO>> showAll() {
        try {
            List<MenuDO> menuDOList = menuDAO.getMenuDOList();
            LOG.info("getListMenuDO success, menuDOList={}", menuDOList);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, menuDOList);
        } catch (Exception e) {
            LOG.error("getListMenuDO error, menuDO={}");
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }
}
