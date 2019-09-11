package com.hz.userLoan.model;

import lombok.Data;

import java.util.Date;

@Data
public class EmergencyContact {

    private Long id;

    private String userId;

    private String contact1Name;

    private String contact1Relation;

    private String contact1Phone;

    private String contact2Name;

    private String contact2Relation;

    private String contact2Phone;

    private Date createDate;

}