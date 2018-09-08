package com.qfedu.service.impl;

import com.qfedu.domain.Event;
import com.qfedu.mapper.EventMapper;
import com.qfedu.service.EvenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvenServiceImpl implements EvenService {
    @Autowired
    private EventMapper mapper;

    @Override
    public boolean insertEven(Event event) {


        return mapper.insertSelective(event) > 0 ;
    }

    @Override
    public List<Event> selectAllEven(Integer uid) {
        List<Event> events = mapper.selectAll(uid);
        if (events != null || events.size() > 0) {
            return events;
        } else {
            return null;
        }
    }

    @Override
    public List<Event> selectByTypename(Integer uid, String typename) {

        return  mapper.selectByTypename(uid,typename);
    }
}
