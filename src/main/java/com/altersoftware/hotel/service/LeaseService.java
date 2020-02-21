package com.altersoftware.hotel.service;

import java.util.List;

import com.altersoftware.hotel.entity.LeaseDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author Iszychen@win10
 * @date 2020/2/21 22:56
 */
public interface LeaseService {
    /**
     * 插入一条租赁信息
     *
     * @param lease
     * @return
     */
    ResultDO<Void> insert(LeaseDO lease);

    /**
     * 展示租赁信息
     *
     * @param id
     */
    ResultDO<LeaseDO> showLease(long id);

    /**
     * 修改租赁信息
     *
     * @param lease
     */
    ResultDO<Void> updateLease(LeaseDO lease);

    /**
     * 根据用户查询租赁信息
     *
     * @param customerId
     */
    ResultDO<List<LeaseDO>> showLeaseByCustomerId(long customerId);

    /**
     * 删除租赁信息
     *
     * @return
     */
    ResultDO<Void> deleteById(long id);

    /**
     * 删除部分租赁信息
     *
     * @return
     */
    ResultDO<Void> deleteList(List<Long> ids);

    /**
     * 查询所有租赁信息
     *
     * @return
     */
    ResultDO<List<LeaseDO>> getAll();
}
