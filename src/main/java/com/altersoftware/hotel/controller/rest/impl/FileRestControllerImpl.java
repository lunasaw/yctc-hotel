package com.altersoftware.hotel.controller.rest.impl;

import static com.altersoftware.hotel.util.FileUtilsAlter.fileToByte;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.altersoftware.hotel.constant.ConstantHolder;
import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.controller.rest.FileRestController;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.file.UploadUtils;

/**
 * @author hzx
 * @date 2020/1/28 21:13
 */
@RestController
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/file")
public class FileRestControllerImpl implements FileRestController {

    /**
     * 上传文件
     */
    @Override
    @PostMapping("upload")
    public ResultDO<Void> upload(@RequestParam("file") MultipartFile file, @RequestParam("fileType") String fileType,
        @RequestParam("fileName") String fileName) {

        // 参数校验
        if (file.isEmpty() || StringUtils.isBlank(fileType) || StringUtils.isBlank(fileName)) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }

        // 图片上传
        if (ConstantHolder.IMG_FILE.equals(fileType)) {
            // // 判断文件夹是否存在 不存在创建文件夹
            // if (!isDirExists(ConstantHolder.IMG_SAVE_PATH)) {
            // return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
            // ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
            // }
            // String s = ConstantHolder.IMG_SAVE_PATH + fileName;
            // 后缀
            // File dest = new File(s);

            try {
                // file.transferTo(dest);
                byte[] buffer = file.getBytes();
                // File file1 = UploadUtils.MultipartFileToFile(file);
                UploadUtils.uploadFile(buffer, ConstantHolder.IMG_SAVE_PATH, fileName);
                return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new ResultDO<Void>(false, ResultCode.DATABASE_CAN_NOT_FIND_DATA,
                ResultCode.MSG_DATABASE_CAN_NOT_FIND_DATA, null);
        }

        return null;
    }

    /**
     * 获取本地图片
     */
    @Override
    @GetMapping(value = "img/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable("imageName") String imageName) {
        byte[] imageContent;
        imageContent = fileToByte(new File(ConstantHolder.IMG_SAVE_PATH + imageName));
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(imageContent, headers, HttpStatus.OK);
    }

}
