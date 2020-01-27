package com.altersoftware.hotel.constant.entity.goods;

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * @author czy@win10
 * @date 2020/1/27 23:23
 */
public class GoodsState {

    /** 未借出 */
    public static final int           UNLEND    = 0;

    /** 已借出 */
    public static final int           LENDED    = 1;

    public static final List<Integer> ALL_STATE = ImmutableList.of(UNLEND, LENDED);

    public static boolean isLegal(int state) {
        for (Integer integer : ALL_STATE) {
            if (integer == state) {
                return true;
            }
        }
        return false;
    }

}
