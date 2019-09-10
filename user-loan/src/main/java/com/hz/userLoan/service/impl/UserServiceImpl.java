package com.hz.userLoan.service.impl;

import com.hz.userLoan.IClient.IBizClient;
import com.hz.userLoan.mapper.UserInfoMapper;
import com.hz.userLoan.model.UserInfo;
import com.hz.userLoan.service.UserService;
import com.hz.userLoan.utils.JWTUtils;
import com.hz.userLoan.vo.Result;
import com.hz.userLoan.vo.UserData;
import com.hz.userLoan.vo.UserLoginReq;
import com.hz.userLoan.vo.UserRegReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
