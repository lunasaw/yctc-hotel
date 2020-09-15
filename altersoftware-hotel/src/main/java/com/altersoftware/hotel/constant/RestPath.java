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

    //物品状态设置
    /** 修改物品状态值 */
    public static final String UPDATE_GOODS_STATE = "/state/update-state";

    /** 增加物品状态值 */
    public static final String ADD_GOODS_STATE = "/state/add-state";

    /** 通过房间号和物品名返回 */
    public static final String RETURN_BYROOMNUM_ANDNAME = "/state/show-goods";

    /** 通过房间号返回物品状态 */
    public static final String RETURN_BYROOMNUM = "/state/show-goodsbyroomNumber";

    /** 通过物品名返回物品状态 */
    public static final String RETURN_GOODSNAME = "/state/show-goodsbyroomNumber";

    /** 获取所有物品及状态 */
    public static final String RETURN_LIST = "/state/get-list";

    /** 删除物品状态 */
    public static final String DELET_GOODS_STATE = "/state/delet-goods";

    /** 更新物品状态 */
    public static final String UPDATE_ONE_STATE = "/state/update-onestate";


    //房间类别设置
    /** 增加一个房间类别 */
    public static final String ADD_ROOMTYPE = "/roomTypeInfo/add-roomtype";

    /** 查询所有房间类别信息 */
    public static final String GET_LIST = "/roomTypeInfo/get-list";

    /** 更新房间类别状态 */
    public static final String UPDATE_ROOMTYPE = "/roomTypeInfo/update-roomtype";

    /** 更新房间照片 */
    public static final String UPDATE_ROOMTYPE_PIC = "/roomTypeInfo/update-roompic";

    /** 删除指定房间类别数据 */
    public static final String DELETE_ROOMTYPE = "/roomTypeInfo/delete-roomtype";

    /** 删除多条记录 */
    public static final String DELETE_LIST_ROOMTYPE = "/roomTypeInfo/delete-byidlist";

    /** 房间类别id查询房间类别信息 */
    public static final String RETURN_BYROOMID = "/roomTypeInfo/get-byid";


    //房间信息设置
    /** 显示所有房间信息 */
    public static final String GET_ROOM_LIST = "/room/get-list";

    /** 更新房间信息 */
    public static final String UPDATE_ROOMS = "/room/update-room";

    /** 通过id获取房间信息 */
    public static final String RETURN_ROOMS_BYID = "/room/get-byid";

    /** 按照房间号查找房间信息 */
    public static final String RETURN_ROOMS_BYROOMNUM = "/room/get-byNumber";

    /** 插入一个房间信息 */
    public static final String ADD_ROOMS = "/room/add-room";

    /** id删除房间信息 */
    public static final String DELETE_ROOMS_BYID = "/room/delete-byid";

    /** 删除多条记录 */
    public static final String DELETE_ROOMS_BYIDLIST = "/room/delete-byidlist";


    //客户信息设置
    /** 获取所有客户信息 */
    public static final String GET_ALL_CUSTOMERS = "/customer/getall";

    /** 修改客户信息 */
    public static final String UPDATE_CUSTOMERS = "/customer/update-userdo";

    /** 删除指定客户信息 */
    public static final String DELETE_CUSTOMER_BYID = "/customer/delete-byid";

    /** 删除多条记录 */
    public static final String DELETE_CUSTOMER_LIST = "/customer/delete-byidlist";

    /** 会员号搜索客户/员工 */
    public static final String RETURN_CUSTOMER_BYNUMBER = "/customer/get-bynumber";

    /** 客户编号搜索客户 */
    public static final String RETURN_CUSTOMER_BYCUSTOMERID = "/customer/get-byId";

    /** 返回所有清洁部员工 */
    public static final String RETURN_CLEANER_LIST = "/customer/get-cleanlist";


    //员工信息设置
    /** 获取通过部门号 */
    public static final String GET_BY_DEPERTMENTID = "/staff/get-bydepartmentId";

    /** 获取所有员工信息 */
    public static final String GET_STAFF_LIST = "/staff/getall";

    /** 修改员工信息 */
    public static final String UPDATE_STAFF = "/staff/update-userdo";

    /** 修改员工照片信息 */
    public static final String UPDATE_STAFF_PIC = "/staff/update-userpic";

    /** 删除指定员工信息 */
    public static final String DELETE_BYID = "/staff/delete-byid";

    /** 删除多条记录 */
    public static final String DELETE_BYID_LIST = "/staff/delete-byidlist";

    /** 会员号搜索员工/员工 */
    public static final String GET_STAFF_BYNUMBER = "/staff/get-bynumber";
}
