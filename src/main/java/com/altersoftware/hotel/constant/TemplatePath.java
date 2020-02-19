package com.altersoftware.hotel.constant;

public class TemplatePath {

    // common start
    /** 主页 */
    public static final String INDEX                                      = "index";
    // common end

    // user start
    /** 用户主页 */
    public static final String USER_HOME                                  = "user/home";

    /** 注册 */
    @Deprecated
    public static final String USER_SIGNUP                                = "user/register";

    /** 登录 */
    public static final String USER_SIGN_IN                               = "user/sign-in";

    /** 注册 */
    public static final String USER_SIGN_UP                               = "/user/sign-up";

    /** 登陆成功页 */
    public static final String USER_SIGN_IN_SUCCESS                       = "user/sign-in-success";

    /** 注册成功页面 */
    public static final String USER_SIGN_UP_SUCCESS                       = "user/sign-up-success";

    /** 注销登陆 */
    public static final String USER_SIGN_OUT                              = "user/sign-out";
    /** 注销成功 */
    public static final String USER_SIGN_OUT_SUCCESS                      = "user/sign-out-success";

    /** 找密界面 */
    public static final String USER_RETRIEVE_PASSWORDB_START              = "user/verify-identity-step-a";

    /** 手机找密 */
    public static final String USER_RETRIEVE_PASSWORD_BY_PHONE            = "user/verify-identity-step-b-mobile";

    /** 邮箱找密 */
    public static final String USER_RETRIEVE_PASSWORD_BY_MAIL             = "user/verify-identity-step-b-email";

    /** 找密步骤三改密 */
    public static final String USER_RETRIEVE_PASSWORDB                    = "user/verify-identity-step-c";

    /** 找密成功 */
    public static final String USER_RETRIEVE_PASSWORD_SUCCESS             = "user/verify-identity-success";

    /** 修改密码 */
    public static final String USER_UPDATE_PASSWORD                       = "user/update-password";

    /** 改密成功 */
    public static final String USER_UPDATE_PASSWORD_SUCCESS               = "user/update-password-success";

    /** 修改邮箱身份验证 */
    public static final String USER_MAIL_AUTHENTICATION                   = "user/mail-authentication";

    /** 修改邮箱 */
    public static final String USER_UPDATE_MAIL                           = "user/update-email";

    /** 修改邮箱成功 */
    public static final String USER_UPDATE_MAIL_SUCCESS                   = "user/update-mail-success";

    /** 修改手机身份验证 */
    public static final String USER_MOBILE_AUTHENTICATION                 = "user/mobile-authentication";

    /** 修改手机 */
    public static final String USER_UPDATE_MOBILE                         = "user/update-mobile";

    /** 修改手机成功 */
    public static final String USER_UPDATE_MOBILE_SUCCESS                 = "user/update-mobile-success";

    /** 我的信息 */
    public static final String USER_MY_INFORMATION                        = "user/my-information";

    /** 修改我的信息 */
    public static final String USER_MY_INFORMATION_UPDATE                 = "user/my-informationupdate";

    // user end

    // news start
    /** 消息列表页 */
    public static final String NEWS_LIST                                  = "news/news";
    /** 消息详情页 */
    public static final String NEWS_DETAIL                                = "news/news-detail";
    // news and

    // management start
    /** 管理员-权限管理功能界面 */
    public static final String EDUCATION_AUTHORITY_MANAGEMENT             = "management/authority-management";
    /** 权限管理-角色管理功能界面 */
    public static final String EDUCATION_AUTHORITY_ROLE_MANAGEMENT        = "management/authority-role-management";
    /** 权限管理-角色管理-增加角色功能界面 */
    public static final String EDUCATION_AUTHORITY_ROLE_MANAGEMENT_ADD    = "management/authority-role-management-add";
    /** 权限管理-角色管理-修改角色功能界面 */
    public static final String EDUCATION_AUTHORITY_ROLE_MANAGEMENT_MODIFY =
        "management/authority-role-management-modify";
    // management end

    /** 后台管理界面 */
    public static final String USER_MANAGE                                = "manage/user-manage";
    // 此为测试页面，不上线

    /** 楼层信息页面 */
    public static final String FLOOR                                      = "hotel/floor";

    /** 楼层信息页面 */
    public static final String FLOOR_ADMIN                                = "hotel/flooradmin";

    /** 楼层信息页面 */
    public static final String FLOOR_ADMIN_TABLE                          = "hotel/flooradmintable";

    /** 房间信息页面 */
    public static final String ROOMS                                      = "hotel/rooms";

    /** 前台房间信息页面 */
    public static final String ROOMS_RECEPTION                            = "hotel/roomscondition";

    /** 房间修改页面 */
    public static final String ROOMS_UPDATE                               = "hotel/rooms-update";

    /** 房间信息页面 */
    public static final String ROOM_ADMIN                                 = "hotel/roomAdmin";

    /** 房间信息页面 */
    public static final String ROOM_ADMIN_TABLE                           = "hotel/roomAdminTable";

    /** 房间类别信息页面 */
    public static final String ROOM_TYPE                                  = "hotel/roomType";

    /** 管理房间类别信息页面 */
    public static final String ROOM_TYPE_ADMIN                            = "hotel/roomTypeAdmin";

    /** 房间类别信息页面 */
    public static final String ROOM_TYPE_ADMIN_TABLE                      = "hotel/roomTypeAdminTable";

    /** 客户信息页面 */
    public static final String CUSTOMER_INFO                              = "customer/customer-info";

    /** 客户信息页面 */
    public static final String CUSTOMER_INFO_TABLE                        = "customer/customer-infotable";

    /** 客户信息修改页面 */
    public static final String CUSTOMER_UPDATE                            = "customer/updateByCustomer";

    /** 会员信息页面 */
    public static final String VIP_INFO                                   = "vip/vipinfo";

    /** 会员信息页面 */
    public static final String VIP_TABLE                                  = "vip/viptable";

    /** 客户会员权益信息页面 */
    public static final String VIP_GRADE_SHOW                             = "vip/showvipGrade";

    /** 会员等级信息页面 */
    public static final String VIP_GRADE_INFO                             = "vip/vipGrade";

    /** 会员等级信息子页面 */
    public static final String VIP_GRADE_INFO_TABLE                       = "vip/vipGradeTable";

    /** 酒店信息页面 */
    public static final String HOTEL                                      = "hotel/hotels";

    /** 物品信息页面 */
    public static final String GOODS                                      = "hotel/goods";

    /** 物品信息页面 */
    public static final String GOODS_TABLE                                = "hotel/goodstable";

    /** 物品信息页面 */
    public static final String GOODS_STATE_SET                                = "hotel/goodsStateSet";

    /** 菜品信息页面 */
    public static final String MENUS                                      = "hotel/menus";

    /** 菜品信息页面 */
    public static final String MENUS_TABLE                                = "hotel/menustable";

    /** 管理员菜品信息页面 */
    public static final String MENUS_ADMIN                                = "hotel/menuadmin";

    /** 管理员菜品信息页面 */
    public static final String MENUS_ADMIN_TABLE                          = "hotel/menuadmintable";

    /** 部门信息页面 */
    public static final String DEPARTMENT                                 = "hotel/depatment";

    /** 部门表格页面 */
    public static final String DEPARTMENT_TABLE                           = "hotel/depatmenttable";

    /** 员工信息页面 */
    public static final String STAFF_INFO                                 = "staff/staffinfo";

    /** 员工信息页面 */
    public static final String STAFF_INFO_TABLE                           = "staff/stafftable";

    /** 订单信息页面 */
    public static final String RECORD_INFO                                = "order/record";

    /** 配送订单管理员页面 */
    public static final String MENU_ADMIN                                 = "order/Mealdistribution";

    /** 配送订单管理员页面 */
    public static final String MENU_ADMIN_TABLE                          = "order/MealdistributionTable";

    /** 填写订单类型选择页面 */
    public static final String PLACE_AN_ORDER                             = "order/placeanorder";

    /** 填写菜品订单类型选择页面 */
    public static final String PLACE_AN_ORDER_MENU                        = "order/placeanordermenu";

    /** 支付宝回调/返回是否支付成功页面 */
    public static final String CHECK_ALI_PAY                              = "pay/checkalipay";

    /** 用户订单交付页面 */
    public static final String SUBMIT_RECORD                              = "pay/roomReserve";

    /** 客户历史订单页面 */
    public static final String RECORD_BY_CUSTOMER                         = "customer/recordByCustomer";

    /** 管理员订单统计页面 */
    public static final String RECORD_BY_ADMIN                            = "order/recordByAdmin";

    /** 管理员订单统计子页面 */
    public static final String RECORD_BY_ADMIN_TABLE                      = "order/recordByAdmintable";

    /** 客户菜品历史订单页面 */
    public static final String ORDER_BY_CUSTOMER                          = "customer/orderByCustomer";

    /** 管理员菜品历史订单页面 */
    public static final String ORDER_BY_ADMIN                             = "order/orderByAdmin";

    /** 管理员菜品历史订单页面 */
    public static final String ORDER_BY_ADMIN_TABLE                       = "order/orderByAdminTable";

}
