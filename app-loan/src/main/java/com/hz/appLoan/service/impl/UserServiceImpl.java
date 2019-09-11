package com.hz.appLoan.service.impl;

import com.hz.appLoan.req.*;
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
    public Result userImgUpLoad(UserUploadImgReq imgReq) {
        return Result.getFail(-1,"图片上传失败");
    }

    @Override
    public Result addUserBasic(UserBasicInfoReq basicInfoReq) {
        return Result.getFail(-1,"添加基本信息失败");
    }

    @Override
    public Result addUserWork(UserWorkReq workReq) {
        return Result.getFail(-1,"添加工作信息失败");
    }

    @Override
    public Result addContact(UserEmergencyContactReq userReq) {
        return Result.getFail(-1,"添加紧急联系人失败");
    }

    @Override
    public Result userLogin(UserReq userReq) {
        return Result.getFail(-1,"登录失败");
    }
}
