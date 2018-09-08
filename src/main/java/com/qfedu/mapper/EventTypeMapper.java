package com.qfedu.mapper;

import com.qfedu.domain.EventType;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EventTypeMapper {
    int deleteByPrimaryKey(Integer id);



    int insertSelective(EventType record);

    EventType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EventType record);

    int updateByPrimaryKey(EventType record);



    List<EventType> selectAll(@Param("uid") Integer uid);
    Integer selectId(@Param("uid") Integer uid, @Param("typename") String typename);

    Integer insert(EventType eventType);

}