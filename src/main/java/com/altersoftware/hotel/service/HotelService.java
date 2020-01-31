package com.altersoftware.hotel.service;

import com.altersoftware.hotel.entity.HotelDO;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * @author czy@win10
 * @date 2020/1/30 21:42
 */
public interface HotelService {

    /**
     * 查看酒店信息
     * 
     * @return
     */
    ResultDO<HotelDO> showHotel(long id);

    /**
     * 修改酒店信息
     * 
     * @return
     */
    ResultDO<Void> updateHotel(HotelDO hotelDO);

    /**
     * 增加一条酒店信息
     * 
     * @return
     */
    ResultDO<Void> insertHotel(HotelDO hotelDO);
}
