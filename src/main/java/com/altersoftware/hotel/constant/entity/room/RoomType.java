package com.altersoftware.hotel.constant.entity.room;

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * @author czy@win10
 * @date 2020/1/27 16:10
 */
public class RoomType {

    /** 大床房 */
    public static final String BIG_BEDROOM         = "10000";
    /** 价格 */
    public static final double BIG_BEDROOM_PRICE   = 180.5;
    /** 押金 */
    public static final double BIG_BEDROOM_DEPOSIT = 100.0;

    /** 双人间 */
    public static final String DOUBLE_ROOM         = "10001";
    /** 豪华套间 */
    public static final String RECEPTION           = "10002";

    public static final List<String> ALL_TYPE            = ImmutableList.of(BIG_BEDROOM, DOUBLE_ROOM);

    public static boolean isLegal(int state) {
        for (String integer : ALL_TYPE) {
            if (integer.equals(state)) {
                return true;
            }
        }
        return false;
    }
}
