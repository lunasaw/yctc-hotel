package com.altersoftware.hotel.dao;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altersoftware.hotel.entity.PermissionGroupDO;

/**
 * @author czy@win10
 * @date 2020/1/22 20:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PermissionGroupDAOTest {

    private static final long   ID   = 10000;
    private static final String NAME = "customer";

    @Resource
    private PermissionGroupDAO  permissionGroupDAO;

    @Test
    public void aInsert() {
        PermissionGroupDO permissionGroupDO = new PermissionGroupDO();
        permissionGroupDO.setId(ID);
        permissionGroupDO.setName(NAME);
        permissionGroupDAO.insert(permissionGroupDO);
    }

    @Test
    public void bGetpermissionGroupDOById() {
        PermissionGroupDO permissionGroupDOById = permissionGroupDAO.getPermissionGroupDOById(ID);
        System.out.println(permissionGroupDOById);
        Assert.assertNotNull(permissionGroupDOById);
    }

    @Test
    public void cUpdate() {
        PermissionGroupDO permissionGroupDOById = permissionGroupDAO.getPermissionGroupDOById(ID);
        permissionGroupDOById.setId(permissionGroupDOById.getId());
        int update = permissionGroupDAO.update(permissionGroupDOById);
        Assert.assertEquals(update, 1);
    }

    @Test
    public void dGetPermissionGroupIdByName() {
        long idByName = permissionGroupDAO.getPermissionGroupIdByName(NAME);
        System.out.println(idByName);
        Assert.assertEquals(idByName, ID);
    }

    @Test
    public void eGetPermissionGroupNameById() {
        String permissionGroupNameById = permissionGroupDAO.getPermissionGroupNameById(ID);
        System.out.println(permissionGroupNameById);
        Assert.assertEquals(NAME, permissionGroupNameById);
    }

    @Test
    public void hDeletePermissionGrouupByGroupId() {
        permissionGroupDAO.deleteById(ID);
        PermissionGroupDO permissionGroupDOById = permissionGroupDAO.getPermissionGroupDOById(ID);
        System.out.println(permissionGroupDOById);
        Assert.assertNull(permissionGroupDOById);
    }

    @Test
    public void iDeletePermissionGroupByName() {
        permissionGroupDAO.deletePermissionGroupByName(NAME);
        PermissionGroupDO permissionGrouupById = permissionGroupDAO.getPermissionGroupDOById(ID);
        System.out.println(permissionGrouupById);
        Assert.assertNull(permissionGrouupById);
    }
}
