package com.hz.appLoan.req;

import lombok.Data;

import java.util.Date;

/**
 * 用户工作信息
 */
@Data
public class UserWorkReq {

    private Integer workeYear;

    private Integer socialYear;

    private String campanyName;

    private String campanyAddress;

    private String campanyPhone;

    private Date entryTime;

    private String monthlyIncome;

    private String userId;
}
