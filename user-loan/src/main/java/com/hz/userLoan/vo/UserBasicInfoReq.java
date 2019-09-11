package com.hz.userLoan.vo;

import lombok.Data;

/**
 * 添加用户基本信息请求
 */
@Data
public class UserBasicInfoReq {

    private String userId;

    private String education;

    private String maritalStatus;

    private String mail;

    private String liveAddress;

    private String housePhone;

}
