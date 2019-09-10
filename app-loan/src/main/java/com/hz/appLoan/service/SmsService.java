package com.hz.appLoan.service;

import com.hz.appLoan.resp.Result;
import com.hz.appLoan.service.impl.SmsServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户相关接口
 */
@FeignClient(value = "locan-biz",fallback = SmsServiceImpl.class )
public interface SmsService {

    /**
     * 发送短信
     * @param mobile
     * @param bizType
     */
    @RequestMapping(value = "/sms/send", method = RequestMethod.POST)
    public Result sendSms(@RequestParam("mobile") String mobile, @RequestParam("bizType") String bizType);



}
