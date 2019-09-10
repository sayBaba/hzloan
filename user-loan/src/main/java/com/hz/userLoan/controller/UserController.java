package com.hz.userLoan.controller;

import com.hz.userLoan.service.UserService;
import com.hz.userLoan.vo.Result;
import com.hz.userLoan.vo.UserLoginReq;
import com.hz.userLoan.vo.UserRegReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param userReg
     * @return
     */
    @RequestMapping("/register")
    public Result userReg(@RequestBody UserRegReq userReg){
        logger.info("接收到手机号：{}的注册请求,验证码：{}",userReg.getMobile(),userReg.getVerifyCode());
        //TODO 空判断
        Result result = userService.userRegister(userReg);
        return result;
    }

    /**
     * 用户登录
     * @param loginReq
     * @return
     */
    @RequestMapping("/login")
    public Result userLoin(UserLoginReq loginReq){
        logger.info("接收到手机号：{}的登录请求,密码：",loginReq.getMobile(),loginReq.getPassword());
        //TODO 空判断
        Result result = userService.userLogin(loginReq);
        return result;
    }



}
