package com.qfedu.web.controller;

import com.qfedu.common.vo.Result;
import com.qfedu.domain.Bgimg;
import com.qfedu.domain.User;
import com.qfedu.service.BgimgService;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BgimgController {

    @Autowired
    private BgimgService bgimgService;
    @Autowired
    private UserService userService;

    @RequestMapping("/allBgimg.do")
    @ResponseBody
    public Result<Bgimg> allBgimg(){
        Result<Bgimg> result = new Result<>();

        result.setCode(1000);
        result.setMsg("展示背景图片");
        result.setData(bgimgService.selectAll());

        return result;
    }

    @RequestMapping("/allHeadimg.do")
    @ResponseBody
    public Result<Bgimg> allHeadimg(){
        Result<Bgimg> result = new Result<>();

        result.setCode(1000);
        result.setMsg("展示头像");
        result.setData(bgimgService.selectHead());

        return result;
    }

    @RequestMapping("/addHeadimg.do")
    @ResponseBody
    public  Result<User> addHeadimg(int uid, String headimg){
        Result<User> result = new Result<>();

        userService.updateHeadimg(uid,headimg);
        result.setCode(1000);
        result.setMsg("设置头像成功");

        return result;
    }

}
