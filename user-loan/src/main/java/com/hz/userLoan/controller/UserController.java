package com.hz.userLoan.controller;

import com.hz.userLoan.service.UserService;
import com.hz.userLoan.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Result userLoin(@RequestBody UserLoginReq loginReq){
        logger.info("接收到手机号：{}的登录请求,密码：",loginReq.getMobile(),loginReq.getPassword());
        //TODO 空判断
        Result result = userService.userLogin(loginReq);
        return result;
    }

    /**
     * 上传身份证
     */
    @RequestMapping("/imgUpLoad")
    public Result upLoadIdImage(@RequestBody UserUploadImgReq uploadImgReq){
        logger.info("开始处理用户id：{}上传身份证请求..",uploadImgReq.getUserId());
        return userService.updateImg(uploadImgReq);
    }

    /**
     * 添加用户基本信息
     */
    @RequestMapping("/addUserBasicInfo")
    public Result addUserBasicInfo(@RequestBody UserBasicInfoReq userBasicInfoReq){
        logger.info("开始处理用户id：{}添加用户基本信息..",userBasicInfoReq.getUserId());
        return userService.addUserInfo(userBasicInfoReq);
    }

    /**
     * 添加用户工作信息
     */
    @RequestMapping("/addUserWork")
    public Result addUserWork(@RequestBody UserWorkReq userWorkReq){
        logger.info("开始处理用户id：{}添加用户工作信息..",userWorkReq.getUserId());
        return userService.addWorkInfo(userWorkReq);
    }

    /**
     * 添加紧急联系人
     */
    @RequestMapping("/addContact")
    public Result addEmergencyContact(@RequestBody UserEmergencyContactReq userEmergencyContactReq){
        logger.info("开始处理用户id：{}添加紧急联系人..",userEmergencyContactReq.getUserId());
        return userService.addContant(userEmergencyContactReq);
    }

}
