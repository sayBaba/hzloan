package com.hz.userLoan.service.impl;

import com.hz.userLoan.IClient.IBizClient;
import com.hz.userLoan.mapper.*;
import com.hz.userLoan.model.*;
import com.hz.userLoan.service.UserService;
import com.hz.userLoan.utils.JWTUtils;
import com.hz.userLoan.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.UUID;

/**
 * 用户相关接口实现类
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private ImageMapper imageMapper;

    @Autowired
    private UserBasicInfoMapper userBasicInfoMapper;

    @Autowired
    private UserWorkMapper userWorkMapper;

    @Autowired
    private EmergencyContactMapper contactMapper;

    @Autowired
    private IBizClient iBizClient;

    @Override
    public Result userRegister(UserRegReq regReq) {
        String mobile = regReq.getMobile();
        String verifyCode = regReq.getVerifyCode();

        //注册判断验证码
        Result bizRlt = iBizClient.getSmsCode(mobile,regReq.getBizType());
        if(ObjectUtils.isEmpty(bizRlt)){
            return Result.getFail(-1,"查询验证码失败");
        }
        if(bizRlt.getCode()!= 0){
            return Result.getFail(-1,"查询验证码失败");
        }

        String dbCode = (String) bizRlt.getT();
        logger.info("手机号：{}对应的数据中的验证码为：{}",mobile,dbCode);
        if (!verifyCode.equals(dbCode)){
            return Result.getFail(-1,"输入的验证码不正确");
        }
        String userId = UUID.randomUUID().toString().replace("-","");

        UserInfo userInfo = new UserInfo();
        userInfo.setCreateDate(new Date());
        userInfo.setStatus("0");
        userInfo.setUserMobile(mobile);
        userInfo.setUserId(userId);
        userInfo.setUserPassword(regReq.getPassword());
        userInfoMapper.insertSelective(userInfo);

        return Result.getSuc();
    }

    @Override
    public Result userLogin(UserLoginReq userLoginReq) {
        UserInfo userInfo = userInfoMapper.queryUserByMobile(userLoginReq.getMobile());
        if (ObjectUtils.isEmpty(userInfo)){
            return Result.getFail(-1,"手机号不存在");
        }

        if (!userLoginReq.getPassword().equals(userInfo.getUserPassword())) {
            return Result.getFail(-1,"密码输入不正确");
        }
        //登录成功，生成token
        String token = JWTUtils.sign(userLoginReq.getMobile(),userLoginReq.getPassword());
        UserData userData = new UserData();
        userData.setToken(token);
        userData.setUserId(userInfo.getUserId());
        Result result = Result.getSuc();
        result.setT(userData);
        return result;
    }

    @Override
    @Transactional
    public Result updateImg(UserUploadImgReq req) {
        //第一步往，图片表添加记录
        Image image = new Image();
        image.setImgUrl(req.getImgUrl());
        image.setBizTyp(req.getBizType());
        image.setCreateDate(new Date());
        image.setUserId(req.getUserId());
        int i= imageMapper.insertSelective(image);
        logger.info("添加图片表：{}",i);

        //代表身份证上传
        if(req.getBizType()=="0"){
            //第二步，更新用户身份证和姓名
            UserInfo userInfo = new UserInfo();
            userInfo.setRealName(req.getRealName());
            userInfo.setUserId(req.getUserId());
            userInfo.setIdCard(req.getIdCard());
            int l= userInfoMapper.updateByPrimaryKeySelective(userInfo);
            logger.info("更新数据库记录：{}",l);
        }

        return Result.getSuc();
    }

    @Override
    public Result addUserInfo(UserBasicInfoReq req) {
        UserBasicInfo userBasicInfo = new UserBasicInfo();
        BeanUtils.copyProperties(req,userBasicInfo);
        //TODO,userId 是否存在，存在就更新
        userBasicInfoMapper.insertSelective(userBasicInfo);
        //TODO,更新 tb_data_collection的
        return Result.getSuc();
    }

    @Override
    public Result addWorkInfo(UserWorkReq userWorkReq) {
        UserWork userWork = new UserWork();
        BeanUtils.copyProperties(userWorkReq,userWork);
        //TODO,userId 是否存在，存在就更新
        userWorkMapper.insertSelective(userWork);
        //TODO,更新 tb_data_collection的
        return Result.getSuc();
    }

    @Override
    public Result addContant(UserEmergencyContactReq userEmergencyContactReq) {

        EmergencyContact emergencyContact = new EmergencyContact();
        BeanUtils.copyProperties(userEmergencyContactReq,emergencyContact);
        contactMapper.insertSelective(emergencyContact);
        //TODO,更新 tb_data_collection的
        return null;
    }
}
