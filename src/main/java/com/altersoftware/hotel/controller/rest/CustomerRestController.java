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
     * 删除部分客户信息
     *
     * @param numbers
     * @return
     */
    ResultDO<Void> deleteList(String[] numbers);
    /**
     * 会员号搜索客户/员工
     *
     * @param number
     * @return
     */
    ResultDO<UserDO> getByNumber(String number);

    /**
     * 客户编号搜索客户/员工
     *
     * @param customerId
     * @return
     */
    ResultDO<UserDO> getByCustomerId(long customerId);

    // 客户个性化页面

    /**
     * TODO 预定物品
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

    /**
     * TODO 预定打扫
     *
     * 1.客户发送打扫请求 在留言页面 NewsRestControl下的 <>sendNewsToStaff</> 让用户输入标题(下拉框 用户选择) 内容 打扫时间等 指定消息模板
     * 2.如果打扫用户接单 就设置该客户留言的消息消息全部已读 其他员工就看不见留言了
     * 3.员工完成后需向指定客户发送消息 通过已读消息获取内容中的房间号 获取客户id 向客户发送消息
     *
     */
    ResultDO<List<Long>> returnCleanStaffIdList();

    /**
     * TODO 预定餐饮信息
     * 1.查看所有菜品
     * 2.加入购物车
     * 3.提交菜品List
     * 4.添加订单
     * 5.返回金额 商品 信息 提交支付
     */

}
