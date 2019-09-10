package com.hz.userLoan.IClient;

import com.hz.userLoan.IClient.impl.BizClientImpl;
import com.hz.userLoan.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 调用locan-biz服务
 */
@FeignClient(value = "locan-biz",fallback = BizClientImpl.class )
public interface IBizClient {

    /**
     * 查询验证码
     * @param mobile
     * @param bizType
     * @return
     */
    @RequestMapping(value = "/sms/query", method = RequestMethod.POST)
    public Result getSmsCode(@RequestParam("mobile") String mobile, @RequestParam("bizType")String bizType);
}
