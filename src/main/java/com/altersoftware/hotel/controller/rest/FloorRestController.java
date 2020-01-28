package com.altersoftware.hotel.controller.rest;

import org.springframework.stereotype.Controller;

import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author czy@win10
 * @date 2020/1/28 21:11
 */
@Controller
public interface FloorRestController {

    /**
     * 展示平面图
     *
     * @param id
     */
    ResultDO<String> show2D(long id);

    /**
     * 展示消防图
     *
     * @param id
     */
    ResultDO<String> showFire(long id);

    /**
     * 展示3D图
     *
     * @param id
     */
    ResultDO<String> show3D(long id);
}
