package com.altersoftware.hotel.service;

import java.util.List;

import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.VipGradeDO;

/**
 * @author Iszychen@win10
 * @date 2020/2/6 18:09
 */
public interface VipGradeService {
    /**
     * 插入一条等级信息
     *
     * @param vipGradeDO
     * @return
     */
    ResultDO<Void> insert(VipGradeDO vipGradeDO);

    /**
     * 展示等级信息
     *
     * @param id
     */
    ResultDO<VipGradeDO> showVipGrade(long id);

    /**
     * 修改等级信息
     *
     * @param vipGradeDO
     */
    ResultDO<Void> updateVipGrade(VipGradeDO vipGradeDO);

    /**
     * 根据等级查询信息信息
     *
     * @param grade
     */
    ResultDO<List<VipGradeDO>> showVipGradeByGrade(String grade);

    /**
     * 查询所有等级权益信息
     * 
     * @return
     */
    ResultDO<List<VipGradeDO>> showVipGradeList();

    /**
     * 删除等级信息
     *
     * @return
     */
    ResultDO<Void> deleteById(long id);

}
