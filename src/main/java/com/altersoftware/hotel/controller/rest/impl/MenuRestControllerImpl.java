package com.altersoftware.hotel.controller.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.controller.rest.MenuRestController;
import com.altersoftware.hotel.entity.MenuDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.MenuService;

/**
 * @author hzx
 * @date
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/menuinfo")
public class MenuRestControllerImpl implements MenuRestController {

    @Autowired
    MenuService menuService;

    /**
     * 添加一条菜品
     *
     * @param menuDO
     * @return
     */
    @Override
    @PostMapping("add-menu")
    public ResultDO<Void> insert(@RequestBody MenuDO menuDO) {
        // 参数校验
        if (menuDO.getId() <= 0 || menuDO.getNumbers() <= 0 || menuDO.getPrice() <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<Void> voidResultDO = menuService.insert(menuDO);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    /**
     * id返回菜品信息
     *
     * @param id
     * @return
     */
    @Override
    @PostMapping("get-byid")
    public ResultDO<MenuDO> showById(long id) {
        // 参数校验
        if (id <= 0) {
            return new ResultDO<MenuDO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<MenuDO> menuDOResultDO = menuService.showById(id);
        if (menuDOResultDO.isSuccess() == false) {
            return new ResultDO<MenuDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            MenuDO doResultDOModule = menuDOResultDO.getModule();
            return new ResultDO<MenuDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, doResultDOModule);
        }
    }

    /**
     * 更新菜品信息
     *
     * @param menuDO
     * @return
     */
    @Override
    @PostMapping("updae-menu")
    public ResultDO<Void> update(@RequestBody MenuDO menuDO) {
        // 参数校验
        if (menuDO.getId() <= 0 || menuDO.getNumbers() <= 0 || menuDO.getPrice() <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<MenuDO> menuDOResultDO = menuService.showById(menuDO.getId());
        if (menuDOResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            MenuDO doResultDOModule = menuDOResultDO.getModule();
            doResultDOModule.setId(menuDO.getId());
            doResultDOModule.setName(menuDO.getName());
            doResultDOModule.setNumbers(menuDO.getNumbers());
            doResultDOModule.setPicture(menuDO.getPicture());
            doResultDOModule.setPrice(menuDO.getPrice());

            ResultDO<Void> voidResultDO = menuService.update(doResultDOModule);
            if (voidResultDO.isSuccess() == false) {
                return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            } else {
                return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
            }
        }
    }

    /**
     * 删除菜品信息
     *
     * @param id
     * @return
     */
    @Override
    @PostMapping("delete-byid")
    public ResultDO<Void> delete(long id) {
        // 参数校验
        if (id <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<Void> voidResultDO = menuService.delete(id);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    /**
     * 返回所有菜品信息
     *
     * @return
     */
    @Override
    @PostMapping("get-listmenu")
    public ResultDO<List<MenuDO>> showAll() {
        ResultDO<List<MenuDO>> listResultDO = menuService.showAll();
        if (listResultDO.isSuccess() == false) {
            return new ResultDO<List<MenuDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            List<MenuDO> menuDOList = listResultDO.getModule();
            return new ResultDO<List<MenuDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, menuDOList);
        }
    }
}
