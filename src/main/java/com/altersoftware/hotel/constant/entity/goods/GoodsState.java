package com.altersoftware.hotel.constant.entity.goods;

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * @author czy@win10
 * @date 2020/1/27 23:23
 */
public class GoodsState {

    /** 关 未借出 */
    public static final String       UNLEND      = "0";

    /** 开 已借出 */
    public static final String       LENDED      = "1";

    /** 温度 */
    public static final String       TEMPERATURE = "30";

    public static final List<String> ALL_STATE   = ImmutableList.of(UNLEND, LENDED, TEMPERATURE);

    public static boolean isLegal(String state) {
        for (String integer : ALL_STATE) {
            if (integer.equals(state)) {
                return true;
            }
        }
        return false;
    }

}
