package com.altersoftware.hotel.service;

import java.util.List;

import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.VipDO;

/**
 * @author Iszychen@win10
 * @date 2020/2/4 15:16
 */
public interface VipService {

    /**
     * 插入一条会员信息
     *
     * @param vipDO
     * @return
     */
    ResultDO<Void> insert(VipDO vipDO);

    /**
     * 展示会员信息
     *
     * @param id
     */
    ResultDO<VipDO> showVip(long id);

    /**
     * 修改会员信息
     *
     * @param vipDO
     */
    ResultDO<Void> updateVip(VipDO vipDO);

    /**
     * 根据房间查询会员信息
     *
     * @return <List<VipDO>>
     */
    ResultDO<List<VipDO>> showVipList();

    /**
     * 删除会员信息
     *
     * @return
     */
    ResultDO<Void> deleteById(String id);

    /**
     * 删除会员信息
     *
     * @return
     */
    ResultDO<Void> deleteList(List<String> ids);

    /**
     * 查询所有会员编号
     *
     * @return <List<VipDO>>
     */
    ResultDO<List<Long>> getAllNumberList();

}
