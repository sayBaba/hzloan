package com.hz.appLoan.controller;

import com.hz.appLoan.req.UserReq;
import com.hz.appLoan.resp.Result;
import com.hz.appLoan.service.SmsService;
import com.hz.appLoan.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关的接口
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private SmsService smsService;

    @Autowired
    private UserService userService;

    /**
     * 发送短信
     * @param userReq
     * @return
     */
    @RequestMapping("/sms")
    public Result sendSms(@RequestBody UserReq userReq){
        logger.info("接受到手机号:{}发送短信验证码请求,bizType:{}",userReq.getMobile(),userReq.getBizType());
        String bizType = userReq.getBizType();
        String mobile = userReq.getMobile();
        if (StringUtils.isEmpty(bizType)){
            return Result.getFail(-1,"bizType不能为空");
        }

        if (StringUtils.isEmpty(mobile)){
            return Result.getFail(-1,"手机号不能为空");
        }

        return smsService.sendSms(mobile,bizType);
    }


    /**
     * 用户注册
     * @param userReq
     * @return
     */
    @RequestMapping("/reg")
    public Result userRegister(@RequestBody UserReq userReq){
        logger.info("接受到手机号:{}注册请求...",userReq.getMobile());
        String verifyCode = userReq.getVerifyCode();
        String mobile = userReq.getMobile();
        if (StringUtils.isEmpty(verifyCode)){
            return Result.getFail(-1,"短信验证不能为空");
        }

        if (StringUtils.isEmpty(mobile)){
            return Result.getFail(-1,"手机号不能为空");
        }

        if (StringUtils.isEmpty(userReq.getPassword())){
            return Result.getFail(-1,"密码不能为空");
        }

        if (StringUtils.isEmpty(userReq.getBizType())){
            return Result.getFail(-1,"bizType不能为空");
        }

        return userService.userReg(userReq);
    }

    /**
     * 用户登录
     * @param userReq
     * @return
     */
    @RequestMapping("/login")
    public Result userLogin(@RequestBody UserReq userReq){
        if (StringUtils.isEmpty(userReq.getMobile())){
            return Result.getFail(-1,"手机号不能为空");
        }

        if (StringUtils.isEmpty(userReq.getPassword())){
            return Result.getFail(-1,"密码不能为空");
        }

        return userService.userLogin(userReq);
    }


}
