package com.altersoftware.hotel.controller.rest.impl;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.controller.rest.CustomerRestController;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;

/**
 * @author czy@win10
 * @date 2020/1/30 19:57
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/customer")
public class CustomerRestControllerImpl implements CustomerRestController {

    @Override
    @PostMapping("getall")
    public ResultDO<List<UserDO>> getAllCustomer() {
        return null;
    }

    @Override
    @PostMapping("updateone")
    public ResultDO<Void> updateUserDO(Long userId) {
        return null;
    }

    @Override
    @PostMapping("deletebyUserid")
    public ResultDO<Void> deleteByUserId(Long userId) {
        return null;
    }

    @Override
    @PostMapping("getbynumber")
    public ResultDO<UserDO> getByNumber(String number) {
        return null;
    }
}
