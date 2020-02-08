package com.altersoftware.hotel.controller.rest;

import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.vo.RecordVO;

/**
 * @author Iszychen@win10
 * @date 2020/2/7 22:16
 */
public interface PlaceAnOrderRestController {
    /**
     * *
     * 
     * @param recordVO
     * @return
     */
    ResultDO<RecordVO> acceptOrder(RecordVO recordVO);
}
