package com.qfedu.main;


import com.qfedu.mapper.BgimgMapper;
import com.qfedu.spider.GoodsPipeline;
import com.qfedu.spider.YhdSpider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

/**
 *@Author feri
 *@Date Created in 2018/8/8 17:21
 */
public class Spider_Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-*.xml");
        System.out.println("mmm---->"+context.getBean(BgimgMapper.class));
        BgimgMapper mapper=context.getBean(BgimgMapper.class);
//        Map<String,String> map=new HashMap();
//        map.put("name","测试");
//        map.put("price","1000");
//        map.put("picurl","");
//        System.out.println( mapper.insertBySpider(map));
        YhdSpider yhdSpider=context.getBean(YhdSpider.class);
        GoodsPipeline pipeline=context.getBean(GoodsPipeline.class);
        System.out.println(context.getBean(YhdSpider.class));
        System.out.println(context.getBean(GoodsPipeline.class));

        System.out.println(">>>>>>>>>>>");
        Spider spider=new Spider(yhdSpider).thread(10).
                addUrl("http://www.qqpk.cn/Article/tupian/201708/64965.htm").
                addPipeline(pipeline);
        spider.start();
        System.out.println("<<<<<<<<<<<");
    }
}
