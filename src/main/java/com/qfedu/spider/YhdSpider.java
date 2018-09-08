package com.qfedu.spider;

import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 *@Author feri
 *@Date Created in 2018/8/8 16:48
 */
@Service
public class YhdSpider implements PageProcessor {
    private Site site=Site.me().addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36").setTimeOut(3000).setSleepTime(100).setCharset("gbk");

    @Override
    public void process(Page page) {

       // System.out.println("---->"+page.getHtml().get());
        page.putField("realname",page.getHtml().xpath("img[@border='0']/@src").all());
        page.putField("showname",page.getHtml().xpath("img[@border='0']/@alt").all());
        System.out.println("Yhd>>>>>>>>>>>>");


    }

    @Override
    public Site getSite() {
        return site;
    }

//    public static void main(String[] args) {
//        new Spider(new YhdSpider()).thread(10).
//                addUrl("http://search.yhd.com/c1320-0-0/").
//                addPipeline(new GoodsPipeline()).start();
//    }
}
