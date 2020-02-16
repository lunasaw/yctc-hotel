package com.altersoftware.hotel.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.imageio.ImageIO;

public class FileUtilsAlter {
    /**
     * 判断文件夹是否存在 不存在则创建文件夹
     *
     * @param dirPath 文件夹路径
     * @return 是否成功
     */
    static public Boolean isDirExists(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists()) {
            return dir.mkdirs();
        }
        return true;
    }

    /**
     * 读取图片
     *
     * @param img 图片
     * @return 图片字节
     */
    public static byte[] fileToByte(File img) {
        byte[] bytes = null;
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            BufferedImage bi;
            bi = ImageIO.read(img);
            ImageIO.write(bi, "png", outputStream);
            bytes = outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytes;
    }

}
