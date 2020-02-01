package com.altersoftware.hotel.service;

import java.util.List;

import com.altersoftware.hotel.entity.MenuDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author czy@win10
 * @date 2020/2/1 21:21
 */
public interface MenuService {
    /**
     * 添加一条菜品
     *
     * @param menuDO
     * @return
     */
    ResultDO<Void> insert(MenuDO menuDO);

    /**
     * id返回菜品信息
     *
     * @param id
     * @return
     */
    ResultDO<MenuDO> showById(long id);

    /**
     * 更新菜品信息
     *
     * @param menuDO
     * @return
     */
    ResultDO<Void> update(MenuDO menuDO);

    /**
     * 删除菜品信息
     *
     * @param id
     * @return
     */
    ResultDO<Void> delete(long id);

    /**
     * 返回所有菜品信息
     *
     * @return
     */
    ResultDO<List<MenuDO>> showAll();
}
