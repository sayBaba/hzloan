package com.hz.loanBiz.vo;

import lombok.Data;

/**
 * 上传图片请求实体
 */
@Data
public class ImgUpLoadReq {

    private String userId;
    private String imgUrl; //本地图片地址
    private String type; //类型，0-身份证上传
    private String realName;
    private String idCard;



}
