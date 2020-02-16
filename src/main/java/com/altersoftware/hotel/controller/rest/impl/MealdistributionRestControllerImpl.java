package com.altersoftware.hotel.controller.rest.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.controller.rest.MealdistributionRestController;
import com.altersoftware.hotel.entity.MealdistributionDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.MealdistributionService;

/**
 * @author Iszychen@win10
 * @date 2020/2/16 16:32
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/meal")
public class MealdistributionRestControllerImpl implements MealdistributionRestController {

    @Resource
    private MealdistributionService mealdistributionService;

    @Override
    @PostMapping("accept-meal")
    public ResultDO<Void> createMealdistribution(MealdistributionDO mealdistribution) {
        return null;
    }

    @Override
    @PostMapping("get-byid")
    public ResultDO<MealdistributionDO> showMealdistribution(long id) {
        return null;
    }

    @Override
    @PostMapping("get-byorder")
    public ResultDO<MealdistributionDO> showMealdistributionByOrder(long order) {
        return null;
    }

    @Override
    @PostMapping("update")
    public ResultDO<Void> updateMealdistribution(MealdistributionDO mealdistribution) {
        return null;
    }

    @Override
    @PostMapping("delete-byid")
    public ResultDO<Void> deleteById(long id) {
        return null;
    }

    @Override
    @PostMapping("delete-byids")
    public ResultDO<Void> deleteList(List<Long> ids) {
        return null;
    }

    @Override
    @PostMapping("get-all")
    public ResultDO<List<MealdistributionDO>> getAll() {
        return null;
    }

    @Override
    @PostMapping("get-bystaff")
    public ResultDO<List<MealdistributionDO>> getListByStaffId(long staffId) {
        return null;
    }

    @Override
    @PostMapping("get-byroom")
    public ResultDO<List<MealdistributionDO>> getListByRoom(long roomId) {
        return null;
    }

    @Override
    @PostMapping("get-bystaffnow")
    public ResultDO<MealdistributionDO> getNow(long staffId) {
        return null;
    }

    @Override
    @PostMapping("end")
    public ResultDO<Void> end(long id) {
        return null;
    }

    @Override
    @PostMapping("start")
    public ResultDO<Void> start(long id) {
        return null;
    }
}
