package com.altersoftware.hotel.constant;

public class TemplatePath {

    // common start
    /** 主页 */
    public static final String INDEX = "index";
    // common end

    // user start
    /** 用户主页 */
    public static final String USER_HOME = "user/home";

    /** 注册 */
    @Deprecated
    public static final String USER_SIGNUP = "user/register";

    /** 登录 */
    public static final String USER_SIGN_IN = "user/sign-in";

    /** 注册 */
    public static final String USER_SIGN_UP="/user/sign-up";

    /** 登陆成功页 */
    public static final String USER_SIGN_IN_SUCCESS = "user/sign-in-success";

    /** 注册成功页面 */
    public static final String USER_SIGN_UP_SUCCESS = "user/sign-up-success";

    /** 注销登陆 */
    public static final String USER_SIGN_OUT = "user/sign-out";
    /** 注销成功 */
    public static final String USER_SIGN_OUT_SUCCESS = "user/sign-out-success";

    /** 找密界面 */
    public static final String USER_RETRIEVE_PASSWORDB_START = "user/verify-identity-step-a";
    /** 手机找密 */
    public static final String USER_RETRIEVE_PASSWORD_BY_PHONE = "user/verify-identity-step-b-mobile";
    /** 邮箱找密 */
    public static final String USER_RETRIEVE_PASSWORD_BY_MAIL = "user/verify-identity-step-b-email";
    /** 找密步骤三改密 */
    public static final String USER_RETRIEVE_PASSWORDB = "user/verify-identity-step-c";
    /** 找密成功 */
    public static final String USER_RETRIEVE_PASSWORD_SUCCESS = "user/verify-identity-success";

    /** 修改密码 */
    public static final String USER_UPDATE_PASSWORD = "user/update-password";
    /** 改密成功 */
    public static final String USER_UPDATE_PASSWORD_SUCCESS = "user/update-password-success";

    /** 修改邮箱身份验证 */
    public static final String USER_MAIL_AUTHENTICATION = "user/mail-authentication";
    /** 修改邮箱 */
    public static final String USER_UPDATE_MAIL = "user/update-email";
    /** 修改邮箱成功 */
    public static final String USER_UPDATE_MAIL_SUCCESS = "user/update-mail-success";

    /** 修改手机身份验证 */
    public static final String USER_MOBILE_AUTHENTICATION = "user/mobile-authentication";
    /** 修改手机 */
    public static final String USER_UPDATE_MOBILE = "user/update-mobile";
    /** 修改手机成功 */
    public static final String USER_UPDATE_MOBILE_SUCCESS = "user/update-mobile-success";

    /** 我的信息 */
    public static final String USER_MY_INFORMATION = "user/my-information";
    // user end

    // news start
    /** 消息列表页 */
    public static final String NEWS_LIST = "news/news";
    /** 消息详情页 */
    public static final String NEWS_DETAIL = "news/news-detail";
    // news and

    // management start
    /** 管理员-权限管理功能界面 */
    public static final String EDUCATION_AUTHORITY_MANAGEMENT = "management/authority-management";
    /** 权限管理-角色管理功能界面 */
    public static final String EDUCATION_AUTHORITY_ROLE_MANAGEMENT = "management/authority-role-management";
    /** 权限管理-角色管理-增加角色功能界面 */
    public static final String EDUCATION_AUTHORITY_ROLE_MANAGEMENT_ADD = "management/authority-role-management-add";
    /** 权限管理-角色管理-修改角色功能界面 */
    public static final String EDUCATION_AUTHORITY_ROLE_MANAGEMENT_MODIFY =
        "management/authority-role-management-modify";
    // management end


    /** 后台管理界面 */
    public static final String USER_MANAGE = "manage/user-manage";
                                                                   // 此为测试页面，不上线

    /** 楼层信息页面 */
    public static final String FLOOR                                      = "hotel/floor";

}
