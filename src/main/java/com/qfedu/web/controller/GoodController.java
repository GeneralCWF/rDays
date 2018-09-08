package com.qfedu.web.controller;

import com.qfedu.common.vo.Result;
import com.qfedu.domain.Good;
import com.qfedu.domain.User;
import com.qfedu.mapper.GoodMapper;
import com.qfedu.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GoodController {

    @Autowired
    private GoodService goodService;

    @RequestMapping("/addGood.do")
    @ResponseBody
    public Result<User> addGood(Good good){
        Result<User> result = new Result<>();
        if(goodService.addGood(good) > 0){
            result.setMsg("好评成功");
            result.setCode(1000);
        } else {
            result.setMsg("出错请重试");
            result.setCode(1001);
        }
        return result;
    }
}
