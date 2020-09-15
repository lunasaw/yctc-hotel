package com.altersoftware.hotel.controller.rest.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.controller.rest.MealdistributionRestController;
import com.altersoftware.hotel.entity.MealdistributionDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.MealdistributionService;

/**
 * @author hzx
 * @date 2020/2/16 16:32
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/meal")
public class MealdistributionRestControllerImpl implements MealdistributionRestController {


    @Resource
    private MealdistributionService mealdistributionService;

    /**
     * 配送订单存入数据库
     *
     * @param mealdistribution
     * @return
     */
    @Override
    @PostMapping("accept-meal")
    public ResultDO<Void> createMealdistribution(@RequestBody MealdistributionDO mealdistribution) {
       return null;
    }

    /**
     * 展示配送订单信息
     *
     * @param id
     */
    @Override
    @PostMapping("get-byid")
    public ResultDO<MealdistributionDO> showMealdistribution(long id) {
        // 参数校验
        if (id <= 0) {
            return new ResultDO<MealdistributionDO>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<MealdistributionDO> mealdistributionDOResultDO = mealdistributionService.showMealdistribution(id);
        if (mealdistributionDOResultDO.isSuccess() == false) {
            return new ResultDO<MealdistributionDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {

            return new ResultDO<MealdistributionDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, mealdistributionDOResultDO.getModule());
        }
    }

    /**
     * 菜单编号展示配送订单信息
     *
     * @param order
     */
    @Override
    @PostMapping("get-byorder")
    public ResultDO<MealdistributionDO> showMealdistributionByOrder(long order) {
        // 参数校验
        if (order <= 0) {
            return new ResultDO<MealdistributionDO>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<MealdistributionDO> mealdistributionDOResultDO = mealdistributionService.showMealdistributionByOrder(order);
        if (mealdistributionDOResultDO.isSuccess() == false) {
            return new ResultDO<MealdistributionDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {

            return new ResultDO<MealdistributionDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, mealdistributionDOResultDO.getModule());
        }
    }

    /**
     * 修改配送订单信息
     *
     * @param mealdistribution
     */
    @Override
    @PostMapping("update")
    public ResultDO<Void> updateMealdistribution(@RequestBody MealdistributionDO mealdistribution) {
        // 参数校验
        if (mealdistribution.getId() <= 0 || mealdistribution.getOrderId() <= 0 || mealdistribution.getRoomNumber() <= 0
                || mealdistribution.getStaffId() <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<MealdistributionDO> mealdistributionDOResultDO = mealdistributionService.showMealdistribution(mealdistribution.getId());
        if (mealdistributionDOResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            MealdistributionDO doResultDOModule = mealdistributionDOResultDO.getModule();
            doResultDOModule.setOrderId(mealdistribution.getOrderId());
            doResultDOModule.setId(mealdistribution.getId());
            doResultDOModule.setStaffId(mealdistribution.getStaffId());
            doResultDOModule.setRoomNumber(mealdistribution.getRoomNumber());

            ResultDO<Void> voidResultDO = mealdistributionService.updateMealdistribution(doResultDOModule);
            if (mealdistributionDOResultDO.isSuccess() == false) {
                return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                        ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            } else {

                return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
            }
        }
    }

    /**
     * 删除配送订单信息
     *
     * @return
     */
    @Override
    @PostMapping("delete-byid")
    public ResultDO<Void> deleteById(long id) {
        // 参数校验
        if (id <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<Void> voidResultDO = mealdistributionService.deleteById(id);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {

            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    /**
     * 删除部分配送订单信息
     *
     * @return
     */
    @Override
    @PostMapping("delete-byids")
    public ResultDO<Void> deleteList(@RequestBody Long[] ids) {
        //参数校验
        if (ids == null || ids.length == 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        List<Long> resultList = new ArrayList<>(ids.length);
        for (Long s : ids) {
            resultList.add(s);
        }
        ResultDO<Void> voidResultDO = mealdistributionService.deleteList(resultList);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    /**
     * 查询所有配送订单信息
     *
     * @return
     */
    @Override
    @PostMapping("get-all")
    public ResultDO<List<MealdistributionDO>> getAll() {
        ResultDO<List<MealdistributionDO>> serviceAll = mealdistributionService.getAll();
        if (serviceAll.isSuccess() == false) {
            return new ResultDO<List<MealdistributionDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<List<MealdistributionDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,serviceAll.getModule());
        }
    }

    /**
     * 通过员工编号获取配送订单信息
     *
     * @param staffId
     * @return
     */
    @Override
    @PostMapping("get-bystaff")
    public ResultDO<List<MealdistributionDO>> getListByStaffId(long staffId) {
        // 参数校验
        if (staffId <= 0) {
            return new ResultDO<List<MealdistributionDO>>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<List<MealdistributionDO>> listByStaffId = mealdistributionService.getListByStaffId(staffId);
        if (listByStaffId.isSuccess() == false) {
            return new ResultDO<List<MealdistributionDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<List<MealdistributionDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,listByStaffId.getModule());
        }
    }

    /**
     * 通过房间编号获取配送订单信息
     *
     * @param roomNumber
     * @return
     */
    @Override
    @PostMapping("get-byroom")
    public ResultDO<List<MealdistributionDO>> getListByRoomNumber(int roomNumber) {
        // 参数校验
        if (roomNumber <= 0) {
            return new ResultDO<List<MealdistributionDO>>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<List<MealdistributionDO>> listByRoom = mealdistributionService.getListByRoom(roomNumber);
        if (listByRoom.isSuccess() == false) {
            return new ResultDO<List<MealdistributionDO>>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<List<MealdistributionDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,listByRoom.getModule());
        }
    }

    /**
     * 获取当前正在配送的订单
     *
     * @return
     */
    @Override
    @PostMapping("get-bystaffnow")
    public ResultDO<MealdistributionDO> getNow(long staffId) {
        // 参数校验
        if (staffId <= 0) {
            return new ResultDO<MealdistributionDO>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }

        ResultDO<MealdistributionDO> mealdistributionDOResultDO = mealdistributionService.getNow(staffId);
        if (mealdistributionDOResultDO.isSuccess() == false) {
            return new ResultDO<MealdistributionDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<MealdistributionDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,mealdistributionDOResultDO.getModule());
        }
    }

    /**
     * 完成配送
     */
    @Override
    @PostMapping("end")
    public ResultDO<Void> end(long id) {
        // 参数校验
        if (id <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<Void> voidResultDO = mealdistributionService.end(id);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }

    /**
     * 开始配送
     */
    @Override
    @PostMapping("start")
    public ResultDO<Void> start(long id) {
        // 参数校验
        if (id <= 0) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<Void> voidResultDO = mealdistributionService.start(id);
        if (voidResultDO.isSuccess() == false) {
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        }
    }
}
