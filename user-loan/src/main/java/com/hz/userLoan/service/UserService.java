package com.hz.userLoan.service;

import com.hz.userLoan.vo.*;

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

    /**
     * 上传身份证信息
     * @param
     * @return
     */
    public Result updateImg(UserUploadImgReq userUploadImgReq);

    /**
     * 添加个人资料
     * @param userBasicInfoReq
     * @return
     */
    public Result addUserInfo( UserBasicInfoReq userBasicInfoReq);

    /**
     * 添加工作信息
     * @param
     * @return
     */
    public Result addWorkInfo(UserWorkReq userWorkReq);

    /**
     * 添加联系人信息
     * @param
     * @return
     */
    public Result addContant(UserEmergencyContactReq userEmergencyContactReq);

}
