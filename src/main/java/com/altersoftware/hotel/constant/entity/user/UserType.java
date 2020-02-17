package com.altersoftware.hotel.constant.entity.user;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class UserType {

    /** 客户 */
    public static final long CUSTOMER   = 90000;
    /** 管理员 */
    public static final long MANAGEMENT = 90001;
    /** 保洁 */
    public static final long CLEAN      = 90002;
    /** 前台 */
    public static final long RECEPTION  = 90003;
    /** 安保 */
    public static final long PROCTECT   = 90004;

    public static final List<Long> ALL_STATE  = ImmutableList.of(CUSTOMER, MANAGEMENT, CLEAN, RECEPTION, PROCTECT);

    public static boolean isLegal(long state) {
        for (long integer : ALL_STATE) {
            if (integer == state) {
                return true;
            }
        }
        return false;
    }
}
