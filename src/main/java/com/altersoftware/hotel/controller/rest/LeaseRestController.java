package com.altersoftware.hotel.controller.rest;

import java.util.List;

import com.altersoftware.hotel.entity.LeaseDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author czy@win10
 * @date 2020/1/31 21:53
 */
public interface LeaseRestController {
    /**
     * 插入一条租赁信息
     *
     * @param leaseDO
     * @return
     */
    ResultDO<LeaseDO> insert(LeaseDO leaseDO);

    /**
     * 展示租赁信息
     *
     * @param id
     */
    ResultDO<LeaseDO> showLease(long id);

    /**
     * 修改租赁信息
     *
     * @param leaseDO
     */
    ResultDO<Void> updateLease(LeaseDO leaseDO);

    /**
     * 根据客户Id查询租赁信息
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
     * 查询所有租赁信息
     *
     * @return
     */
    ResultDO<List<LeaseDO>> getAll();

    /**
     * 删除部分租赁信息
     *
     * @return
     */
    ResultDO<Void> deleteList(Long[] ids);
}
