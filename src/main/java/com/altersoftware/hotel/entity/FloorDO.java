package com.altersoftware.hotel.entity;

import java.util.Date;

/**
 * @author czy@win10
 * @date 2020/1/20 15:51
 */
public class FloorDO {

    /** 楼层编号 */
    private int    id;
    /** 楼层编号 */
    private int    roomId;
    /** 平面图 */
    private String plan;
    /** 消防图 */
    private String fireDiagram;
    /** 3D平面图 */
    private String threeDDiagram;
    /** 创建时间 */
    private Date   createTime;
    /** 修改时间 */
    private Date   modifyTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getroomId() {
        return roomId;
    }

    public void setroomId(int roomId) {
        this.roomId = roomId;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getFireDiagram() {
        return fireDiagram;
    }

    public void setFireDiagram(String fireDiagram) {
        this.fireDiagram = fireDiagram;
    }

    public String getThreeDDiagram() {
        return threeDDiagram;
    }

    public void setThreeDDiagram(String threeDDiagram) {
        this.threeDDiagram = threeDDiagram;
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

    @Override
    public String toString() {
        return "FloorDO{" +
            "id=" + id +
            ", roomId=" + roomId +
            ", plan='" + plan + '\'' +
            ", fireDiagram='" + fireDiagram + '\'' +
            ", threeDDiagram='" + threeDDiagram + '\'' +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
