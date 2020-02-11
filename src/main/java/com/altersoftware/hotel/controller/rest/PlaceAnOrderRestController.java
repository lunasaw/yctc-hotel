package com.altersoftware.hotel.controller.rest;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.altersoftware.hotel.entity.RecordDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.vo.RecordVO;

/**
 * @author Iszychen@win10
 * @date 2020/2/7 22:16
 */
public interface PlaceAnOrderRestController {
    /**
     * 创建订单
     * 
     * @param recordVO
     * @return
     */
    ResultDO<RecordDO> acceptOrder(RecordVO recordVO) throws ParseException;

    /**
     * 支付宝确认是否支付成功
     *
     * @param request
     * @param response
     * @throws IOException
     */
    void getUnSignData(HttpServletRequest request, HttpServletResponse response) throws IOException;

    /**
     * 返回是否已支付订单
     *
     * @param recordId
     * @return
     */
    ResultDO<RecordDO> returnRecord(long recordId);
}
