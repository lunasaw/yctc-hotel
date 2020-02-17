package com.altersoftware.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.altersoftware.hotel.entity.PermissionUserDO;



@Mapper
public interface PermissionUserDAO {

    /**
     * 插入用户权限信息
     * 
     * @param permissionUserDO
     */
    @Insert(" INSERT INTO tb_permission_user (id, user_id, permission_id, create_time, modify_time ) "
        +
        "VALUES(#{id}, #{userId}, #{permissionId}, NOW(), NOW()) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(PermissionUserDO permissionUserDO);

    /**
     * id查询权限
     * 
     * @param id
     * @return
     */
    @Select("select id, user_id, permission_id, create_time, modify_time from tb_permission_user where id=#{id}  ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "userId", column = "user_id"),
        @Result(property = "permissionId", column = "permission_id"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    PermissionUserDO getPermissionUserDOById(long id);

    /**
     * 更新用户权限
     * 
     * @param permissionUserDO
     */
    @Update("update tb_permission_user  set user_id=#{userId}, permission_id=#{permissionId}, modify_time=now()  where id=#{id}")
    int update(PermissionUserDO permissionUserDO);

    /**
     * id删除用户权限
     * 
     * @param id
     */
    @Delete("DELETE FROM tb_permission_user WHERE id=#{id}")
    void deleteById(long id);

    /**
     * 删除用户权限
     *
     * @param userId
     */
    @Delete("DELETE FROM tb_permission_user WHERE user_id=#{userId}")
    void deleteByUserId(long userId);

    /**
     * 用户id返回权限id组
     * 
     * @param userId
     * @return
     */
    @Select("select permission_id from tb_permission_user where user_id=#{userId}  ")
    List<Long> getPermissionIdByUserId(long userId);

    /**
     * 用户id和权限id查询表中该条记录
     * 
     * @param userId
     * @param permissionId
     * @return
     */
    @Select("select id, user_id, permission_id, create_time, modify_time from tb_permission_user where user_id=#{userId} and permission_id=#{permissionId} ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "userId", column = "user_id"),
        @Result(property = "permissionId", column = "permission_id"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "modifyTime", column = "modify_time")
    })
    PermissionUserDO getPermissionUserDOIdByBothId(@Param("userId") long userId,
        @Param("permissionId") long permissionId);

}
