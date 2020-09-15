package com.altersoftware.hotel.vo;

import java.util.Date;
import java.util.List;

/**
 * @author Iszychen@win10
 * @date 2020/2/18 15:27
 */
public class GoodsVO {

    /** 物品编号 */
    private long          id;
    /** 房间编号 */
    private List<Integer> roomId;
    /** 物品名称 */
    private String        name;
    /** 物品采购时间 */
    private String        buyTime;
    /** 物品采购价格 */
    private Double        price;
    /** 物品损坏赔偿价格 */
    private Double        compensationMoeny;
    /** 物品状态 */
    private String        state;
    /** 创建时间 */
    private Date          createTime;
    /** 修改时间 */
    private Date          modifyTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Integer> getRoomId() {
        return roomId;
    }

    public void setRoomId(List<Integer> roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCompensationMoeny() {
        return compensationMoeny;
    }

    public void setCompensationMoeny(Double compensationMoeny) {
        this.compensationMoeny = compensationMoeny;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
