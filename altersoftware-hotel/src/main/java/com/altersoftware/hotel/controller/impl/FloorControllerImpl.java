package com.altersoftware.hotel.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.FloorController;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.FloorService;

/**
 * @author czy@win10
 * @date 2020/1/28 21:07
 */
@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/floor")
public class FloorControllerImpl implements FloorController {

    @Autowired
    FloorService floorService;
    /**
     * 楼层信息页面
     *
     * @return
     */
    @Override
    @GetMapping("show-floor")
    public String showFloor(Model model) {
        ResultDO<List<Long>> listResultDO = floorService.showFloorId();
        List<Long> module = listResultDO.getModule();
        model.addAttribute("floors",module);
        return TemplatePath.FLOOR;
    }

    /**
     * 管理员楼层信息页面
     *
     * @return
     */
    @Override
    @GetMapping("show-flooradmin")
    public String showFlooradmin() {
        return TemplatePath.FLOOR_ADMIN;
    }

    /**
     * 管理员楼层信息页面
     *
     * @return
     */
    @Override
    @GetMapping("show-flooradmintable")
    public String showFlooradmintable() {
        return TemplatePath.FLOOR_ADMIN_TABLE;
    }
}
