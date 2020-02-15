package com.altersoftware.hotel.controller.rest;

import com.altersoftware.hotel.entity.ResultDO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileRestController {
    /**
     * 上传文件
     *
     * @param file 文件名
     * @param fileType 文件类型
     * @param fileName 文件名字
     * @return 是否成功
     */
    ResultDO<Void> upload(MultipartFile file, String fileType, String fileName);

    /**
     * 获取本地图片
     *
     * @param imageName 图片名称
     * @return 图片
     */
    ResponseEntity<byte[]> getImage(String imageName);
}
