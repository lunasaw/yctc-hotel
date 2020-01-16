package com.altersoftware.hotel.dao;



import com.altersoftware.hotel.entity.PermissionGroupDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface PermissionGroupDAO {

    /**
     * 插入一个权限组
     * 
     * @param permissionGroupDO
     */
    public void insert(PermissionGroupDO permissionGroupDO);

    /**
     * 权限组id查询权限组
     * 
     * @param id
     * @return
     */
    public PermissionGroupDO getPermissionGroupDOById(long id);

    /**
     * 更新权限组
     * 
     * @param permissionGroupDO
     */
    public void update(PermissionGroupDO permissionGroupDO);

    /**
     * id删除权限组
     * 
     * @param id
     */
    public void deleteById(long id);

    /**
     * 通过权限组的name获取权限组的id
     * 
     * @param name
     * @return
     */
    public long getPermissionGroupIdByName(String name);

    /**
     * 通过权限组的id获取权限组的name
     * 
     * @param id
     * @return
     */
    public String getPermissionGroupNameById(long id);

    /**
     * 展示所有的权限组
     * 
     * @param
     * @return
     */
    public List<PermissionGroupDO> showALLPermissionGroups();

    /**
     * 通过权限组的name删除权限组
     * 
     * @param name
     * @return
     */
    public long deletePermissionGroupByName(String name);

}
