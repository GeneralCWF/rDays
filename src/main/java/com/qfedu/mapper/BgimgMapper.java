package com.qfedu.mapper;

import com.qfedu.domain.Bgimg;

import java.util.List;

public interface BgimgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bgimg record);

    int insertSelective(Bgimg record);

    Bgimg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bgimg record);

    int updateByPrimaryKey(Bgimg record);

    List<Bgimg> selectAll();

    List<Bgimg> selectHead();
}