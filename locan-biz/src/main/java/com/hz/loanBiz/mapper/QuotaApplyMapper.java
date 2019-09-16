package com.hz.loanBiz.mapper;

import com.hz.loanBiz.model.QuotaApply;

import org.springframework.stereotype.Repository;

@Repository
public interface QuotaApplyMapper {

    int insert(QuotaApply record);

    int insertSelective(QuotaApply record);

}