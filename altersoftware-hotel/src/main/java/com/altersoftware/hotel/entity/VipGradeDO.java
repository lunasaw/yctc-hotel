package com.altersoftware.hotel.entity;

import java.util.Date;

/**
 * @author czy@win10
 * @date 2020/2/4 14:05
 */
public class VipGradeDO {

    /** 主键 */
    private long   id;
    /** 等级 */
    private String grade;
    /** 权益 */
    private String equity;
    /** 折扣 */
    private Double discount;
    /** 创建时间 */
    private Date   createTime;
    /** 修改时间 */
    private Date   modifyTime;
    /** 图片 */
    private String picture;
    /** 达成条件描述 */
    private String description;
    /** 升级描述 */
    private String updateDescription;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEquity() {
        return equity;
    }

    public void setEquity(String equity) {
        this.equity = equity;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdate_description() {
        return updateDescription;
    }

    public void setUpdate_description(String updateDescription) {
        this.updateDescription = updateDescription;
    }

    @Override
    public String toString() {
        return "VipGradeDO{" +
            "id=" + id +
            ", grade='" + grade + '\'' +
            ", equity='" + equity + '\'' +
            ", discount=" + discount +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            ", picture='" + picture + '\'' +
            ", description='" + description + '\'' +
            ", updateDescription='" + updateDescription + '\'' +
            '}';
    }
}
