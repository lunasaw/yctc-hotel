package com.altersoftware.hotel.constant.entity.room;

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * @author czy@win10
 * @date 2020/1/27 16:28
 */
public class RoomState {

    /** 已入住 */
    public static final int           CHECK_IN  = 20000;
    /** 未入住 */
    public static final int           UNCHECKED = 20001;
    /** 已退房未打扫 */
    public static final int           CHECK_OUT = 20002;
    /** 已打扫 */
    public static final int           CLEANED   = 20003;

    public static final List<Integer> ALL_STATE = ImmutableList.of(CHECK_IN, UNCHECKED, CHECK_OUT, CLEANED);

    public static boolean isLegal(int state) {
        for (Integer integer : ALL_STATE) {
            if (integer == state) {
                return true;
            }
        }
        return false;
    }

}
