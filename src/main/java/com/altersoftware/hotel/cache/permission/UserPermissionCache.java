package com.altersoftware.hotel.cache.permission;

import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.exception.GenesisException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * userId对应permission List的缓存
 *
 * @author wlt
 */
public class UserPermissionCache {

    private final static Logger LOG = LoggerFactory.getLogger("permissionContentHolderLogger");

    /** userId对应登录用户permission集的Map */
    private static final Map<Long, List<String>> USERID_2_PERMISSION_LIST_MAP = new HashMap<>();

    /** userId对应登录用户获取permissionListTime的Map */
    private static final Map<Long, Date> PERMISSION_LIST_TIME_MAP = new HashMap<>();

    /** permission失效判断时间周期为30分钟，单位为秒 */
    private static final int SURVIVE_TIME = 30 * 60;

    /** 失效permission线程池 */
    private static final ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
        new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
    /** 服务端最大permission容量 */
    private static final int PERMISSION_LIST_MAX_QUANTITY = 10000;

    /**
     * 通过userId获取permission集
     *
     * @param userId
     * @return
     */
    public static ResultDO<List<String>> getPermissionListByUserId(long userId) {
        if (userId <= 0) {
            LOG.error("userId error, get permission by userId error, parameter illegal, userId={}", userId);
            return new ResultDO<List<String>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        if (USERID_2_PERMISSION_LIST_MAP.containsKey(userId) == false) {
            return new ResultDO<List<String>>(false, ResultCode.NO_PERMISSION_CACHE,
                ResultCode.MSG_NO_PERMISSION_CACHE);
        }
        return new ResultDO<List<String>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            USERID_2_PERMISSION_LIST_MAP.get(userId));
    }

    /**
     * 添加用户权限permission集
     *
     * @param userId
     * @param permissions
     */
    public static ResultDO<Void> addPermissionList(long userId, List<String> permissions) {
        if (CollectionUtils.isEmpty(permissions) || userId <= 0) {
            LOG.error("userId error, get permission by userId error, parameter illegal, userId={}", userId);
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        if (USERID_2_PERMISSION_LIST_MAP.containsKey(userId)) {
            USERID_2_PERMISSION_LIST_MAP.remove(userId);
        }
        USERID_2_PERMISSION_LIST_MAP.put(userId, permissions);
        // 获取当前系统时间
        Date timeOfGetPermission = new Date();
        if (userId <= 0 || timeOfGetPermission == null) {
            throw new GenesisException(ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        PERMISSION_LIST_TIME_MAP.put(userId, timeOfGetPermission);
        return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
    }

    /**
     * 用userId删除权限permission集
     *
     * @param userId
     */
    public static ResultDO<Void> deletePermissionListByUserId(long userId) {
        if (userId <= 0) {
            LOG.error("userId error, get permission by userId error, parameter illegal, userId={}", userId);
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        if (!USERID_2_PERMISSION_LIST_MAP.containsKey(userId)) {
            return new ResultDO<Void>(false, ResultCode.NO_PERMISSION_CACHE, ResultCode.MSG_NO_PERMISSION_CACHE);
        }
        USERID_2_PERMISSION_LIST_MAP.remove(userId);
        return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
    }

    /**
     * PermissionContentHolder类的构造方法
     *
     * @param
     */
    static {
        // 登录用户的permission失效（ScheduledThreadPoolExecutor的 scheduleAtFixedRate方法）
        executorService.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                ArrayList<Map.Entry<Long, Date>> timeOfGetPermissionList =
                    new ArrayList<>(PERMISSION_LIST_TIME_MAP.entrySet());
                Collections.sort(timeOfGetPermissionList, new Comparator<Map.Entry<Long, Date>>() {

                    @Override
                    public int compare(Map.Entry<Long, Date> o1, Map.Entry<Long, Date> o2) // 升序
                    {
                        try {
                            if (o2.getValue() != null && o1.getValue() != null
                                && o2.getValue().compareTo(o1.getValue()) > 0) {
                                return 1;
                            } else {
                                return -1;
                            }
                        } catch (Exception e) {
                            LOG.error("time of get permission sort error", e);
                        }
                        return 0;
                    }
                });

                int num = timeOfGetPermissionList.size();
                // 判断是否大于浏览器最大容量并删除map中对应的permission
                while (num >= PERMISSION_LIST_MAX_QUANTITY) {
                    for (int i = 0; i <= num - PERMISSION_LIST_MAX_QUANTITY; i++) {
                        /** key是通过loginTimeList获得的对应要删除的userId */
                        long key = (timeOfGetPermissionList.get(i)).getKey();
                        USERID_2_PERMISSION_LIST_MAP.remove(key);
                        PERMISSION_LIST_TIME_MAP.remove(key);
                    }
                }

            }
        }, SURVIVE_TIME, SURVIVE_TIME, TimeUnit.MILLISECONDS); // 延时30分钟后，按30分钟的周期执行任务

        LOG.info("user permission has been deleted");
    }
}
