package com.hz.userLoan.service;

import com.hz.userLoan.vo.Result;
import com.hz.userLoan.vo.UserLoginReq;
import com.hz.userLoan.vo.UserRegReq;

public interface UserService {

    /**
     * 用户注册
     * @param regReq
     * @return
     */
    public Result userRegister(UserRegReq regReq);

    /**
     * 用户登录
     * @param userLoginReq
     * @return
     */
    public Result userLogin(UserLoginReq userLoginReq);

}
