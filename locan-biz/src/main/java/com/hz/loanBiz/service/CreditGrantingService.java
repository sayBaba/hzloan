package com.hz.loanBiz.service;

import com.hz.loanBiz.vo.Result;
/**
 * 授信相关接口
 */
public interface CreditGrantingService {

    /**
     * 生成授信流水
     * @param userId
     * @return
     */
    public Result createCreditQuota(String userId );

    /**
     * 获取授信额度
     * @param userId
     * @return
     */
    public Result getCreditQuota(String userId );

}
