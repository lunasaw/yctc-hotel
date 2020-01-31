package com.altersoftware.hotel.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.dao.HotelDAO;
import com.altersoftware.hotel.entity.HotelDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.HotelService;

/**
 * @author czy@win10
 * @date 2020/1/30 21:46
 */
@ComponentScan({"com.altersoftware.hotel.dao"})
@Service("hotelService")
public class HotelServiceImpl implements HotelService {
    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Resource
    private HotelDAO            hotelDAO;

    @Override
    public ResultDO<HotelDO> showHotel(long id) {
        try {
            HotelDO hotelDOById = hotelDAO.getHotelDOById(id);
            LOG.info("getHotelDOById success, hotelDOById={}", hotelDOById);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, hotelDOById);
        } catch (Exception e) {
            LOG.error("getHotelDOById error, Id={}", id, e);
            return new ResultDO<>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA);
        }
    }

    @Override
    public ResultDO<Void> updateHotel(HotelDO hotelDO) {
        int update = hotelDAO.update(hotelDO);
        if (update == 1) {
            LOG.info("updateHotel success, hotelDO={}", hotelDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } else {
            LOG.error("updateHotel error, updateHotel={}", hotelDO);
            return new ResultDO<>(false, ResultCode.UPDATE_FAILD,
                ResultCode.MSG_UPDATE_FAILD);
        }
    }

    @Override
    public ResultDO<Void> insertHotel(HotelDO hotelDO) {
        try {
            hotelDAO.insert(hotelDO);
            LOG.info("insertHotel success, hotelDO={}", hotelDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("insertHotel error, hotelDO={}", hotelDO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }
}
