package com.qfedu.web.controller;

import com.qfedu.common.vo.Result;
import com.qfedu.domain.EventType;
import com.qfedu.service.EvenTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EvenTypeController {
    //private Result<EventType> result;
    @Autowired
    private EvenTypeService service;
    public Result<EventType> result = new Result<>();
    /**
     * 展示事件类型
     * @param uid
     * @return
     */
    @RequestMapping("/listEvenType.do")
    @ResponseBody
    public Result listAllType(Integer uid){
        if (service.selectAllType(uid) == null || service.selectAllType(uid).size() == 0){
            result.setCode(0);
            result.setMsg("数据为空");
            return result;
        }else {
            result.setCode(1);
            result.setData(service.selectAllType(uid));
            return result;
        }
    }
    /**
     * 判断是否已经存在同类型
     */
    @RequestMapping("/isExist.do")
    @ResponseBody
    public Result isExist(Integer uid,String typename){
        if (service.beIn(uid,typename)){
            result.setCode(0);
            result.setMsg("该类型已经存在");
            return result;
        } else {
            result.setCode(1);
            result.setMsg("该类型可以添加");
            return result;
        }
    }

    /**
     * 添加类型
     */
    @RequestMapping("/addType.do")
    @ResponseBody
    public Result addType(EventType eventType){

        Integer uid = eventType.getId();
        String typename = eventType.getTypename();
        //判断是否已经存在要添加的名字
        if (service.beIn(uid,typename)){
            result.setCode(0);
            result.setMsg("该类型名称已存在");
            return result;
        } else {

            //判断添加是否成功
            if (service.addEventype(eventType)) {
                result.setCode(1);
                result.setMsg("添加成功");
                return result;
            } else {
                result.setCode(2);
                result.setMsg("添加失败，稍后再试");
                return result;
            }
        }
    }


}
