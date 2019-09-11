package com.hz.appLoan.req;

import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * 添加用户基本信息请求
 */
@Data
public class UserBasicInfoReq {

    @NotNull(message ="手机不能为空")
    private String userId;

    @NotNull(message ="教育程度不能为空")
    private String education;

    @NotNull(message ="婚姻状况不能为空")
    private String maritalStatus;

    @NotNull(message ="邮件地址不能为空")
    private String mail;

    @NotNull(message ="邮件地址不能为空")
    private String liveAddress;

    @NotNull(message ="居住地电话不能为空")
    private String housePhone;

}
