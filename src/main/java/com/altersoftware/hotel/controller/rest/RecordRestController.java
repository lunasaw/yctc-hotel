package com.altersoftware.hotel.controller.rest;

import java.text.ParseException;
import java.util.List;

import com.altersoftware.hotel.entity.RecordDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author hzx
 * @date 2020/2/7 22:07
 */
public interface RecordRestController {

    /**
     * 展示订单信息
     *
     * @param id
     */
    ResultDO<RecordDO> showRecord(long id);

    /**
     * 根据员工编号查询订单信息List
     *
     * @param staffId
     */
    ResultDO<List<RecordDO>> showRecordBystaffId(long staffId);

    /**
     * 根据客户编号查询订单信息List
     *
     * @param customerId
     */
    ResultDO<List<RecordDO>> showRecordByCustomer(long customerId);

    /**
     * 通过客户id搜索房间
     *
     * @param CustomerId
     * @return
     */
    ResultDO<List<Integer>> getRoomByCustomerId(long CustomerId);

    /**
     * 修改订单信息
     *
     * @param recordDO
     */
    ResultDO<Void> updateRecord(RecordDO recordDO);

    /**
     * 根据房间门牌号查询订单信息
     *
     * @param roomNumber
     */
    ResultDO<List<RecordDO>> showRecordByRoomNumber(int roomNumber);

    /**
     * 删除订单信息
     *
     * @return
     */
    ResultDO<Void> deleteById(long id);

    /**
     * 删除部分订单信息
     *
     * @return
     */
    ResultDO<Void> deleteList(Long[] ids);

    /**
     * 查询所有订单信息
     *
     * @return
     */
    ResultDO<List<RecordDO>> getAll();

    /**
     * 通过房间号 返回当前时间内正在居住的用户
     * 
     * @param roomNumber
     * @return
     */
    ResultDO<Long> overClean(int roomNumber) throws ParseException;

    /**
     * 更新退房时间信息
     *
     * @param id
     */
    ResultDO<Void> updateOutime(long id, String evaluate);

}
