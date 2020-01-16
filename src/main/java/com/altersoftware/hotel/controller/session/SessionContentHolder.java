package com.altersoftware.hotel.controller.session;

import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.exception.GenesisException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * sessonId对应业务id的托管
 *
 * @author 15272
 */
public class SessionContentHolder {

    private final static Logger LOG = LoggerFactory.getLogger("sessionContentHolderLogger");

    /** sessionId对应登录用户userId的Map */
    private static final Map<String, Long> SESSION_2_SIGN_IN_USER_ID_MAP = new HashMap<>();

    /** sessionId对应登录用户userLoginTime的Map */
    private static final Map<String, Date> SESSION_SIGN_IN_USER_TIME_MAP = new HashMap<>();

    /** sessionId对应找密mail的Map */
    private static final Map<String, String> SESSION_MAIL_MAP = new HashMap<>();

    /** sessionId对应找密的phone的Map */
    private static final Map<String, String> SESSION_PHONE_MAP = new HashMap<>();

    /** session失效判断时间周期为30分钟，单位为秒 */
    private static final int SURVIVE_TIME = 30 * 60;

    /** 失效session线程池 */
    private static final ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
        new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
    /** 服务端最大session容量 */
    private static final int SESSION_MAX_QUANTITY = 10000;

    /**
     * SessionContentHolder类的构造方法
     *
     * @param
     */
    static {
        // 登录用户的session失效（ScheduledThreadPoolExecutor的 scheduleAtFixedRate方法）
        executorService.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                ArrayList<Map.Entry<String, Date>> loginTimeList =
                    new ArrayList<>(SESSION_SIGN_IN_USER_TIME_MAP.entrySet());
                Collections.sort(loginTimeList, new Comparator<Map.Entry<String, Date>>() {

                    @Override
                    public int compare(Map.Entry<String, Date> o1, Map.Entry<String, Date> o2) // 升序
                    {
                        try {
                            if (o2.getValue() != null && o1.getValue() != null
                                && o2.getValue().compareTo(o1.getValue()) > 0) {
                                return 1;
                            } else {
                                return -1;
                            }
                        } catch (Exception e) {
                            LOG.error("login time sort error", e);
                        }
                        return 0;
                    }
                });

                int num = loginTimeList.size();
                // 判断是否大于浏览器最大容量并删除map中对应的session
                while (num >= SESSION_MAX_QUANTITY) {
                    for (int i = 0; i <= num - SESSION_MAX_QUANTITY; i++) {
                        /** key是通过loginTimeList获得的对应要删除的sessionId */
                        String key = (loginTimeList.get(i)).getKey();
                        SESSION_2_SIGN_IN_USER_ID_MAP.remove(key);
                        SESSION_SIGN_IN_USER_TIME_MAP.remove(key);
                    }
                }

            }
        }, SURVIVE_TIME, SURVIVE_TIME, TimeUnit.MILLISECONDS); // 延时30分钟后，按30分钟的周期执行任务

        LOG.info("user session has been deleted");
    }

    /**
     * 通过sessionId获取已经登录的userId
     *
     * @param sessionId
     * @return
     */
    public static long getSignInUserIdBySessionId(String sessionId) {
        if (StringUtils.isEmpty(sessionId)) {
            throw new GenesisException(ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        if (SESSION_2_SIGN_IN_USER_ID_MAP.containsKey(sessionId) == false) {
            throw new GenesisException(ResultCode.USER_NOT_SIGN_IN, ResultCode.MSG_USER_NOT_SIGN_IN);
        }
        return SESSION_2_SIGN_IN_USER_ID_MAP.get(sessionId);
    }

    /**
     * 添加登录用户session
     *
     * @param sessionId
     * @param userId
     */
    public static void addSignInUserId(String sessionId, long userId) {

        if (StringUtils.isEmpty(sessionId) || userId <= 0) {
            throw new GenesisException(ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        if (SESSION_2_SIGN_IN_USER_ID_MAP.containsKey(sessionId)
            || SESSION_2_SIGN_IN_USER_ID_MAP.containsValue(userId)) {
            SESSION_2_SIGN_IN_USER_ID_MAP.remove(sessionId);
            SESSION_2_SIGN_IN_USER_ID_MAP.put(sessionId, userId);
            return;
        }
        SESSION_2_SIGN_IN_USER_ID_MAP.put(sessionId, userId);

        // 获取当前系统时间
        Date loginTime = new Date();

        if (StringUtils.isEmpty(sessionId) || loginTime == null) {
            throw new GenesisException(ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }

        SESSION_SIGN_IN_USER_TIME_MAP.put(sessionId, loginTime);
    }

    /**
     * 用sessionId删除登录用户session
     *
     * @param sessionId
     */
    public static void deleteSignInSessionBySessionId(String sessionId) {
        if (StringUtils.isEmpty(sessionId)) {
            throw new GenesisException(ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        if (!SESSION_2_SIGN_IN_USER_ID_MAP.containsKey(sessionId)) {
            throw new GenesisException(ResultCode.NO_SUCH_USER, ResultCode.MSG_NO_SUCH_USER);
        }
        SESSION_2_SIGN_IN_USER_ID_MAP.remove(sessionId);
    }

    /**
     * sessionId得到phone
     *
     * @param sessionId
     * @return
     */
    public static String getPhoneBySessionId(String sessionId) {
        if (StringUtils.isEmpty(sessionId)) {
            throw new GenesisException(ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        if (SESSION_PHONE_MAP.containsKey(sessionId) == false) {
            return null;
        }
        return SESSION_PHONE_MAP.get(sessionId);
    }

    /**
     * sessionId得到mail
     *
     * @param sessionId
     * @return
     */
    public static String getMailBySessionId(String sessionId) {
        if (StringUtils.isEmpty(sessionId)) {
            throw new GenesisException(ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        if (SESSION_MAIL_MAP.containsKey(sessionId) == false) {
            return null;
        }
        return SESSION_MAIL_MAP.get(sessionId);
    }

    /**
     * map中添加mail
     *
     * @param sessionId
     * @param mail
     */
    public static void addMail(String sessionId, String mail) {
        if (StringUtils.isEmpty(sessionId) || StringUtils.isEmpty(mail)) {
            throw new GenesisException(ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        if (SESSION_MAIL_MAP.containsKey(sessionId) || SESSION_MAIL_MAP.containsValue(mail)) {
            SESSION_MAIL_MAP.remove(sessionId);
        }
        SESSION_MAIL_MAP.put(sessionId, mail);

        // 通过mail找密的session失效
        executorService.schedule(new Runnable() {

            @Override
            public void run() {
                SessionContentHolder.deleteMailSessionBySessionId(sessionId);
                LOG.info("mail session has been deleted, sessionId={}", sessionId);
            }
        }, SURVIVE_TIME, TimeUnit.SECONDS);
    }

    /**
     * map添加phone
     *
     * @param sesssionId
     * @param phone
     */
    public static void addPhone(String sessionId, String phone) {
        if (StringUtils.isEmpty(sessionId) || StringUtils.isEmpty(phone)) {
            throw new GenesisException(ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }

        if (SESSION_PHONE_MAP.containsKey(sessionId)) {
            SESSION_PHONE_MAP.remove(sessionId);
        }
        SESSION_PHONE_MAP.put(sessionId, phone);

        // 通过phone找密的session失效
        executorService.schedule(new Runnable() {

            @Override
            public void run() {
                SessionContentHolder.deletePhoneSessionBySessionId(sessionId);
                LOG.info("mail session has been deleted, sessionId={}", sessionId);
            }
        }, SURVIVE_TIME, TimeUnit.SECONDS);
    }

    /**
     * map中删除mail
     *
     * @param sessionId
     */
    public static void deleteMailSessionBySessionId(String sessionId) {
        if (StringUtils.isEmpty(sessionId)) {
            throw new GenesisException(ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        if (SESSION_MAIL_MAP.containsKey(sessionId) == false) {
            throw new GenesisException(ResultCode.NO_SUCH_MAIL, ResultCode.MSG_NO_SUCH_MAIL);
        }
        SESSION_MAIL_MAP.remove(sessionId);

        // 通过mail找密的session失效
        executorService.schedule(new Runnable() {

            @Override
            public void run() {
                SessionContentHolder.deleteMailSessionBySessionId(sessionId);
                LOG.info("mail session has been deleted, sessionId={}", sessionId);
            }
        }, SURVIVE_TIME, TimeUnit.SECONDS);
    }

    /**
     * map中删除phone
     *
     * @param sessionId
     */
    public static void deletePhoneSessionBySessionId(String sessionId) {
        if (StringUtils.isEmpty(sessionId)) {
            throw new GenesisException(ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        if (SESSION_PHONE_MAP.containsKey(sessionId) == false) {
            throw new GenesisException(ResultCode.NO_SUCH_PHONE, ResultCode.MSG_NO_SUCH_PHONE);
        }
        SESSION_PHONE_MAP.remove(sessionId);

        // 通过phone找密的session失效
        executorService.schedule(new Runnable() {

            @Override
            public void run() {
                SessionContentHolder.deletePhoneSessionBySessionId(sessionId);
                LOG.info("mail session has been deleted, sessionId={}", sessionId);
            }
        }, SURVIVE_TIME, TimeUnit.SECONDS);
    }

    /**
     * 判断是否登陆,返回userDO
     *
     * @param sessionId
     * @return
     */
    public static ResultDO<Long> judgeSignin(String sessionId) {
        if (StringUtils.isBlank(sessionId)) {
            throw new GenesisException(ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        if (SESSION_2_SIGN_IN_USER_ID_MAP.containsKey(sessionId)) {
            long id = SESSION_2_SIGN_IN_USER_ID_MAP.get(sessionId);
            if (id <= 0) {
                throw new GenesisException(ResultCode.NO_SUCH_USER, ResultCode.MSG_NO_SUCH_USER);
            }
            return new ResultDO<Long>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, id);
        }
        return new ResultDO<Long>(false, ResultCode.USER_NOT_SIGN_IN, ResultCode.MSG_USER_NOT_SIGN_IN, null);
    }
}
