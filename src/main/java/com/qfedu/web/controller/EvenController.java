package com.qfedu.web.controller;

import com.qfedu.common.vo.Result;
import com.qfedu.domain.Event;
import com.qfedu.domain.EventType;
import com.qfedu.service.EvenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.ResultSet;
import java.util.List;

@Controller
public class EvenController {
    private Result result;
    @Autowired
    private EvenService service;
    @RequestMapping("/addEven.do")
    @ResponseBody
    public Result addeven(Event event) {
        Result<Event> result = new Result<>();
        if (service.insertEven(event)){
            result.setCode(1001);
            result.setMsg("添加成功");
            return result;
        } else {
            result.setCode(1000);
            result.setMsg("网络忙。稍后再试");
            return result;
        }
    }
    @RequestMapping("/listEven.do")
    @ResponseBody
    public Result listEven(Integer uid){
        Result<Event> result = new Result<>();
        if (service.selectAllEven(uid) != null && service.selectAllEven(uid).size() > 0){
            List<Event> events = service.selectAllEven(uid);
            result.setCode(1);
            result.setData(events);
            return result;
        } else {
            result.setCode(0);
            result.setMsg("暂无事件");
            return result;
        }
    }
    /**
     * 类型展示
     */
    @RequestMapping("/typelist.do")
    @ResponseBody
    public Result listAllEvenByTypename(Integer uid, String typename) {
        Result<Event> result = new Result<>();
        if (service.selectByTypename(uid, typename) != null && service.selectByTypename(uid, typename).size() > 0) {
            result.setData(service.selectByTypename(uid, typename));
            result.setCode(1001);
            return result;
        } else {
            result.setCode(1000);
            result.setMsg("暂无事件，请添加");
            return result;
        }
    }
}
