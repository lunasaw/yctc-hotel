package com.altersoftware.hotel.controller.rest.impl;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.controller.rest.GoodsRestController;
import com.altersoftware.hotel.entity.GoodsDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author czy@win10
 * @date 2020/1/31 21:53
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/goods")
public class GoodsRestControllerImpl implements GoodsRestController {

    @Override
    @PostMapping("add-goods")
    public ResultDO<GoodsDO> insert(GoodsDO goodsDO) {
        return null;
    }

    @Override
    @PostMapping("show-goods")
    public ResultDO<GoodsDO> showGoods(long id) {
        return null;
    }

    @Override
    @PostMapping("update-goods")
    public ResultDO<Void> updateGoods(GoodsDO goodsDO) {
        return null;
    }

    @Override
    @PostMapping("show-goodsbyroomid")
    public ResultDO<List<GoodsDO>> showGoodsByRoom(long roomId) {
        return null;
    }

    @Override
    @PostMapping("delete-goods")
    public ResultDO<Void> deleteById(long id) {
        return null;
    }

    @Override
    @PostMapping("show-goodslist")
    public ResultDO<List<GoodsDO>> getAll() {
        return null;
    }
}
