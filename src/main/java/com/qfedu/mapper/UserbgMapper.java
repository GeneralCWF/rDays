package com.qfedu.mapper;

import com.qfedu.domain.User;
import com.qfedu.domain.Userbg;
import org.apache.ibatis.annotations.Param;

public interface UserbgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Userbg record);

    int insertSelective(Userbg record);

    Userbg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Userbg record);

    int updateByPrimaryKey(Userbg record);


}