package com.altersoftware.hotel.dao;


import java.util.List;

import org.apache.ibatis.annotations.*;

import com.altersoftware.hotel.entity.PermissionGroupDO;


@Mapper
public interface PermissionGroupDAO {

    /**
     * 插入一个权限组
     * 
     * @param permissionGroupDO
     */
    @Insert(" INSERT INTO tb_permission_group (id, name, create_time, modify_time ) "
        +
        "VALUES(#{id},  #{name},  NOW(), NOW()) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(PermissionGroupDO permissionGroupDO);

    /**
     * 权限组id查询权限组
     * 
     * @param id
     * @return
     */
    @Select("select id, name, create_time, modify_time  from tb_permission_group where id=#{id} ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    PermissionGroupDO getPermissionGroupDOById(@Param("id") long id);

    /**
     * 更新权限组
     * 
     * @param permissionGroupDO
     */
    @Update("update tb_permission_group  set name=#{name}, modify_time=now() where id=#{id}")
    int update(PermissionGroupDO permissionGroupDO);

    /**
     * id删除权限组
     * 
     * @param id
     */
    @Delete("DELETE FROM tb_permission_group WHERE id=#{id}")
    void deleteById(@Param("id") long id);

    /**
     * 通过权限组的name获取权限组的id
     * 
     * @param name
     * @return
     */
    @Select("select id from tb_permission_group where name=#{name} ")
    long getPermissionGroupIdByName(@Param("name") String name);

    /**
     * 通过权限组的id获取权限组的name
     * 
     * @param id
     * @return
     */
    @Select("select name from tb_permission_group where id=#{id} ")
    String getPermissionGroupNameById(@Param("id") long id);

    /**
     * 展示所有的权限组
     * 
     * @param
     * @return
     */
    @Select("select id, name, create_time, modify_time from tb_permission_group   ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<PermissionGroupDO> showALLPermissionGroups();

    /**
     * 通过权限组的name删除权限组
     * 
     * @param name
     * @return
     */
    @Delete("DELETE FROM tb_permission_group WHERE name=#{name}")
    long deletePermissionGroupByName(String name);

}
