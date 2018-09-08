package com.qfedu.service.impl;

import com.qfedu.domain.EventType;
import com.qfedu.mapper.EventTypeMapper;
import com.qfedu.service.EvenTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvenTypeServiceImpl implements EvenTypeService {
    @Autowired
    private EventTypeMapper mapper;

    @Override
    public List<EventType> selectAllType(Integer uid) {
        return mapper.selectAll(uid);
    }

    @Override
    public boolean insertType(EventType eventType) {
        return mapper.insert(eventType) > 0 ;
    }

    @Override
    public boolean beIn(Integer uid,String typename) {
        return mapper.selectId(uid,typename) != null;
    }

    @Override
    public boolean addEventype(EventType eventType) {

        return mapper.insert(eventType) != null;
    }
}
