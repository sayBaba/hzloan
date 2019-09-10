package com.hz.appLoan.service;

import com.hz.appLoan.req.UserReq;
import com.hz.appLoan.resp.Result;
import com.hz.appLoan.service.impl.UserServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 调用用户服务
 */
@FeignClient(name = "user-loan",fallback = UserServiceImpl.class)
public interface UserService {

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public Result userReg(@RequestBody UserReq userReq);


    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public Result userLogin(@RequestBody UserReq userReq);

}
