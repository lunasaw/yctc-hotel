package com.altersoftware.hotel.constant.entity.department;

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * @author Iszychen@win10
 * @date 2020/2/17 19:18
 */
public class DepartmentType {

    /** 后勤部 */
    public static final long       LOGISTICS                    = 97001;
    /** 保卫部 */
    public static final long       SECURITY_DEPARTMENT          = 97002;
    /** 策划部 */
    public static final long       PLANNING_DEPARTMENT          = 97003;
    /** 宣传部 */
    public static final long       PROPAGANDA_DEPARTMENT        = 97004;
    /** 财政部 */
    public static final long       TREASURY_DEPARTMENT          = 97005;
    /** 人事部 */
    public static final long       MINISTRY_OF_PERSONNEL        = 97006;
    /** 礼仪部 */
    public static final long       ETIQUETTE_DEPARTMENT         = 97007;
    /** 餐饮部 */
    public static final long       FOOD_AND_BEVERAGE_DEPARTMENT = 97008;

    public static final List<Long> ALL_STATE                    =
        ImmutableList.of(LOGISTICS, SECURITY_DEPARTMENT, PLANNING_DEPARTMENT, PROPAGANDA_DEPARTMENT,
            TREASURY_DEPARTMENT, MINISTRY_OF_PERSONNEL, ETIQUETTE_DEPARTMENT, FOOD_AND_BEVERAGE_DEPARTMENT);

    public static boolean isLegal(Long state) {
        for (Long integer : ALL_STATE) {
            if (integer == state) {
                return true;
            }
        }
        return false;
    }
}
