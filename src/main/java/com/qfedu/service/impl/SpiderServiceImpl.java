package com.qfedu.service.impl;


import com.qfedu.domain.Bgimg;
import com.qfedu.mapper.BgimgMapper;
import com.qfedu.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/7/31 19:24
 */
@Service
public class SpiderServiceImpl implements SpiderService{
    @Autowired
    private BgimgMapper bgimgMapper;

    @Override
    public int addBgimg(Bgimg bgimg) {
        return bgimgMapper.insert(bgimg);
    }
}
