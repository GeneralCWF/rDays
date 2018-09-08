package com.qfedu.mapper;

import com.qfedu.domain.Event;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EventMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Event record);

    /**
     * 增加事件
     * @param event
     * @return
     */
    int insertSelective(Event event);

    /**
     * 展示事件列表
     *
     * @return
     */
    List<Event> selectAll(Integer uid);

    /**
     * 通过事件类型id展示事件
     * @return
     */
    List<Event> selectByTypename(@Param("uid") Integer uid, @Param("typename") String typename);




    Event selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Event record);

    int updateByPrimaryKeyWithBLOBs(Event record);

    int updateByPrimaryKey(Event record);
}