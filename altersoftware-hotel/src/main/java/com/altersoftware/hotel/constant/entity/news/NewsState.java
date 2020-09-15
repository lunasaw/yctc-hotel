package com.altersoftware.hotel.constant.entity.news;

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * 通知阅读状态枚举
 * 
 * @author 15272
 */
public class NewsState {

    /** 未读 */
    public static final int UNREAD = 0;

    /** 已读 */
    public static final int READED = 1;

    public static final List<Integer> ALL_STATE = ImmutableList.of(UNREAD, READED);

    public static boolean isLegal(int state) {
        for (Integer integer : ALL_STATE) {
            if (integer == state) {
                return true;
            }
        }
        return false;
    }
}
