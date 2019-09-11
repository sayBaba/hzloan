package com.hz.appLoan.req;

import lombok.Data;

/**
 * 上传照片
 */
@Data
public class UserUploadImgReq {

    private String userId;
    private String imgUrl; //图片地址
    private String bizType; //图片类型

    private String realName; //真实姓名
    private String idCard; //身份证号



}
