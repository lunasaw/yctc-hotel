package com.altersoftware.hotel.controller.rest.impl;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.controller.rest.FloorRestController;
import com.altersoftware.hotel.entity.ResultDO;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author czy@win10
 * @date 2020/1/28 21:13
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/floor")
public class FloorRestControllerImpl implements FloorRestController {


    @Autowired
    FloorService floorService;

    @Override
    @PostMapping("show2d")
    public ResultDO<String> show2D(long id) {
        ResultDO<String> resultDO = floorService.show2D(id);

        if ( resultDO.isSuccess() == false ) {
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        } else {
            String twoD = resultDO.getModule();
            return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, twoD);
        }

    }

    @Override
    @PostMapping("showfire")
    public ResultDO<String> showFire(long id) {
        ResultDO<String> resultDO = floorService.showFire(id);

        if ( resultDO.isSuccess() == false ){
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        else{
            String fire = resultDO.getModule();
            return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, fire);
        }
    }

    @Override
    @PostMapping("show3d")
    public ResultDO<String> show3D(long id) {
        ResultDO<String> resultDO = floorService.show3D(id);

        if ( resultDO.isSuccess() == false ){
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        else{
            String threeD = resultDO.getModule();
            return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, threeD);
        }
    }

    @Override
    @PostMapping("showIdList")
    public ResultDO<List<Long>> showIdList() {
        ResultDO<List<Long>> listResultDO = floorService.showFloorId();
        if (listResultDO.isSuccess() == false){
            return new ResultDO<List<Long>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);

        }else {
            List<Long> module = listResultDO.getModule();
            return new ResultDO<List<Long>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, module);

        }
    }
}
