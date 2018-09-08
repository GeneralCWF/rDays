package com.qfedu.service.impl;

import com.qfedu.domain.Bgimg;
import com.qfedu.mapper.BgimgMapper;
import com.qfedu.service.BgimgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BgimgServiceImpl implements BgimgService {

    @Autowired
    private BgimgMapper bgimgMapper;

    @Override
    public int addBging(Bgimg bgimg) {
        return bgimgMapper.insert(bgimg);
    }

    @Override
    public List<Bgimg> selectAll() {
        return bgimgMapper.selectAll();
    }

    @Override
    public List<Bgimg> selectHead() {
        return bgimgMapper.selectHead();
    }
}
