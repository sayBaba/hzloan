package com.hz.loanBiz.vo;

import lombok.Data;

/**
 * 短信请求
 */
@Data
public class SmsReq {

    private String mobile;

    private String bizType;

}
