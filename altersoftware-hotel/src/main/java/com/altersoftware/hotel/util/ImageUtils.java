package com.altersoftware.hotel.util;
/**
 * @Author 廿八十
 * @Date 2020/2/25 0:08
 * @Version 1.0
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 图像缩放工具类
 */
public class ImageUtils {
    /**
     * 缩放图像，并保存至特定路径
     *
     * @param src    原始图像路径
     * @param dest   缩放图像路径
     * @param format 缩放图像格式  "jpg"
     * @param scale  缩放比例
     * @throws IOException
     */
    public static void zoomByScale(String src, String dest, String format, double scale) throws IOException {
        BufferedImage srcImg = ImageIO.read(new File(src));
        //宽度不需要调整
        int width = (int) (srcImg.getWidth());
        int height = (int) (scale * srcImg.getHeight());
        Image instance = srcImg.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.drawImage(instance, 0, 0, null);
        graphics.dispose();
        ImageIO.write(image, format, new FileOutputStream(new File(dest)));
    }


}

