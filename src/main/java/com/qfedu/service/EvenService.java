package com.qfedu.service;

import com.qfedu.domain.Event;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EvenService {
    boolean insertEven(Event event);
    List<Event> selectAllEven(Integer uid);
    List<Event> selectByTypename( Integer uid,String typename);
}
