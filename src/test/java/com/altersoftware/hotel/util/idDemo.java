package com.altersoftware.hotel.util;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class idDemo {

    @Test
    public void Test() throws Exception {
        boolean check = CheckIn.idEnsure("陈章月", "500384199911072412");
        System.out.println(check);
    }

    @Test
    public void ocrFace() {
        CheckIn.IDCardOCR(10013);
    }

    @Test
    public void Test777() throws Exception {

        String s1 = CheckIn.IDCardOCRBybase64(Base64Utils.GetImageStr("d:\\faceid1.jpg"));
        System.out.printf("s1");
    }
}
