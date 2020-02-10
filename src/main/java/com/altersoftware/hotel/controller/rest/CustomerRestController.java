package com.altersoftware.hotel.controller.rest;

import java.util.List;

import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;

public interface CustomerRestController {

    /**
     * 获取所有客户信息
     *
     * @return
     */
    ResultDO<List<UserDO>> getAllCustomer();

    /**
     * 修改客户信息
     *
     * @param userDO
     * @return
     */
    ResultDO<Void> updateUserDO(UserDO userDO);

    /**
     * 删除指定客户信息
     *
     * @param number
     * @return
     */
    ResultDO<Void> deleteByUserId(String number);

    /**
     * 会员号搜索客户/员工
     *
     * @param number
     * @return
     */
    ResultDO<UserDO> getByNumber(String number);

    // 客户个性化页面

    /**
     * 预定物品
     *
     * 1.转到历史订单页面订 查看历史单 提交订单编号 获取详细订单信息 有我的房间按钮 ( 点击的的时候 判断用户订单时间是否在当前时间下)
     * 2.点击进入我的房间页面 地址栏跟上房间编号
     * 3.提交房间编号 可查看房间对应的物品 返回的 List<GoodsDO> GoodsController 完成
     * 4.显示所有物品信息后 在每个物品信息栏点击选择物品状态 具体见 com.altersoftware.hotel.constant.entity.goods.GoodsState
     * 5.选择后提交 服务器接收后 处理并且存入数据库 -- 对应 GoodsController 的更新方法
     * 6.后期可根据数据库中物品对应状态向云助手发送机器语音 指导天猫精灵设置房间状态
     *
     */

    // 按钮提交订单编号 判断用户订单时间是否在当前时间下
    ResultDO<Boolean> checkMyRoom();

}
