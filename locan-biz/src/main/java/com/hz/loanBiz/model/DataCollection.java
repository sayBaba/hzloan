package com.hz.loanBiz.model;

import java.util.Date;

public class DataCollection {
    private Long id;

    private String basicInfoStaus;

    private String workInfoStatus;

    private String contantInfoStatus;

    private String userId;

    private Date createDate;

    private Date updateDatte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBasicInfoStaus() {
        return basicInfoStaus;
    }

    public void setBasicInfoStaus(String basicInfoStaus) {
        this.basicInfoStaus = basicInfoStaus == null ? null : basicInfoStaus.trim();
    }

    public String getWorkInfoStatus() {
        return workInfoStatus;
    }

    public void setWorkInfoStatus(String workInfoStatus) {
        this.workInfoStatus = workInfoStatus == null ? null : workInfoStatus.trim();
    }

    public String getContantInfoStatus() {
        return contantInfoStatus;
    }

    public void setContantInfoStatus(String contantInfoStatus) {
        this.contantInfoStatus = contantInfoStatus == null ? null : contantInfoStatus.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDatte() {
        return updateDatte;
    }

    public void setUpdateDatte(Date updateDatte) {
        this.updateDatte = updateDatte;
    }
}