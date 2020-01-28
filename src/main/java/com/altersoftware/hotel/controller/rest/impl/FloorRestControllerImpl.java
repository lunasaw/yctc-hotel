package com.altersoftware.hotel.controller.rest.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.controller.rest.FloorRestController;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author czy@win10
 * @date 2020/1/28 21:13
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/floor")
public class FloorRestControllerImpl implements FloorRestController {

    @Override
    @PostMapping("show2d")
    public ResultDO<String> show2D(long id) {
        return null;
    }

    @Override
    @PostMapping("showfire")
    public ResultDO<String> showFire(long id) {
        return null;
    }

    @Override
    @PostMapping("show3d")
    public ResultDO<String> show3D(long id) {
        return null;
    }
}
