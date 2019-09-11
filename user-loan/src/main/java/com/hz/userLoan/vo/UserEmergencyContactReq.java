package com.hz.userLoan.vo;

import lombok.Data;

/**
 * 添加用户紧急联系人
 */
@Data
public class UserEmergencyContactReq {

    private String userId;

    private String contact1Name;

    private String contact1Relation;

    private String contact1Phone;

    private String contact2Name;

    private String contact2Relation;

    private String contact2Phone;
}
