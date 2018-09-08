package com.qfedu.web.controller;

import com.qfedu.common.util.EmailUtils;
import com.qfedu.common.util.MD5Utils;
import com.qfedu.common.vo.EmailMsg;
import com.qfedu.common.vo.Result;
import com.qfedu.domain.User;
import com.qfedu.service.UserService;
import com.qfedu.web.context.MySessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.Session;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private String sessionid;

    //登录
    @RequestMapping("/login.do")
    @ResponseBody
    public Result<User> login(String email, String password, HttpSession session) {
        Result<User> result = new Result<>();
       try {
           User user = userService.login(email,password);
           List<User> list = new ArrayList<>();

           if (user != null) {
               session.setAttribute("user",user);
               list.add(user);
               result.setCode(1000);
               result.setMsg("登陆成功");
               result.setData(list);
               return result;
           } else {
               list.add(user);
               result.setCode(1001);
               result.setMsg("邮箱或密码错误");
               result.setData(null);

               return result;
           }
       } catch (Exception e){
           result.setCode(1001);
           result.setMsg("邮箱或密码错误");
           result.setData(null);

           return result;
       }

    }

    //注册
    @RequestMapping("/register.do")
    @ResponseBody
    public Result<User> register(User user) {
        Result<User> result = new Result<>();

            System.out.println(">>>>用户密码："+user.getPassword());
            System.out.println(">>>>用户邮箱："+user.getEmail());
            if(user.getPassword() != null && user.getPassword().length()>0){

                user.setPassword(MD5Utils.md5(user.getPassword()));
            } else {
                result.setCode(1001);
                result.setMsg("密码为空");
                result.setData(null);

                return result;
            }

            if (userService.register(user) > 0) {
                EmailMsg emailMsg = new EmailMsg();
                emailMsg.setTitle("rDays诚邀您的参与");
                emailMsg.setEmail(user.getEmail());
                emailMsg.setContent("恭喜注册成功，rDays纪念日欢迎您的使用，请前往首页登录");

                EmailUtils.sendEmail(emailMsg);
                result.setCode(1000);
                result.setMsg("注册成功");
                result.setData(null);
                return result;
            } else {
                result.setCode(1001);
                result.setMsg("邮箱已注册");
                result.setData(null);

                return result;
            }


    }

    //获取验证码
    @RequestMapping("/getVcode.do")
    @ResponseBody
    public Result<User> getVcode(String email,int uid){
        Result<User> result = new Result<>();
        User user = userService.selectUid(uid);

        EmailMsg emailMsg = new EmailMsg();
        emailMsg.setTitle("rDays修改密码");
        emailMsg.setEmail(email);

        String code = String.valueOf(Math.ceil(Math.random()*10000));
        String vcode = code.substring(0,code.lastIndexOf('.'));

        userService.insertVcode(user.getId(),vcode);
        emailMsg.setContent("尊敬的 "+email+" 用户,您正在修改密码，如非本人操作，请立即登录系统修改密码。本次验证码为："+vcode);
        EmailUtils.sendEmail(emailMsg);
        result.setCode(1000);
        result.setMsg("发送成功");
        result.setData(null);
        return result;
    }


    //验证验证码
    @RequestMapping("checkVcode.do")
    @ResponseBody
    public Result<User> checkVcode(String vcode,int uid){
        User user = userService.selectUid(uid);
        Result<User> result = new Result<>();
        if(Objects.equals(vcode,userService.getVcode(user.getId()).getVcode())){
            result.setCode(1000);
            result.setMsg("验证成功");

        } else {
            result.setCode(1001);
            result.setMsg("验证失败");

        }
        return result;
    }

    //确认新密码
    @RequestMapping("/forgetPwd.do")
    @ResponseBody
    public Result<User> forgetPwd(int uid,String newpwd){
        User user = userService.selectUid(uid);
        Result<User> result = new Result<>();
        if(userService.newPassword(user.getId(),MD5Utils.md5(newpwd)) > 0){
            result.setCode(1000);
            result.setMsg("修改成功");
        } else {
            result.setCode(1001);
            result.setMsg("修改失败");
        }
        return result;
    }

    //修改密码
    @RequestMapping("/modifyPwd.do")
    @ResponseBody
    public Result<User> modifyPwd(int uid,String oldpwd,String newpwd){
        User user = userService.selectUid(uid);
        Result<User> result = new Result<>();
        if(user == null){
            result.setCode(1001);
            result.setMsg("请登录");
            return result;
        }
        if(userService.modifyPassword(user.getId(),oldpwd,newpwd)>0){
            result.setCode(1000);
            result.setMsg("修改成功");

            return result;
        } else {
            result.setCode(1001);
            result.setMsg("修改失败");

            return result;
        }
    }

    //修改昵称
    @RequestMapping("/modifyName.do")
    @ResponseBody
    public Result<User> modifyName(int uid,String username){
        User user =userService.selectUid(uid);

        Result<User> result = new Result<>();
        if(user != null){

        }

        if(userService.modifyName(user.getId(),username) > 0){
            result.setMsg("修改成功");
            result.setCode(1000);
        } else {
            result.setMsg("修改失败");
            result.setCode(1001);
        }

        return result;
    }

    @RequestMapping("/firstlogin.do")
    @ResponseBody
    public Result<User> firstlogin(HttpSession session){
        Result<User> result = new Result<>();
        result.setCode(1000);
        result.setMsg("测试数据");

        sessionid = session.getId();
        return result;
    }

    @RequestMapping("/setname.do")
    @ResponseBody
    public Result<User> setname(String name){
        User user = new User();

        MySessionContext myc= MySessionContext.getInstance();
        HttpSession session = myc.getSession(sessionid);

        user.setUsername(name);
        session.setAttribute("user",user);
        System.out.println("set中的sessionId>>>>>>"+session.getId());
        Result<User> result = new Result<>();
        result.setCode(1000);
        result.setMsg("测试数据");
        return result;
    }

    @RequestMapping("/getname.do")
    @ResponseBody
    public Result<User> getname(){

        MySessionContext myc= MySessionContext.getInstance();
        HttpSession session = myc.getSession(sessionid);

        User user = (User) session.getAttribute("user");

        System.out.println("get中的sessionId>>>>>>"+session.getId());
        Result<User> result = new Result<>();
        result.setCode(1000);
        result.setMsg("测试数据");
        return result;
    }
    //从session中获取用户信息，因为在拦截器中以判断当前是否登录，所以直接取值就行
    private User islogin(HttpSession session){
        return (User) session.getAttribute("user");
    }

}
