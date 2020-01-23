package com.altersoftware.hotel.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altersoftware.hotel.dao.PermissionDAO;
import com.altersoftware.hotel.entity.PermissionDO;

/**
 * @author czy@win10
 * @date 2020/1/23 21:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PermissionDAOTest {
    private static final long   ID       = 10001;
    private static final String NAME     = "权限管理1.0";
    private static final String RESOURCE = "admin:authorityManagement1";

    @Resource
    private PermissionDAO       permissionDAO;

    @Test
    public void aInsert() {
        PermissionDO permissionDO = new PermissionDO();
        permissionDO.setId(ID);
        permissionDO.setName(NAME);
        permissionDO.setResource(RESOURCE);
        permissionDAO.insert(permissionDO);
    }

    @Test
    public void bGetPermissionById() {
        PermissionDO permissionDOById = permissionDAO.getPermissionDOById(ID);
        System.out.println(permissionDOById);
        Assert.assertNotNull(permissionDOById);
    }

    @Test
    public void cGetPermissionByName() {
        PermissionDO permissionDOByName = permissionDAO.getPermissionDOByName(NAME);
        System.out.println(permissionDOByName);
        Assert.assertNotNull(permissionDOByName);
    }

    @Test
    public void dUpdate() {
        PermissionDO permissionDOById = permissionDAO.getPermissionDOById(ID);
        permissionDOById.setName(permissionDOById.getName() + "Iszychen");
        int update = permissionDAO.update(permissionDOById);
        System.out.println(update);
        Assert.assertEquals(1, update);
    }

    @Test
    public void eShowAllPermission() {
        List<PermissionDO> permissionDOS = permissionDAO.showAllPermissions();
        System.out.println(permissionDOS);
        Assert.assertNotNull(permissionDOS);
    }

    @Test
    public void fDelete() {
        permissionDAO.deleteById(ID);
        PermissionDO permissionDOById = permissionDAO.getPermissionDOById(ID);
        System.out.println(permissionDOById);
        Assert.assertNull(permissionDOById);
    }
}
