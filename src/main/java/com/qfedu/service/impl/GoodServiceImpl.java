package com.qfedu.service.impl;

import com.qfedu.domain.Good;
import com.qfedu.mapper.GoodMapper;
import com.qfedu.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodMapper goodMapper;

    @Override
    public int addGood(Good good) {
        return goodMapper.insert(good);
    }
}
