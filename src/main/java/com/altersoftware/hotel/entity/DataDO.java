package com.altersoftware.hotel.entity;

import java.util.Date;

/**
 * @author czy@win10
 * @date 2020/1/20 15:25
 */
public class DataDO {

    /** 资料编号 */
    private long  id;
    /** 员工编号 */
    private long  staffId;
    /** 工资金额 */
    private float rais;
    /** 工资发放时间 */
    private Date  salaryTime;
    /** 出勤天数 */
    private int   dayTime;
    /** 工龄 */
    private int   year;
    /** 创建时间 */
    private Date  createTime;
    /** 修改时间 */
    private Date  modifyTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getstaffId() {
        return staffId;
    }

    public void setstaffId(long staffId) {
        this.staffId = staffId;
    }

    public float getRais() {
        return rais;
    }

    public void setRais(float rais) {
        this.rais = rais;
    }

    public Date getSalaryTime() {
        return salaryTime;
    }

    public void setSalaryTime(Date salaryTime) {
        this.salaryTime = salaryTime;
    }

    public int getDayTime() {
        return dayTime;
    }

    public void setDayTime(int dayTime) {
        this.dayTime = dayTime;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
        return "DataDO{" +
            "id=" + id +
            ", staffId=" + staffId +
            ", rais=" + rais +
            ", salaryTime=" + salaryTime +
            ", dayTime=" + dayTime +
            ", year=" + year +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
