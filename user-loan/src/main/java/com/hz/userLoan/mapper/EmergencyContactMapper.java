package com.hz.userLoan.mapper;

import com.hz.userLoan.model.EmergencyContact;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyContactMapper {

    int deleteByPrimaryKey(Long id);

    int insert(EmergencyContact record);

    int insertSelective(EmergencyContact record);


    EmergencyContact selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EmergencyContact record);

    int updateByPrimaryKey(EmergencyContact record);
}