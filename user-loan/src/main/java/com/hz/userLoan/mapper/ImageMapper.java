package com.hz.userLoan.mapper;

import com.hz.userLoan.model.Image;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Image record);

    int insertSelective(Image record);

    Image selectByPrimaryKey(Long id);

}