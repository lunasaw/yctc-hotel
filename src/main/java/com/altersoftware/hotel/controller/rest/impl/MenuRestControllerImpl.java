package com.altersoftware.hotel.controller.rest.impl;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.controller.rest.MenuRestController;
import com.altersoftware.hotel.entity.MenuDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author czy@win10
 * @date 2020/2/1 21:42
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/menuinfo")
public class MenuRestControllerImpl implements MenuRestController {

    @Override
    @PostMapping("insert-menu")
    public ResultDO<Void> insert(MenuDO menuDO) {
        return null;
    }

    @Override
    @PostMapping("show-menu")
    public ResultDO<MenuDO> showById(long id) {
        return null;
    }

    @Override
    @PostMapping("updae-menu")
    public ResultDO<Void> update(MenuDO menuDO) {
        return null;
    }

    @Override
    @PostMapping("delete-menu")
    public ResultDO<Void> delete(long id) {
        return null;
    }

    @Override
    @PostMapping("show-listmenu")
    public ResultDO<List<MenuDO>> showAll() {
        return null;
    }
}
