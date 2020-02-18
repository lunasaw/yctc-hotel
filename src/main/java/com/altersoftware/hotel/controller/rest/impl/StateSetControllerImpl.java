package com.altersoftware.hotel.controller.rest.impl;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.controller.rest.StateSetController;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.GoodsService;
import com.altersoftware.hotel.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hzx
 * @date 2020/2/6 17:28
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/state")
public class StateSetControllerImpl implements StateSetController {

    @Autowired
    GoodsService goodsService;

    /**
     * 接收物品状态值
     *
     */
    @Override
    @PostMapping("update-state")
    public ResultDO<Void> updateGoodsDO(@RequestBody List<GoodsVO> goodsVO) {
        //参数校验
        if (goodsVO.size() <= 0){
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }

        for (int i = 0; i < goodsVO.size(); i++){

        }
        return null;
    }
}
