package com.altersoftware.hotel.dao;

import org.apache.ibatis.annotations.*;

import com.altersoftware.hotel.entity.DepartmentDO;

/**
 * @author czy@win10
 * @date 2020/1/28 15:24
 */
@Mapper
public interface DepartmentDAO {
    /**
     * 插入一条部门信息
     *
     *
     */
    @Insert(" INSERT INTO tb_department (id, name, staff_numbers, staff_id,  create_time, modify_time ) "
        +
        "VALUES(#{id}, #{name}, #{staffNumbers}, #{staffId},  now(), now()) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(DepartmentDO departmentDO);

    /**
     * id查找部门消息
     *
     * @param id
     */
    @Select("select id, name, staff_numbers, staff_id,  create_time, modify_time from tb_department where id=#{id}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "staffNumbers", column = "staff_numbers"),
        @Result(property = "staffId", column = "staff_id"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    DepartmentDO getDepartmentDOById(long id);

    /**
     * 更新部门消息
     *
     * @param departmentDO
     */
    @Update("update tb_department  set name=#{name}, staff_numbers=#{staffNumbers}, staff_id=#{staffId}, modify_time=now()  where id=#{id}")
    int update(DepartmentDO departmentDO);

    /**
     * 根据id删除一条部门消息
     *
     * @param id
     */
    @Delete("DELETE FROM tb_department WHERE id=#{id}")
    int deleteById(long id);

    /**
     * 根据负责人编号查询部门
     *
     * @param staffId
     * @return
     */
    @Select("select id, name, staff_numbers, staff_id,  create_time, modify_time from tb_department where staff_id=#{staffId}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "staffNumbers", column = "staff_numbers"),
        @Result(property = "staffId", column = "staff_id"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    DepartmentDO getDepartmentDOByStaffId(long staffId);

}
