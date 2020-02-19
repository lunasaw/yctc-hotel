package com.altersoftware.hotel.file;

import java.io.*;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.altersoftware.hotel.constant.ConstantHolder;
import com.altersoftware.hotel.util.FileUtilsAlter;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * 文件上传帮助类
 * 
 * @author yaco
 * @Date 2019年7月18日 下午2:16:09
 */
public class UploadUtils {
    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    /**
     * 上传到文件服务器
     * 
     * @author: yaco
     * @Date : 2019年7月18日 下午4:26:57
     */
    public static String uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        Client client = new Client();
        WebResource resource = client.resource(filePath + fileName);
        resource.put(String.class, file);
        return filePath + fileName;
    }

    public static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static File MultipartFileToFile(MultipartFile files) {
        try {
            File file = new File(files.getOriginalFilename());
            InputStream inputStream = files.getInputStream();
            // file就可以直接用了
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean uploadFile(String fileName, MultipartFile file) {
        try {
            File fileIo = new File("/img");
            FileUtils.copyInputStreamToFile(file.getInputStream(), fileIo);
            UploadUtils.uploadFile((FileUtilsAlter.fileToByte(fileIo)), ConstantHolder.IMG_SAVE_PATH, fileName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
