package com.hz.appLoan.controller;

import com.hz.appLoan.req.UserUploadImgReq;
import com.hz.appLoan.resp.Result;
import com.hz.appLoan.service.UserService;
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

    @Autowired
    private UserService userService;

    /**
     * 图片上传
     */
    @RequestMapping("/upload")
    public Result uploadImg(@RequestParam MultipartFile file,
                            @RequestParam("userId")String userId,
                            @RequestParam("bizType")String bizType,
                            @RequestParam("realName")String realName,
                            @RequestParam("idCard")String idCard) {
        logger.info("接受到userId:{}上传图片请求{}", userId);

        if (file.isEmpty()) {
            return Result.getFail(-1, "文件为空，请重新上传");
        }

        try {
            //使用base64方式上传到七牛云
            String url = qiniuUtil.byteUpLoad(file.getBytes());
            logger.info("用户id：{}上传到七牛云的地址：{}",userId,url);
            UserUploadImgReq userUploadImgReq = new UserUploadImgReq();
            userUploadImgReq.setBizType(bizType);
            userUploadImgReq.setIdCard(idCard);
            userUploadImgReq.setUserId(userId);
            userUploadImgReq.setRealName(realName);
            userUploadImgReq.setImgUrl(url);

            Result result = userService.userImgUpLoad(userUploadImgReq);
            return result;
        } catch (Exception e) {
            logger.error("Exception",e);
            return Result.getFail(-1,"文件上传发生异常");
        }
    }

}
