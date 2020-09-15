package com.altersoftware.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.altersoftware.hotel.entity.PermissionDO;

@Mapper
public interface PermissionDAO {

    /**
     * 插入一个权限
     * 
     * @param permissionDO
     */
    @Insert(" INSERT INTO tb_permission (id, name, resource, create_time, modify_time ) "
        +
        "VALUES(#{id}, #{name}, #{resource}, NOW(), NOW()) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(PermissionDO permissionDO);

    /**
     * 权限id查找权限
     * 
     * @param id
     * @return
     */
    @Select("select id, name, resource, create_time, modify_time from tb_permission where id=#{id}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "resource", column = "resource"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    PermissionDO getPermissionDOById(long id);

    /**
     * 权限name查找权限
     * 
     * @param name
     * @return
     */
    @Select("select id, name, resource, create_time, modify_time from tb_permission where name=#{name}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "resource", column = "resource"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    PermissionDO getPermissionDOByName(String name);

    /**
     * 更新权限
     * 
     * @param permissionDO
     */
    @Update("update tb_permission  set name=#{name}, resource=#{resource}, modify_time=now()  where id=#{id}")
    int update(PermissionDO permissionDO);

    /**
     * id删除权限
     * 
     * @param id
     */
    @Delete("DELETE FROM tb_permission WHERE id=#{id}")
    void deleteById(long id);

    /**
     * 展示所用权限
     */
    @Select("select id, name,resource, create_time, modify_time from tb_permission ")
    List<PermissionDO> showAllPermissions();
}
