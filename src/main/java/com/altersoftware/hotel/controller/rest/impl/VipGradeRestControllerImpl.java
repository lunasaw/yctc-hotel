package com.altersoftware.hotel.controller.rest.impl;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.controller.rest.VipGradeRestController;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.VipDO;

/**
 * @author Iszychen@win10
 * @date 2020/2/6 18:28
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/vipGrade")
public class VipGradeRestControllerImpl implements VipGradeRestController {

    @Override
    public ResultDO<Void> insert(VipDO vipDO) {
        return null;
    }

    @Override
    public ResultDO<VipDO> showVip(long id) {
        return null;
    }

    @Override
    public ResultDO<Void> updateVip(VipDO vipDO) {
        return null;
    }

    @Override
    public ResultDO<List<VipDO>> showVipList() {
        return null;
    }

    @Override
    public ResultDO<Void> deleteById(long id) {
        return null;
    }

    @Override
    public ResultDO<List<Long>> getAllNumberList() {
        return null;
    }
}
