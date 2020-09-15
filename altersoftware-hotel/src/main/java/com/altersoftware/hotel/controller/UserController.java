package com.altersoftware.hotel.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.altersoftware.hotel.vo.*;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.altersoftware.hotel.entity.UserDO;


public interface UserController {

    /**
     * 展示注册页面
     *
     * @param map
     * @return
     */
    String showSignup(ModelMap map);

    /**
     * 注册post请求
     *
     * @param userDO
     * @return
     */
    @Deprecated
    String signup(UserDO userDO);

    /**
     * 展示登陆页面
     *
     * @param httpSession
     * @param model
     * @return
     */
    String showSignin(HttpSession httpSession, Model model);

    /**
     * 登陆post请求
     *
     * @param userDO
     * @param httpSession
     * @param model
     * @return
     */
    String signin(UserDO userDO, HttpSession httpSession, Model model, HttpServletResponse response);

    /**
     * 展示改密界面
     *
     * @param map
     * @param httpSession
     * @return
     */
    String showUpdatePassword(ModelMap map, HttpSession httpSession);

    /**
     * 有登录态的改密post请求
     *
     * @param updatePasswordVO
     * @param httpSession
     * @return
     */
    String updatePassword(UpdatePasswordVO updatePasswordVO, HttpSession httpSession);

    /**
     * 注销登陆post
     *
     * @param httpSession
     * @return
     */
    String signout(HttpSession httpSession);

    /**
     * 展示注销界面
     *
     * @return
     */
    String showSingout();

    /**
     * 展示找密界面
     *
     * @return
     */
    String showRetrievePassword();

    /**
     * 展示手机找密界面
     *
     * @return
     */
    String showRetrievePasswordByPhone();

    /**
     * 展示邮箱找密界面
     *
     * @return
     */
    String showRetrievePasswordByMail();

    /**
     * 手机找密
     *
     * @param retrievePasswordByPhoneVO
     * @param httpSession
     * @return
     */
    String retrievePasswordByPhone(RetrievePasswordByPhoneVO retrievePasswordByPhoneVO, HttpSession httpSession);

    /**
     * 邮箱找密
     *
     * @param retrievePasswordByMailVO
     * @param httpSession
     * @return
     */
    String retrievePasswordByMail(RetrievePasswordByMailVO retrievePasswordByMailVO, HttpSession httpSession);

    /**
     * 展示修改邮箱用户验证界面
     *
     * @param map
     * @param httpSession
     * @return
     */
    String showMailAuthentication(ModelMap map, HttpSession httpSession);

    /**
     * 修改邮箱用户验证post请求
     *
     * @param mailCaptchaVOO
     * @param httpSession
     * @return
     */
    String mailAuthentication(MailCaptchaVO mailCaptchaVOO, HttpSession httpSession);

    /**
     * 修改邮箱
     *
     * @param updateMailVO
     * @param httpSession
     * @return
     */
    String updateMail(UpdateMailVO updateMailVO, HttpSession httpSession);

    /**
     * 展示修改手机用户验证界面
     *
     * @param map
     * @param httpSession
     * @return
     */
    String showMobileAuthentication(ModelMap map, HttpSession httpSession);

    /**
     * 修改手机用户验证post请求
     *
     * @param mobileCaptchaVO
     * @param httpSession
     * @return
     */
    String mobileAuthentication(CaptchaVO mobileCaptchaVO, HttpSession httpSession);

    /**
     * 修改手机
     *
     * @param updateMobileVO
     * @param httpSession
     * @return
     */
    String updateMobile(UpdateMobileVO updateMobileVO, HttpSession httpSession);

    /**
     * 找密改密
     *
     * @param updatePasswordVO
     * @param httpSession
     * @return
     */
    String retrievePasswordStepC(UpdatePasswordVO updatePasswordVO, HttpSession httpSession);

    /**
     * 展示用户主页
     * 
     * @param model
     * @param httpSession
     * @return
     */
    String showUserHome(Model model, HttpSession httpSession);

    /**
     * 展示我的信息页面
     *
     * @return
     */
    String showMyInformation(Model model, HttpSession httpSession);

    /**
     * 展示我的子页面
     *
     * @return
     */
    String showMyInformationtable(Model model, HttpSession httpSession);

    /**
     * 修改我的信息页面
     *
     * @return
     */
    String showMyInformationupdate(Model model, HttpSession httpSession);

}
