package com.altersoftware.hotel.controller.rest.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSON;
import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.controller.rest.PlaceAnOrderRestController;
import com.altersoftware.hotel.entity.OrderDO;
import com.altersoftware.hotel.entity.RecordDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.RoomDO;
import com.altersoftware.hotel.service.OrderService;
import com.altersoftware.hotel.service.RecordService;
import com.altersoftware.hotel.service.RoomService;
import com.altersoftware.hotel.util.RandomNumber;
import com.altersoftware.hotel.vo.RecordVO;

/**
 * @author hzx
 * @date 2020/2/7 22:18
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/placeorder")
public class PlaceAnOrderRestControllerImpl implements PlaceAnOrderRestController {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Resource
    private RecordService       recordService;

    @Resource
    private RoomService         roomService;

    @Resource
    private OrderService        orderService;

    /**
     * 接收订单
     *
     * @param recordVO
     * @return
     */
    @Override
    @PostMapping("accept-order")
    public ResultDO<RecordDO> acceptOrder(@RequestBody RecordVO recordVO) throws ParseException {
        // 生成随机数
        RandomNumber randomNumber = new RandomNumber();
        // 参数校验
        if (recordVO.getCustomerId() <= 0 || StringUtils.isBlank(recordVO.getRoomTypeName())) {
            return new ResultDO<RecordDO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(recordVO.getCheckInTime());
        Date parse1 = simpleDateFormat.parse(recordVO.getCheckOutTime());
        LocalDate localDateIn = parse.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDateOut = parse1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long between = ChronoUnit.DAYS.between(localDateIn, localDateOut);
        recordVO.setPrecheckInTime(Long.toString(between));
        // 1.从前端接受类型名称
        // 2.在roomService中返回一个房间
        ResultDO<RoomDO> roomDOByRoomType1 = roomService.getRoomDOByRoomType(recordVO.getRoomTypeName());
        if (roomDOByRoomType1.isSuccess() == false) {
            return new ResultDO<RecordDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        } else {
            ResultDO<Double> actualMoney =
                recordService.getActualMoney(recordVO.getCustomerId(), roomDOByRoomType1.getModule().getRoomNumber());
            if (actualMoney.isSuccess() == false) {
                return new ResultDO<RecordDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            }
            // 3.将RecordDO构造插入订单
            RecordDO recordDO = new RecordDO();
            recordDO.setStaffId(recordVO.getStaffId());
            recordDO.setRoomNumber(roomDOByRoomType1.getModule().getRoomNumber());
            recordDO.setCustomerId(recordVO.getCustomerId());
            recordDO.setPrecheckInTime(recordVO.getPrecheckInTime());
            recordDO.setCheckInTime(recordVO.getCheckInTime());
            recordDO.setCheckOutTime(recordVO.getCheckOutTime());
            recordDO.setPayMoney(recordService
                .getActualMoney(recordVO.getCustomerId(), roomDOByRoomType1.getModule().getRoomNumber()).getModule());
            recordDO.setPayMoney(actualMoney.getModule());
            recordDO.setId(Long.parseLong(randomNumber.GetRandom()));
            ResultDO<Void> recordServiceRecord = recordService.createRecord(recordDO);
            if (recordServiceRecord.isSuccess() == false) {
                return new ResultDO<RecordDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                    ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            } else {
                return new ResultDO<RecordDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, recordDO);
            }

        }

    }

    /**
     * 处理订单
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    @PostMapping("deal-record")
    public void getUnSignData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String> params = new HashMap<>();
        try {
            // 这里拿到支付宝通知数据
            Map<String, String[]> requestParams = request.getParameterMap();
            for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
                String name = iter.next();
                String[] values = requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
                }
                // 乱码解决，这段代码在出现乱码时使用
                valueStr = new String(valueStr.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                params.put(name, valueStr);
                // System.out.println(params);
            }
            // 打印数据看看
            LOG.info("数据：" + JSON.toJSONString(requestParams));
            // 获取其中一个值看看
            // 订单编号
            String out_trade_no = params.get("out_trade_no");
            // 应支付金额
            String total_amount = params.get("total_amount");
            // 实际支付金额
            String buyer_pay_amount = params.get("buyer_pay_amount");
            // 实际收到金额
            String receipt_amount = params.get("receipt_amount");
            // 状态 TRADE_SUCCESS
            String trade_status = params.get("trade_status");
            if (trade_status.equals("TRADE_SUCCESS") == true && out_trade_no.length() == 11) {
                ResultDO<RecordDO> recordDOResultDO = recordService.showRecord(Long.parseLong(out_trade_no));
                RecordDO recordDO = recordDOResultDO.getModule();
                if (recordDOResultDO.isSuccess() && recordDOResultDO.isSuccess()
                    || Integer.parseInt(buyer_pay_amount) == recordDO.getPayMoney()) {
                    recordDO.setState(1);
                    recordService.updateRecord(recordDO);
                }
                LOG.info("该住房订单已经完成付款 id={}", out_trade_no);
            }
            if (trade_status.equals("TRADE_SUCCESS") == true && out_trade_no.length() == 10) {
                ResultDO<OrderDO> orderDOResultDO = orderService.showOrder(Long.parseLong(out_trade_no));
                OrderDO orderDO = orderDOResultDO.getModule();
                if (orderDOResultDO.isSuccess() && orderDOResultDO.isSuccess()
                    || Integer.parseInt(buyer_pay_amount) == orderDO.getPayMoney()) {
                    orderDO.setState(1);
                    orderService.updateOrder(orderDO);
                }
                LOG.info("该餐品订单已经完成付款 id={}", out_trade_no);
            }
        } catch (Exception e) {
            LOG.error("error", e);
        }
        // 支付宝要求必须返回success，不然就会一直给你回调
        PrintWriter writer = null;
        writer = response.getWriter();
        writer.write("success"); // 一定要打印success
        writer.flush();
        return;
    }

    /**
     * 检查订单
     *
     * @param recordId
     * @return
     */
    @Override
    @PostMapping("check-pay")
    public ResultDO<RecordDO> returnRecord(@RequestParam(name = "recordId") long recordId) {
        // 参数校验
        if (recordId <= 0) {
            return new ResultDO<RecordDO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        ResultDO<RecordDO> recordDOResultDO = recordService.showRecord(recordId);
        if (recordDOResultDO.isSuccess() && recordDOResultDO.getModule().getState() == 1) {
            return new ResultDO<RecordDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
                recordDOResultDO.getModule());

        } else {
            // 前端做判断，是否跳转到未付款页面
            return new ResultDO<RecordDO>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        }
    }
}
