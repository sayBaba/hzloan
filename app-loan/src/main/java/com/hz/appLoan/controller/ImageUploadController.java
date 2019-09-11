package com.hz.appLoan.controller;

import com.hz.appLoan.resp.Result;
import com.hz.appLoan.utils.QiniuUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.UUID;

/**
 * 图片上传
 */
@RestController
@RequestMapping("/img")
public class ImageUploadController {


    private static final Logger logger = LoggerFactory.getLogger(ImageUploadController.class);

    @Autowired
    private QiniuUtil qiniuUtil;

    /**
     * 图片上传
     */
    @ResponseBody
    @RequestMapping("/upload")
    public Result uploadImg(@RequestParam MultipartFile image, @RequestParam("userId")String userId) {
        logger.info("接受到userId:{}上传图片请求{}", userId);

        if (image.isEmpty()) {
            return Result.getFail(-1, "文件为空，请重新上传");
        }
        try {
            byte[] bytes = image.getBytes();
            String imageName = UUID.randomUUID().toString();
            //使用base64方式上传到七牛云
//            String url = qiniuUtil.put64image(bytes, imageName);
            String url = qiniuUtil.byteUpLoad(image.getBytes());
            logger.info("=============图片url:{}","");
            Result result = new Result();
            result.setCode(0);
            result.setMsg("文件上传成功");
            return result;
        } catch (Exception e) {
            logger.error("Exception",e);
            return Result.getFail(-1,"文件上传发生异常");
        }
    }

}
