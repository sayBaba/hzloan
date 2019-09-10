package com.hz.userLoan.IClient.impl;

import com.hz.userLoan.IClient.IBizClient;
import com.hz.userLoan.vo.Result;

public class BizClientImpl implements IBizClient {

    @Override
    public Result getSmsCode(String mobile, String bizType) {
        return Result.getFail(-1,"查询短信失败");
    }
}
