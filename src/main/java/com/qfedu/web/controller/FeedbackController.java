package com.qfedu.web.controller;

import com.qfedu.common.vo.Result;
import com.qfedu.domain.Feedback;
import com.qfedu.domain.User;
import com.qfedu.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping("/addBack.do")
    @ResponseBody
    public Result<User> addFeedback(Feedback feedback){

        Result<User> result = new Result<>();
        if(feedbackService.addFeedback(feedback) > 0){
            result.setCode(1000);
            result.setMsg("反馈成功");
        } else {
            result.setCode(1001);
            result.setMsg("反馈失败");
        }

        return result;
    }
}
