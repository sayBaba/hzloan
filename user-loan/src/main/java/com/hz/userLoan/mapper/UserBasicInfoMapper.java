package com.hz.userLoan.mapper;


import com.hz.userLoan.model.UserBasicInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBasicInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserBasicInfo record);

    int insertSelective(UserBasicInfo record);

    UserBasicInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserBasicInfo record);

    int updateByPrimaryKey(UserBasicInfo record);
}