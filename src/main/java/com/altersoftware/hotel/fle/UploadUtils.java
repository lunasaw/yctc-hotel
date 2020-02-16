package com.altersoftware.hotel.fle;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

}
