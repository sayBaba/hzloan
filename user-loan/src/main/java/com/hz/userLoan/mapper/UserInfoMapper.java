package com.hz.userLoan.mapper;

import com.hz.userLoan.model.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoMapper {

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    /**
     * 根据手机查询
     * @param mobile
     * @return
     */
    UserInfo queryUserByMobile(@Param("mobile")String mobile);

}