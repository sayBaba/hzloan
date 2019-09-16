package com.hz.loanBiz.mapper;

import com.hz.loanBiz.model.DataCollection;
import org.springframework.stereotype.Repository;

@Repository
public interface DataCollectionMapper {

    int insert(DataCollection record);

    int insertSelective(DataCollection record);

}