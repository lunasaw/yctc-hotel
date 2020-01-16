package com.altersoftware.hotel.constant;

public class RestPath {

       // user start
    /** 注册 */
    public static final String SIGN_UP = "/restuser/sign-up";
    /** 登录 */
    public static final String SIGN_IN = "/restuser/sign-in";
    /** 获得用户信息 */
    public static final String GET_USER_INFORMATION_BY_ID = "/restuser/get-user-information-by-id";
    /** 发邮件验证码 */
    public static final String SEND_MAIL = "/restwarpper/send-Mail";
    /** 发邮件验证码(修改邮箱时用) */
    public static final String SEND_MAILFORUPDATEMAIL = "/restwarpper/send-MailForUpdateMail";
    /** 发短信验证码 */
    public static final String SEND_SMS = "/restwarpper/send-Sms";
    /** 发短信验证码(修改手机时用) */
    public static final String SEND_SMSFORUPDATEMOBILE = "/restwarpper/send-SmsForUpdateMobile";
    // user end


    /** 添加单条权限 */
    public static final String ADD_PERMISSION = "/restpermission/add-permission";
    /** 删除单条权限 */
    public static final String DELETE_PERMISSION = "/restpermission/delete-permission";
    // metadata end

    // news start
    /** 获得用户消息列表 */
    public static final String SHOW_NEWS = "/restnews/show-News";
    /** 将某条信息变更为已读 */
    public static final String TURN_TO_READED = "/restnews/turn-to-readed";
    /** 将某条信息变更为未读 */
    public static final String TURN_TO_UNREAD = "/restnews/turn-to-unread";
    /** 全部变更为已读 */
    public static final String TURN_ALL_TO_READED = "/restnews/turn-all-to-readed";
    /** 全部变更为未读 */
    public static final String TURN_ALL_TO_UNREAD = "/restnews/turn-all-to-unread";
    /** 给用户推送消息 */
    public static final String SEND_NEWS_TO_USER_LIST = "/restnews/send-news-to-user-list";
    // news end


}
