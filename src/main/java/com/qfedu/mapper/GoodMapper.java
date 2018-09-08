package com.qfedu.mapper;

import com.qfedu.domain.Good;

public interface GoodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Good record);

    int insertSelective(Good record);

    Good selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKeyWithBLOBs(Good record);

    int updateByPrimaryKey(Good record);
}