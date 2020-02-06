package com.altersoftware.hotel.controller.rest.impl;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.controller.rest.VipGradeRestController;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.VipGradeDO;

/**
 * @author Iszychen@win10
 * @date 2020/2/6 18:28
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/vipGrade")
public class VipGradeRestControllerImpl implements VipGradeRestController {

    @Override
    @PostMapping("add-vipgrade")
    public ResultDO<Void> insert(VipGradeDO vipGrade) {
        return null;
    }

    @Override
    @PostMapping("get-byid")
    public ResultDO<VipGradeDO> showVipGrade(long id) {
        return null;
    }

    @Override
    @PostMapping("update-vipgrade")
    public ResultDO<Void> updateVipGrade(VipGradeDO vipGrade) {
        return null;
    }

    @Override
    @PostMapping("getlist-bygrade")
    public ResultDO<List<VipGradeDO>> showVipGradeByGrade(String grade) {
        return null;
    }

    @Override
    @PostMapping("delete-byid")
    public ResultDO<Void> deleteById(long id) {
        return null;
    }

}
