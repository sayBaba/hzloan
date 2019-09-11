package com.hz.userLoan.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserWork {

    private Long id;

    private Integer workeYear;

    private Integer socialYear;

    private String campanyName;

    private String campanyAddress;

    private String campanyPhone;

    private Date entryTime;

    private String monthlyIncome;

    private Date createDate;

    private String userId;

}