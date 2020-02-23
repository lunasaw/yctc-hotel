package com.altersoftware.hotel.util;

import java.io.File;
import java.io.FileNotFoundException;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import com.altersoftware.hotel.constant.ConstantHolder;
import com.altersoftware.hotel.controller.rest.impl.OrderRestControllerImpl;
import com.altersoftware.hotel.entity.UserDO;

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

    @Test
    public void TestFile() throws FileNotFoundException {
        String path = ResourceUtils.getURL("classpath:").getPath();
        File file = new File(path, "static/dll/ceshi.txt");
        System.out.println(file);
    }

    @Test
    public void downLoad() throws Exception {
        String path = ResourceUtils.getURL("classpath:static/").getPath();
        FileUtilsAlter.downloadHttpUrl(ConstantHolder.FILE_UPLOAD + "10013.jpg", path, "body.jpg");
    }
}
