package com.qfedu.spider;

import com.qfedu.domain.Bgimg;
import com.qfedu.mapper.BgimgMapper;
import com.qfedu.service.BgimgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@Author feri
 *@Date Created in 2018/8/8 16:46
 */
@Service
public class GoodsPipeline implements Pipeline {
    @Autowired
    private BgimgService service;
    @Autowired
    BgimgMapper mapper;
    @Override
    public void process(ResultItems resultItems, Task task) {

        List<String> listImg=(List<String>)resultItems.getAll().get("realname");
        List<String> listNames=(List<String>)resultItems.getAll().get("showname");
        System.out.println("bbb--->"+listImg);
        System.out.println("ccc--->"+listNames);
        for(int i=0;i<listImg.size();i++){
            System.out.println("bbb--->"+listImg.size());
            Bgimg bgimg = new Bgimg();
            bgimg.setShowname(listNames.get(i));
            bgimg.setFlag(2);
            bgimg.setRealname("http://www.qqpk.cn"+listImg.get(i));

            //System.err.println("aa---->"+mapper.insert(bgimg));
            System.out.println(service.addBging(bgimg));

            //System.err.println("新增："+service.insertBySpider(map));
        }
    }
}
