package com.altersoftware.hotel.dao;


import com.altersoftware.hotel.entity.PermissionDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface PermissionDAO {

    /**
     * 插入一个权限
     * 
     * @param permissionDO
     */
    public void insert(PermissionDO permissionDO);

    /**
     * 权限id查找权限
     * 
     * @param id
     * @return
     */
    public PermissionDO getPermissionDOById(long id);

    /**
     * 权限name查找权限
     * 
     * @param name
     * @return
     */
    public PermissionDO getPermissionDOByName(String name);

    /**
     * 更新权限
     * 
     * @param permissionDO
     */
    public void update(PermissionDO permissionDO);

    /**
     * id删除权限
     * 
     * @param id
     */
    public void deleteById(long id);

    /**
     * 展示所用权限
     */
    public List<PermissionDO> showAllPermissions();
}
