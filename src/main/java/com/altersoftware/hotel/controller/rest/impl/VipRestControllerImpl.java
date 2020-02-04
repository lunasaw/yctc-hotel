package com.altersoftware.hotel.controller.rest.impl;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.controller.rest.VipRestController;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.VipDO;

/**
 * @author Iszychen@win10
 * @date 2020/2/4 15:42
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/vip")
public class VipRestControllerImpl implements VipRestController {

    @Override
    @PostMapping("add-vip")
    public ResultDO<Void> insert(VipDO vipDO) {
        return null;
    }

    @Override
    @PostMapping("get-vip")
    public ResultDO<VipDO> showVip(long id) {
        return null;
    }

    @Override
    @PostMapping("update-vip")
    public ResultDO<Void> updateVip(VipDO vipDO) {
        return null;
    }

    @Override
    @PostMapping("get-list")
    public ResultDO<List<VipDO>> showVipList() {
        return null;
    }

    @Override
    @PostMapping("delete-byid")
    public ResultDO<Void> deleteById(long id) {
        return null;
    }

    @Override
    @PostMapping("get-bynumber")
    public ResultDO<List<Long>> getAllNumber() {
        return null;
    }
}
