package com.hz.appLoan.service.impl;

import com.hz.appLoan.req.UserReq;
import com.hz.appLoan.resp.Result;
import com.hz.appLoan.service.UserService;
import org.springframework.stereotype.Component;

/**
 * 用户服务
 */
@Component
public class UserServiceImpl implements UserService {

    @Override
    public Result userReg(UserReq userReq) {
        return Result.getFail(-1,"注册失败");
    }

    @Override
    public Result userLogin(UserReq userReq) {
        return Result.getFail(-1,"登录失败");
    }
}
