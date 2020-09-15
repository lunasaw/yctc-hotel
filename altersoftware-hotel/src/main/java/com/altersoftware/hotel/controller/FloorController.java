package com.altersoftware.hotel.controller;

import org.springframework.ui.Model;

/**
 * @author hzx
 * @date 2020/1/28 21:06
 */
public interface FloorController {

    /**
     * 来到房间页面
     * 
     * @return
     */
    String showFloor(Model model);

    String showFlooradmin();

    String showFlooradmintable();
}
