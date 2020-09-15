package com.altersoftware.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.altersoftware.hotel.entity.StaffDataDO;

/**
 * @author czy@win10
 * @date 2020/2/3 16:23
 */
@Mapper
public interface StaffDataDAO {

    /**
     * 插入一条员工档案信息
     * 
     * @param staffDataDO
     */
    @Insert(" INSERT INTO tb_staff_data (id, staff_id, salary, salary_time, daytime, staff_years, staff_address, create_time, modify_time ) "
        +
        "VALUES(#{id}, #{staffId}, #{salary}, #{salaryTime}, #{dayTime}, #{StaffTears}, #{staffAddress}, now(), now()) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(StaffDataDO staffDataDO);

    /**
     * id查找员工档案消息
     *
     * @param id
     */
    @Select("select id, staff_id, salary, salary_time, daytime, staff_years, staff_address, create_time, modify_time from tb_staff_data where id=#{id}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "staffId", column = "staff_id"),
        @Result(property = "salary", column = "salary"),
        @Result(property = "salaryTime", column = "salary_time"),
        @Result(property = "dayTime", column = "daytime"),
        @Result(property = "StaffTears", column = "staff_years"),
        @Result(property = "staffAddress", column = "staff_address"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    StaffDataDO getStaffDataDOById(long id);

    /**
     * 返回所有员工资料
     *
     * @return
     */
    @Select("select id, staff_id, salary, salary_time, daytime, staff_years, staff_address, create_time, modify_time from tb_staff_data  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "staffId", column = "staff_id"),
        @Result(property = "salary", column = "salary"),
        @Result(property = "salaryTime", column = "salary_time"),
        @Result(property = "dayTime", column = "daytime"),
        @Result(property = "StaffTears", column = "staff_years"),
        @Result(property = "staffAddress", column = "staff_address"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<StaffDataDO> getStaffDataDOList();

    /**
     * 更新员工档案消息
     *
     * @param staffDataDO
     */
    @Update("update tb_staff_data  set staff_id=#{staffId}, salary=#{salary}, salary_time=#{salaryTime}, daytime=#{dayTime}, staff_years=#{StaffTears}, staff_address=#{staffAddress},  modify_time=now()  where id=#{id}")
    int update(StaffDataDO staffDataDO);

    /**
     * 根据id删除一条员工档案消息
     *
     * @param id
     */
    @Delete("DELETE FROM tb_staff_data WHERE id=#{id}")
    int deleteById(long id);

    /**
     * 返回员工档案编号list
     *
     * @return
     */
    @Select("select id  from tb_staff_data ")
    List<Long> getFloorIdList();

}
