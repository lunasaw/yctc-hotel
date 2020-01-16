package com.altersoftware.hotel.dao;

import java.util.List;

import com.altersoftware.hotel.entity.PermissionGroupPermissionDO;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface PermissionGroupPermissionDAO {

    /**
     * 插入权限组权限信息
     * 
     * @param permissionGroupPermissionDO
     */
    public void insert(PermissionGroupPermissionDO permissionGroupPermissionDO);

    /**
     * id查询权限组及权限
     * 
     * @param id
     * @return
     */
    public PermissionGroupPermissionDO getPermissionGroupPermissionDOById(long id);

    /**
     * 更新权限组权限
     * 
     * @param permissionGroupPermissionDO
     */
    public void update(PermissionGroupPermissionDO permissionGroupPermissionDO);

    /**
     * id删除权限组及权限
     * 
     * @param id
     */
    public void deleteById(long id);

    /**
     * 权限组id返回权限id
     * 
     * @param permissionGroupId
     * @return
     */
    public List<Long> getPermissionIdByPermissionGroupId(long permissionGroupId);

    /**
     * 根据权限组id删除某一组权限
     * 
     * @param permissionGroupId
     * @return
     */
    public void deletePermissionsByPermissionGroupId(long permissionGroupId);
}
