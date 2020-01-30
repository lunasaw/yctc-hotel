package com.altersoftware.hotel.controller.rest;

import java.util.List;

import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;

public interface CustomerRestController {

    /**
     * 获取所有客户信息
     *
     * @return
     */
    ResultDO<List<UserDO>> getAllCustomer();

    /**
     * 修改客户信息
     *
     * @param userId
     * @return
     */
    ResultDO<Void> updateUserDO(Long userId);

    /**
     * 删除指定客户信息
     *
     * @param userId
     * @return
     */
    ResultDO<Void> deleteByUserId(Long userId);

    /**
     * 会员号搜索客户/员工
     *
     * @param number
     * @return
     */
    ResultDO<UserDO> getByNumber(String number);

}
