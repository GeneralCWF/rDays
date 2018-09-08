package com.qfedu.service;

import com.qfedu.domain.Bgimg;

import java.util.List;

public interface BgimgService {

    int addBging(Bgimg bgimg);

    List<Bgimg> selectAll();

    List<Bgimg> selectHead();
}
