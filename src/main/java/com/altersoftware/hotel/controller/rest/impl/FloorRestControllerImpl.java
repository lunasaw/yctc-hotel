package com.altersoftware.hotel.controller.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.controller.rest.FloorRestController;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.FloorService;

/**
 * @author czy@win10
 * @date 2020/1/28 21:13
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/floor")
public class FloorRestControllerImpl implements FloorRestController {
    private static final String NEWS_DETAIL = "/hotel/news/news-detail?id=";

    @Autowired
    FloorService                floorService;

    @Override
    @PostMapping("show2d")
    public ResultDO<String> show2D(@RequestBody long id) {

        ResultDO<String> resultDO = null;

        resultDO = floorService.show2D(id);

        if (resultDO.isSuccess() == false) {
            return new ResultDO<String>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            String twoD = resultDO.getModule();
            return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, twoD);
        }

    }

    @Override
    @PostMapping("showfire")
    public ResultDO<String> showFire(@RequestBody long id) {
        ResultDO<String> resultDO = floorService.showFire(id);

        if (resultDO.isSuccess() == false) {
            return new ResultDO<String>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            String fire = resultDO.getModule();
            return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, fire);
        }
    }

    @Override
    @PostMapping("show3d")
    public ResultDO<String> show3D(@RequestBody long id) {
        ResultDO<String> resultDO = floorService.show3D(id);

        if (resultDO.isSuccess() == false) {
            return new ResultDO<String>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            String threeD = resultDO.getModule();
            return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, threeD);
        }
    }

    @Override
    @PostMapping("showIdList")
    public ResultDO<List<Long>> showIdList() {
        ResultDO<List<Long>> listResultDO = floorService.showFloorId();
        if (listResultDO.isSuccess() == false) {
            return new ResultDO<List<Long>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA,
                null);

        } else {
            List<Long> module = listResultDO.getModule();
            return new ResultDO<List<Long>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, module);

        }
    }
}
