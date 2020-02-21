package com.altersoftware.hotel.controller.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.LeaseController;

/**
 * @author czy@win10
 * @date 2020/1/31 21:51
 */
@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/lease")
public class LeaseControllerImpl implements LeaseController {

    /**
     * 租赁信息页面
     *
     * @return
     */
    @Override
    @GetMapping("show-lease")
    public String showLeaseInfo() {
        return TemplatePath.LEASE;
    }

    /**
     * 租赁信息页面
     *
     * @return
     */
    @Override
    @GetMapping("show-leasetable")
    public String showLeaseTable() {
        return TemplatePath.LEASE_TABLE;
    }

    /**
     * 租赁状态页面
     *
     * @return
     */
    @Override
    @GetMapping("show-leaseadmin")
    public String showLeaseState() {
        return TemplatePath.LEASE_ADMIN;
    }

}
