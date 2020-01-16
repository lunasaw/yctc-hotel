package com.altersoftware.hotel.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface ManagerController {

    /**
     * 展示未授权页面
     *
     * @return
     */
    String showNoAuthorization();

    /**
     * 展示我的所有功能页面
     *
     * @return
     */
    String showFunctionsOfMine();

    /**
     * 展示后台管理页面
     * 
     * @param model
     * @param httpSession
     * @return
     */
    String showUserManage(Model model, HttpSession httpSession);

}
