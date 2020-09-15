package com.altersoftware.hotel.entity;

import java.util.Date;

/**
 * @author czy@win10
 * @date 2020/1/20 15:25
 */
public class StaffDataDO {

    /** 资料编号 */
    private long   id;
    /** 员工编号 */
    private long   staffId;
    /** 工资金额 */
    private double salary;
    /** 工资发放时间 */
    private String salaryTime;
    /** 请假天数 */
    private int    dayTime;
    /** 工龄 */
    private int    StaffTears;
    /** 员工住址 */
    private String staffAddress;
    /** 创建时间 */
    private Date   createTime;
    /** 修改时间 */
    private Date   modifyTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSalaryTime() {
        return salaryTime;
    }

    public void setSalaryTime(String salaryTime) {
        this.salaryTime = salaryTime;
    }

    public int getDayTime() {
        return dayTime;
    }

    public void setDayTime(int dayTime) {
        this.dayTime = dayTime;
    }

    public int getStaffTears() {
        return StaffTears;
    }

    public void setStaffTears(int staffTears) {
        StaffTears = staffTears;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
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
        return "StaffDataDO{" +
            "id=" + id +
            ", staffId=" + staffId +
            ", salary=" + salary +
            ", salaryTime=" + salaryTime +
            ", dayTime=" + dayTime +
            ", StaffTears=" + StaffTears +
            ", staffAddress='" + staffAddress + '\'' +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
