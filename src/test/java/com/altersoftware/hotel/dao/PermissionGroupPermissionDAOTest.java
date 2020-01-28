package com.altersoftware.hotel.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altersoftware.hotel.entity.PermissionGroupPermissionDO;

/**
 * @author czy@win10
 * @date 2020/1/23 22:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PermissionGroupPermissionDAOTest {

    private static final long            ID                  = 2;
    private static final long            PERMISSION_GROUP_ID = 10001;
    private static final long            PERMISSION_ID       = 2;

    @Resource
    private PermissionGroupPermissionDAO permissionGroupPermissionDAO;

    @Test
    public void aInsert() {
        PermissionGroupPermissionDO permissionGroupPermissionDO = new PermissionGroupPermissionDO();
        permissionGroupPermissionDO.setId(ID);
        permissionGroupPermissionDO.setPermissionGroupId(PERMISSION_GROUP_ID);
        permissionGroupPermissionDO.setPermissionId(PERMISSION_ID);
        permissionGroupPermissionDAO.insert(permissionGroupPermissionDO);
    }

    @Test
    public void bGetPermissionGroupPermissionDO() {
        PermissionGroupPermissionDO permissionGroupPermissionDOById =
            permissionGroupPermissionDAO.getPermissionGroupPermissionDOById(ID);
        System.out.println(permissionGroupPermissionDOById);
        Assert.assertNotNull(permissionGroupPermissionDOById);
    }

    @Test
    public void cGetPermissionIdByPermissionGroupId() {
        List<Long> permissionIdByPermissionGroupId =
            permissionGroupPermissionDAO.getPermissionIdByPermissionGroupId(PERMISSION_GROUP_ID);
        System.out.println(permissionIdByPermissionGroupId);
        Assert.assertNotNull(permissionIdByPermissionGroupId);
    }

    @Test
    public void dUpdate() {
        PermissionGroupPermissionDO permissionGroupPermissionDOById =
            permissionGroupPermissionDAO.getPermissionGroupPermissionDOById(ID);
        permissionGroupPermissionDOById.setPermissionId(permissionGroupPermissionDOById.getPermissionId());
        permissionGroupPermissionDAO.update(permissionGroupPermissionDOById);
    }

    @Test
    public void eDelete() {
        permissionGroupPermissionDAO.deleteById(ID);
        PermissionGroupPermissionDO permissionGroupPermissionDOById =
            permissionGroupPermissionDAO.getPermissionGroupPermissionDOById(ID);
        System.out.println(permissionGroupPermissionDOById);
        Assert.assertNull(permissionGroupPermissionDOById);
    }

    @Test
    public void fDeleteGroup() {
        permissionGroupPermissionDAO.deletePermissionsByPermissionGroupId(PERMISSION_GROUP_ID);
        List<Long> permissionIdByPermissionGroupId =
            permissionGroupPermissionDAO.getPermissionIdByPermissionGroupId(PERMISSION_GROUP_ID);
        System.out.println(permissionIdByPermissionGroupId);
        Assert.assertEquals(0, permissionIdByPermissionGroupId.size());
    }
}
