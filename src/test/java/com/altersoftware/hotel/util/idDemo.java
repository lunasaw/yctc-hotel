package com.altersoftware.hotel.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class idDemo {

    @Test
    public void Test() throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        boolean check = CheckIn.idEnsure("陈章月", "500384199911072412");
        System.out.println(check);
    }

    @Test
    public void ocrFace() {
        CheckIn.IDCardOCR(10014);
    }
}
