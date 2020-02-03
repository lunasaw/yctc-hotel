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
import com.altersoftware.hotel.entity.FloorDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.FloorService;

/**
 * @author hzx
 * @date 2020/1/28 21:13
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/floor")
public class FloorRestControllerImpl implements FloorRestController {
    private static final String NEWS_DETAIL = "/hotel/news/news-detail?id=";

    @Autowired
    FloorService                floorService;

    /**
     * 插入一条楼层信息
     *
     * @param floorDO
     * @return
     */
    @Override
    @PostMapping("add-floor")
    public ResultDO<Void> insert(@RequestBody FloorDO floorDO) {
        // 参数校验
        if (floorDO.getId() <= 0 || floorDO.getroomNumbers() <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<Void> voidResultDO = floorService.insert(floorDO);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    /**
     * 根据id查楼层信息
     * @param id
     * @return
     */
    @Override
    @PostMapping("get-byid")
    public ResultDO<FloorDO> showFloorDO(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<FloorDO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<FloorDO> floorDOResultDO = floorService.showFloorDO(id);
        if (floorDOResultDO.isSuccess() == false) {
            return new ResultDO<FloorDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            FloorDO doResultDOModule = floorDOResultDO.getModule();
            return new ResultDO<FloorDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, doResultDOModule);
        }
    }

    /**
     * 显示2d平面图
     * @param id
     * @return
     */
    @Override
    @PostMapping("show2d")
    public ResultDO<String> show2D(@RequestBody long id) {
        // 参数校验
        if (id <= 0) {
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
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

    /**
     * 显示消防图
     * @param id
     * @return
     */
    @Override
    @PostMapping("showfire")
    public ResultDO<String> showFire(@RequestBody long id) {
        if (id <= 0) {
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
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
        // 参数校验
        if (id <= 0) {
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
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
    @PostMapping("get-list")
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

    /**
     * 删除指定楼层信息
     *
     * @param id
     */
    @Override
    @PostMapping("delete-floor")
    public ResultDO<Void> delete(long id) {
        if (id <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<Void> voidResultDO = floorService.delete(id);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }

    }
}
