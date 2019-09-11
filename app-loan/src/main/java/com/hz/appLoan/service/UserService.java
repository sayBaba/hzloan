package com.hz.appLoan.service;

import com.hz.appLoan.req.*;
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

    /**
     * 用户注册
     * @param userReq
     * @return
     */
    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public Result userReg(@RequestBody UserReq userReq);

    /**
     * 用户登录
     * @param userReq
     * @return
     */
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public Result userLogin(@RequestBody UserReq userReq);

    /**
     * 图片上传
     * @param imgReq
     * @return
     */
    @RequestMapping(value = "/user/imgUpLoad", method = RequestMethod.POST)
    public Result userImgUpLoad(@RequestBody UserUploadImgReq imgReq);

    /**
     * 添加用户基本信息
     * @param basicInfoReq
     * @return
     */
    @RequestMapping(value = "/user/addUserBasicInfo", method = RequestMethod.POST)
    public Result addUserBasic(@RequestBody UserBasicInfoReq basicInfoReq);

    /**
     * 添加工作信息
     * @param workReq
     * @return
     */
    @RequestMapping(value = "/user/addWork", method = RequestMethod.POST)
    public Result addUserWork(@RequestBody UserWorkReq workReq);


    /**
     * 添加紧急联系人
     * @param userReq
     * @return
     */
    @RequestMapping(value = "/user/addContact", method = RequestMethod.POST)
    public Result addContact(@RequestBody UserEmergencyContactReq userReq);

}
