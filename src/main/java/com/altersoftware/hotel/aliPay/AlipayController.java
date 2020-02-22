package com.altersoftware.hotel.aliPay;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.entity.ResultDO;

/**
 * 支付宝
 *
 * @author Iszychen@win10
 * @date 2020/2/7 14:23
 */
@RestController
public class AlipayController {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");
    @Autowired
    @Qualifier("alipayService")
    private AlipayService       alipayService;

    /**
     * web 订单支付
     */
    @PostMapping("getPagePay")
    public void getUnSignData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            // 这里拿到支付宝通知数据
            Map<String, String[]> requestParams = request.getParameterMap();
            Map<String, String> params = new HashMap<>();
            for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
                String name = iter.next();
                String[] values = requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
                }

                // 乱码解决，这段代码在出现乱码时使用
                // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
                params.put(name, valueStr);
            }
            // 打印数据看看
            LOG.debug("数据：" + JSON.toJSONString(requestParams));
            // 获取其中一个值看看
            String notifyType = params.get("notify_type");
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
     * app 订单支付
     */
    @GetMapping("getAppPagePay")
    public ResultDO<?> getAppPagePay() throws Exception {
        /** 模仿数据库，从后台调数据 */
        String outTradeNo = "131233";
        Integer totalAmount = 1000;
        String subject = "天猫超市012";

        String pay = alipayService.appPagePay(outTradeNo, totalAmount, subject);

        Object json = JSONObject.toJSON(pay);

        System.out.println(json);

        return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, json);
    }

    /**
     * 交易查询
     */
    @PostMapping("aipayQuery")
    public ResultDO<?> alipayQuery() throws Exception {
        /** 调取支付订单号 */
        String outTradeNo = "13123";

        String query = alipayService.query(outTradeNo);

        Object json = JSONObject.toJSON(query);

        /*JSONObject jObject = new JSONObject();
        jObject.get(query);*/
        return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, json);
    }

    /**
     * 退款
     * 
     * @throws AlipayApiException
     */
    @GetMapping("alipayRefund")
    public ResultDO<?> alipayRefund(
        @RequestParam("outTradeNo") String outTradeNo,
        @RequestParam(value = "outRequestNo", required = false) String outRequestNo,
        @RequestParam(value = "refundAmount", required = false) Integer refundAmount) throws AlipayApiException {

        /** 调取数据 */
        // String outTradeNo = "15382028806591197";
        String refundReason = "用户不想购买";
        // refundAmount = 1;
        // outRequestNo = "22";

        String refund = alipayService.refund(outTradeNo, refundReason, refundAmount, outRequestNo);

        System.out.println(refund);

        return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, refund);
    }

    /**
     * 退款查询
     * 
     * @throws AlipayApiException
     */
    @PostMapping("refundQuery")
    public ResultDO<?> refundQuery() throws AlipayApiException {

        /** 调取数据 */
        String outTradeNo = "13123";
        String outRequestNo = "2";

        String refund = alipayService.refundQuery(outTradeNo, outRequestNo);

        return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, refund);

    }

    /**
     * 交易关闭
     * 
     * @throws AlipayApiException
     */
    @PostMapping("alipayclose")
    public ResultDO<?> alipaycolse() throws AlipayApiException {

        /** 调取数据 */
        String outTradeNo = "13123";

        String close = alipayService.close(outTradeNo);

        return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, close);

    }

}
