package com.altersoftware.hotel.controller.rest;

import java.util.List;

import com.altersoftware.hotel.entity.RecordDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author Iszychen@win10
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
     * 查询所有订单信息
     *
     * @return
     */
    ResultDO<List<RecordDO>> getAll();

}
