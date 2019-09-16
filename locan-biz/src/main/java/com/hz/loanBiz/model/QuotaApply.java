package com.hz.loanBiz.model;

import java.util.Date;

public class QuotaApply {
    private Long id;

    private String userId;

    private String applyId;

    private Date applyDate;

    private String applyQuota;

    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getApplyQuota() {
        return applyQuota;
    }

    public void setApplyQuota(String applyQuota) {
        this.applyQuota = applyQuota == null ? null : applyQuota.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}