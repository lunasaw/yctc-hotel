package com.altersoftware.hotel.controller.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.controller.rest.HotelRestController;
import com.altersoftware.hotel.entity.HotelDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.HotelService;

/**
 * @author hzx
 * @date
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/hotelinfo")
public class HotelRestControllerImpl implements HotelRestController {



    @Autowired
    HotelService hotelService;

    /**
     *
     * 查看酒店信息
     * 
     * @return
     */
    @Override
    @PostMapping("show-hotel")
    public ResultDO<HotelDO> showHotel(long id) {
        // 参数校验
        if (id <= 0) {
            return new ResultDO<HotelDO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<HotelDO> hotelDOResultDO = hotelService.showHotel(id);
        if (hotelDOResultDO.isSuccess() == false) {
            return new ResultDO<HotelDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            HotelDO hotelDOResultDOModule = hotelDOResultDO.getModule();
            return new ResultDO<HotelDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, hotelDOResultDOModule);
        }
    }

    /**
     * 更新酒店信息
     * @param hotelDO
     * @return
     */
    @Override
    @PostMapping("update")
    public ResultDO<Void> updateHotel(@RequestBody HotelDO hotelDO) {
        // 参数校验
        if (hotelDO.getId() <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<HotelDO> hotelDOResultDO = hotelService.showHotel(hotelDO.getId());
        if (hotelDOResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            HotelDO hotelDOResultDOModule = hotelDOResultDO.getModule();
            hotelDOResultDOModule.setAddress(hotelDO.getAddress());
            hotelDOResultDOModule.setFloorNumbers(hotelDO.getFloorNumbers());
            hotelDOResultDOModule.setMobile(hotelDO.getMobile());
            hotelDOResultDOModule.setName(hotelDO.getName());
            hotelDOResultDOModule.setRules(hotelDO.getRules());

            ResultDO<Void> voidResultDO = hotelService.updateHotel(hotelDOResultDOModule);
            if ( voidResultDO.isSuccess() == false ){
                return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                        ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            }
            else {
                return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
            }

        }

    }

    /**
     * 插入一条酒店信息
     * @param hotelDO
     * @return
     */
    @Override
    @PostMapping("add-hotel")
    public ResultDO<Void> insertHotel(@RequestBody HotelDO hotelDO) {
        // 参数校验
        if (hotelDO.getId() <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<Void> voidResultDO = hotelService.insertHotel(hotelDO);
        if ( voidResultDO.isSuccess() == false ){
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
    }
    else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }

    }
}
