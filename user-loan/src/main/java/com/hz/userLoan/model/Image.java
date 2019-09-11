package com.hz.userLoan.model;

import lombok.Data;

import java.util.Date;

@Data
public class Image {

    private Long id;

    private String bizTyp;

    private String imgUrl;

    private String userId;

    private Date createDate;
}