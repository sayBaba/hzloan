package com.hz.loanBiz.service.impl;

import com.hz.loanBiz.service.CreditGrantingService;
import com.hz.loanBiz.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 授信相关实现
 */
@Service
public class CreditGrantingServiceImpl implements CreditGrantingService {

    private static final Logger logger = LoggerFactory.getLogger(CreditGrantingServiceImpl.class);


    @Override
    public Result createCreditQuota(String userId) {
        return null;
    }

    @Override
    public Result getCreditQuota(String userId) {
        return null;
    }
}
