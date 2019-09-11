package com.hz.userLoan.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserBasicInfo {
    private Long id;

    private String userId;

    private String education;

    private String maritalStatus;

    private String mail;

    private String liveAddress;

    private String housePhone;

    private Date createDate;


}