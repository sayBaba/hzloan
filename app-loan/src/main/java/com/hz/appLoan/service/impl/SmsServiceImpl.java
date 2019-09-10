package com.hz.appLoan.service.impl;

import com.hz.appLoan.resp.Result;
import com.hz.appLoan.service.SmsService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
public class SmsServiceImpl implements SmsService {

    @Override
    public Result sendSms(String mobile, String bizType) {
        return Result.getFail(-1,"发送短信失败");
    }
}
