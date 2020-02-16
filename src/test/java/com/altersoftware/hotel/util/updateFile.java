package com.altersoftware.hotel.util;

import java.io.File;

import org.junit.Test;

import com.altersoftware.hotel.fle.UploadUtils;

/**
 * @author Iszychen@win10
 * @date 2020/2/15 20:58
 */
public class updateFile {

    @Test
    public void Test() throws Exception {
        File file = new File("C:/ERPSystem/img/15.jpg");
        byte[] bytes = FileUtilsAlter.fileToByte(file);
        UploadUtils.uploadFile((FileUtilsAlter.fileToByte(file)), "http://111.229.114.126:8087/iszychen/img/",
            "test.jpg");
    }

}
