package com.hz.userLoan.vo;

import lombok.Data;

/**
 * 登录成功返回给移动端
 */
@Data
public class UserData {

    private String token;
    private String userId;

}
