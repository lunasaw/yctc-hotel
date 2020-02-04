package com.altersoftware.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.altersoftware.hotel.entity.VipDO;

/**
 * @author czy@win10
 * @date 2020/2/4 14:12
 */
@Mapper
public interface VipDAO {
    /**
     * 插入一条VIP会员信息
     *
     *
     */
    @Insert(" INSERT INTO tb_vip (id, customer_id, grade, pay_amount, create_time, modify_time ) "
        +
        "VALUES(#{id}, #{customerNumber}, #{grade}, #{amount}, now(), now()) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(VipDO vipDO);

    /**
     * id查找VIP会员消息
     *
     * @param id
     */
    @Select("select id, customer_id, grade, pay_amount, create_time, modify_time from tb_vip where id=#{id}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "customerNumber", column = "customer_id"),
        @Result(property = "grade", column = "grade"),
        @Result(property = "amount", column = "pay_amount"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    VipDO getVipDOById(long id);

    /**
     * id查找所有VIP会员消息
     *
     * @param
     */
    @Select("select id, customer_id, grade, pay_amount, create_time, modify_time from tb_vip ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "customerNumber", column = "customer_id"),
        @Result(property = "grade", column = "grade"),
        @Result(property = "amount", column = "pay_amount"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<VipDO> getVipDOList();

    /**
     * 更新VIP会员消息
     *
     * @param vipDO
     */
    @Update("update tb_vip  set customer_id=#{customerNumber}, grade=#{grade}, pay_amount=#{amount}, modify_time=now() where id=#{id}")
    int update(VipDO vipDO);

    /**
     * 根据id删除一条VIP会员消息
     *
     * @param id
     */
    @Delete("DELETE FROM tb_vip WHERE id=#{id}")
    int deleteById(long id);

    /**
     * 返回VIP会员number list
     *
     * @return
     */
    @Select("select customerNumber  from tb_vip ")
    List<Long> getVipIdList();

}
