package com.qfedu.service;

import com.qfedu.domain.EventType;

import java.util.List;

public interface EvenTypeService {
    List<EventType> selectAllType(Integer uid);
    boolean insertType(EventType eventType);
    boolean beIn(Integer uid, String typename);
    boolean addEventype(EventType eventType);
}
