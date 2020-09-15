package com.altersoftware.hotel.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class RandomNumber {
    /**
     * 生成随机数字或字母 len ： 需要的长度(自定义)
     *
     * @return
     */
    public String getItemID(int len) {
        String val = "";
        Random random = new Random(); // 随机生成器
        for (int i = 0; i < len; i++) {
            // 在[0,2)值域随机生成一个数除2，得到以下要判断的格式
            String str = random.nextInt(2) % 2 == 0 ? "num" : "char";
            if ("char".equalsIgnoreCase(str)) {
                // 产生字母（大小写判断）
                int nextInt = random.nextInt(2) % 2 == 0 ? 65 : 97;
                // 字符串拼接
                val += (char)(nextInt + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(str)) { // 产生随机数字并转成字符串
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /**
     * 生成纯随机字符串数字 n ： 需要的长度
     *
     * @return
     */
    public String getStr(int n) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }

    /**
     * 用UUID生成十六位数唯一订单号
     * 生成16位唯一性的订单号s
     */
    public String getUUID() {
        // 随机生成一位整数
        int random = (int)(Math.random() * 9 + 1);
        String valueOf = String.valueOf(random);
        // 生成uuid的hashCode值
        int hashCode = UUID.randomUUID().toString().hashCode();
        // 可能为负数
        if (hashCode < 0) {
            hashCode = -hashCode;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        String value = valueOf + String.format("%010d", hashCode);
        return value;
    }

    /**
     * 订单流水号模拟
     * 
     * @return
     */
    public String getRandomFileName() {
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String str = simpleDateFormat.format(date); // 当前时间字符串
        String val = ""; // 自定义一个随机字符串
        Random random = new Random();
        // 10位含数字字母的随机字符串
        for (int i = 0; i < 10; i++) {
            // 在[0,2)值域随机生成一个数除2，得到以下要判断的格式
            String ranstr = random.nextInt(2) % 2 == 0 ? "num" : "char";
            if ("char".equalsIgnoreCase(ranstr)) {
                // 产生字母（大小写判断）
                int nextInt = random.nextInt(2) % 2 == 0 ? 65 : 97;
                // 字符串拼接
                val += (char)(nextInt + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(ranstr)) { // 产生随机数字并转成字符串
                val += String.valueOf(random.nextInt(10));
            }
        }

        // int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数
        // return str+rannum;

        return "D000001" + str + val;// 当前时间
    }

    public String GetRandom() {
        return getUUID();
    }

    public String GetRandomOrder() {
        return getStr(10);
    }
}
