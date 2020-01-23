package com.altersoftware.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.altersoftware.hotel.entity.PermissionGroupPermissionDO;


@Mapper
public interface PermissionGroupPermissionDAO {

    /**
     * 插入权限组权限信息
     * 
     * @param permissionGroupPermissionDO
     */
    @Insert(" INSERT INTO tb_permission_group_permission (id, permission_group_id, permission_id, create_time, modify_time ) "
        +
        "VALUES(#{id},  #{permissionGroupId},#{permissionId},  NOW(), NOW()) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(PermissionGroupPermissionDO permissionGroupPermissionDO);

    /**
     * id查询权限组及权限
     * 
     * @param id
     * @return
     */
    @Select("select id, permission_group_id, permission_id, create_time, modify_time from tb_permission_group_permission where id=#{id} ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "permissionGroupId", column = "permission_group_id"),
        @Result(property = "permissionId", column = "permission_id"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    PermissionGroupPermissionDO getPermissionGroupPermissionDOById(long id);

    /**
     * 更新权限组权限
     * 
     * @param permissionGroupPermissionDO
     */
    @Update("update tb_permission_group_permission  set permission_group_id=#{permissionGroupId},permission_id=#{permissionId} , modify_time=now() where id=#{id}")
    void update(PermissionGroupPermissionDO permissionGroupPermissionDO);

    /**
     * id删除权限组及权限
     * 
     * @param id
     */
    @Delete("DELETE FROM tb_permission_group_permission WHERE id=#{id}")
    void deleteById(long id);

    /**
     * 权限组id返回权限id
     * 
     * @param permissionGroupId
     * @return
     */
    @Select("select id, permission_group_id, permission_id, create_time, modify_time from tb_permission_group_permission where permission_group_id=#{permissionGroupId} ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "permissionGroupId", column = "permission_group_id"),
        @Result(property = "permissionId", column = "permission_id"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    List<Long> getPermissionIdByPermissionGroupId(long permissionGroupId);

    /**
     * 根据权限组id删除某一组权限
     * 
     * @param permissionGroupId
     * @return
     */
    @Delete("DELETE FROM tb_permission_group_permission WHERE permission_group_id=#{permissionGroupId}")
    void deletePermissionsByPermissionGroupId(long permissionGroupId);
}
