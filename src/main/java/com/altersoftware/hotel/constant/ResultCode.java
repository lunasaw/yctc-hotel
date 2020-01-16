package com.altersoftware.hotel.constant;

public class ResultCode {

    /** 成功 */
    public static final int SUCCESS = 1;
    public static final String MSG_SUCCESS = "success";

    // 业务中细分的code 1000-1999
    /** 用户未登录 */
    public static final int USER_NOT_SIGN_IN = 1000;
    public static final String MSG_USER_NOT_SIGN_IN = "user not sign in";

    /** 登陆错误 */
    public static final int SIGN_IN_ERROR = 1001;
    public static final String MSG_SIGN_IN_ERROR = "sign in error";

    /** 无用户错误 */
    public static final int NO_SUCH_USER = 1002;
    public static final String MSG_NO_SUCH_USER = "no such user";

    /** 无当前手机 */
    public static final int NO_SUCH_PHONE = 1003;
    public static final String MSG_NO_SUCH_PHONE = "no such phone";

    /** 无当前邮箱 */
    public static final int NO_SUCH_MAIL = 1004;
    public static final String MSG_NO_SUCH_MAIL = "no such mail";

    /** 短信超过发送限制 */
    public static final int OVER_SEND_SMS = 1005;
    public static final String MSG_OVER_SEND_SMS = "over send sms";

    /** 验证码失效 */
    public static final int VERIFICATION_CODE_TIMEOUT = 1006;
    public static final String MSG_VERIFICATION_CODE_TIMEOUT = "verification code timeout";

    /** 没有消息 */
    public static final int NO_NEWS = 1006;
    public static final String MSG_NO_NEWS = "no news";

    /** 未知信息 */
    public static final int UNKNOW_NEWS = 1007;
    public static final String MSG_UNKNOW_NEWS = "unknow news";

    /** 权限不存在 */
    public static final int NO_SUCH_PERMISSION = 1008;
    public static final String MSG_NO_SUCH_PERMISSION = "no such permission";

    /** 权限重复 */
    public static final int PERMISSION_REPETITION = 1009;
    public static final String MSG_PERMISSION_REPETITION = "permission is repetitive";

    /** 无当前课程 */
    public static final int NO_SUCH_COURSE = 1010;
    public static final String MSG_NO_SUCH_COURSE = "no such course";

    /** 无赋权记录 */
    public static final int NO_SUCH_AUTHORIZATION_RECORD = 1020;
    public static final String MSG_NO_SUCH_AUTHORIZATION_RECORD = "no such authorization record";

    /** 密码错误 */
    public static final int PASSWORD_ERROR = 1021;
    public static final String MSG_PASSWORD_ERROR = "password error";

    /** 无此权限组 */
    public static final int NO_SUCH_PERMISSION_GROUNP = 1022;
    public static final String MSG_NO_SUCH_PERMISSION_GROUNP = "no such permission group";

    /** 此权限不可进行操作 */
    public static final int PERMISSION_WITHOUT_OPERATION = 1023;
    public static final String MSG_PERMISSION_WITHOUT_OPERATION = "permission without operation";

    /** 该用户已初始化权限，无需再初始化权限 */
    public static final int NO_NEED_TO_INIT_PERMISSION = 1024;
    public static final String MSG_NO_NEED_TO_INIT_PERMISSION = "no need to init permission";

    /** 数据库查不到数据 */
    public static final int DATABASE_CAN_NOT_FIND_DATA = 1025;
    public static final String MSG_DATABASE_CAN_NOT_FIND_DATA = "database can not find data";

    /** 没有此用户权限缓存 */
    public static final Integer NO_PERMISSION_CACHE = 1026;
    public static final String MSG_NO_PERMISSION_CACHE = "no permission cache";

    /** 数据库中已有楼宇信息 */
    public static final int ALREADY_EXIST_BUILDINGFLOORDO = 1026;
    public static final String MSG_ALREADY_EXIST_BUILDINGFLOORDO = "already exist buildingFloorDO";

    /** 数据库中已有班级信息 */
    public static final int ALREADY_EXIST_CLASSDO = 1027;
    public static final String MSG_ALREADY_EXIST_CLASSDO = "already exist classDO";

    /** 邮件发送失败 */
    public static final int SEND_SMS_FAIL = 1028;
    public static final String MSG_SEND_SMS_FAIL = "send sms fail";

    /** 账号或密码错误 */
    public static final int INCORRECT_NUMBER_OR_PASSWORD = 1029;
    public static final String MSG_INCORRECT_NUMBER_OR_PASSWORD = "incorrect number of password";

    /** 无正在上的课 */
    public static final int NO_TEACHING_LESSON = 1030;
    public static final String MSG_NO_TEACHING_LESSON = "no teaching lesson";

    /** 无授课 */
    public static final int NO_TEACHER_LESSON_FOUND = 1031;
    public static final String MSG_NO_TEACHER_LESSON_FOUND = "no teacher lesson found";

    /** 检测状态线程还在运行 */
    public static final int STILL_CHECKING = 1032;
    public static final String MSG_STILL_CHECKING = "still checking";

    /** 文件为空 */
    public static final int FILE_EMPTY = 1033;
    public static final String MSG_FILE_EMPTY = "file empty";

    /** 该权限组不可进行操作 */
    public static final int PERMISSION_GROUP_WITHOUT_OPERATION = 1034;
    public static final String MSG_PERMISSION_GROUP_WITHOUT_OPERATION = "permission group without operation";

    /** 没有该知识点 */
    public static final int NO_SUCH_KNOWLEDGE = 1035;
    public static final String MSG_NO_SUCH_KNOWLEDGE = "no such knowledge";

    // 一些可能共性的异常code 9000~9999
    /** 接口已下线 */
    public static final int INTERFACE_OFFLINE = 9000;
    public static final String MSG_INTERFACE_OFFLINE = "interface is offline";

    /** 数据库错误 */
    public static final int DB_ERROR = 9001;
    public static final String MSG_DB_ERROR = "db error";

    /** 参数非法 */
    public static final int PARAMETER_INVALID = 9002;
    public static final String MSG_PARAMETER_INVALID = "parameter invalid";

    /** 非法访问 */
    public static final int ILLEGAL_ACCESS = 9003;
    public static final String MSG_ILLEGAL_ACCESS = "illegal access";

    /** 外键约束 */
    public static final int FOREIGN_KEY_CONSTRAINT = 9004;
    public static final String MSG_FOREIGN_KEY_CONSTRAINT = "foreign key constraint";

    /** 系统错误 */
    public static final int ERROR_SYSTEM_EXCEPTION = 9999;
    public static final String MSG_ERROR_SYSTEM_EXCEPTION = "system error";

}
