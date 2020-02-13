package com.altersoftware.hotel.service;

import java.util.List;

import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;

/**
 * @author czy@win10
 * @date 2020/1/30 20:39
 */
public interface CustomerService {
    /**
     * 获取所有客户信息
     *
     * @return
     */
    ResultDO<List<UserDO>> getAllCustomer();

    /**
     * 修改客户信息
     *
     * @param userDO
     * @return
     */
    ResultDO<Void> updateUserDO(UserDO userDO);

    /**
     * 删除指定客户信息
     *
     * @param number
     * @return
     */
    ResultDO<Void> deleteByUserId(String number);

    /**
     * 删除部分客户信息
     *
     * @param numbers
     * @return
     */
    ResultDO<Void> deleteList(List<String> numbers);

    /**
     * 会员号搜索客户/员工
     *
     * @param number
     * @return
     */
    ResultDO<UserDO> getByNumber(String number);

    /**
     * 客户id搜索客户
     *
     * @param customerId
     * @return
     */
    ResultDO<UserDO> getByCustomerId(long customerId);
}
