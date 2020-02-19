package com.altersoftware.hotel.util;

import java.io.File;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altersoftware.hotel.controller.rest.impl.OrderRestControllerImpl;
import com.altersoftware.hotel.entity.UserDO;
import com.altersoftware.hotel.file.UploadUtils;

/**
 * @author Iszychen@win10
 * @date 2020/2/15 20:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class updateFile {

    @Test
    public void Test() throws Exception {
        File file = new File("C:/ERPSystem/img/15.jpg");
        byte[] bytes = FileUtilsAlter.fileToByte(file);
        UploadUtils.uploadFile((FileUtilsAlter.fileToByte(file)), "http://111.229.114.126:8087/iszychen/img/",
            "test.jpg");
    }

    @Resource
    OrderRestControllerImpl orderRestController;

    @Test
    public void reOneStaff() {
        UserDO userDO = orderRestController.returnOneMealStaff(327);
        System.out.println(userDO);
    }

}
