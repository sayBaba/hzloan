package com.hz.userLoan.mapper;

import java.util.List;

import com.hz.userLoan.model.UserWork;
import org.springframework.stereotype.Repository;

@Repository
public interface UserWorkMapper {


    int insert(UserWork record);

    int insertSelective(UserWork record);

    UserWork selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(UserWork record);

    int updateByPrimaryKey(UserWork record);
}