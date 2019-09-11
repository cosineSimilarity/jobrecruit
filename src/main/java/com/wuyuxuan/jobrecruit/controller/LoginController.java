package com.wuyuxuan.jobrecruit.controller;

import com.alibaba.fastjson.JSON;
import com.wuyuxuan.jobrecruit.entities.User;
import com.wuyuxuan.jobrecruit.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/home/initpage")
    public String initPage(HttpSession session){
        Map<String,Object> responseMap = new HashMap<>();
        if(!StringUtils.isEmpty(session.getAttribute("user")) && !StringUtils.isEmpty(session.getAttribute("role"))){
            responseMap.put("isSuccess","success");
            responseMap.put("username",session.getAttribute("user"));
            responseMap.put("role",session.getAttribute("role"));
        }else {
            responseMap.put("isSuccess","false");
        }
        return JSON.toJSONString(responseMap);
    }

    @PostMapping(value = "/sign/in")
    public String signIn(@RequestParam("username")String userName,
                         @RequestParam("password")String password,
                         @RequestParam("remember")String remember,
                         HttpSession session){


        Map<String,Object> responseMap = new HashMap<>();
        List<User> login = loginService.login(userName,password);
        if (login.size()>0){
            if(!StringUtils.isEmpty(login.get(0).getUserName())){
                session.setAttribute("user",login.get(0).getUserName());
                responseMap.put("username",login.get(0).getUserName());
            }
            if(!StringUtils.isEmpty(login.get(0).getRole())){
                session.setAttribute("role",login.get(0).getRole());
                responseMap.put("role",login.get(0).getRole());
            }
            responseMap.put("isSuccess","success");

        }else {
            responseMap.put("isSuccess","登录失败，用户名或密码错误！");
        }
        return JSON.toJSONString(responseMap);
    }

    @RequestMapping("/sign/up")
    public String signUp(@RequestBody User user){

        Map<String,Object> responseMap = new HashMap<>();
        if(!StringUtils.isEmpty(user.getUserName())){
            boolean checkName = loginService.checkName(user);
            if(checkName){
                responseMap.put("isSuccess","用户名重复！");
            }else {
                boolean register = loginService.register(user);
                if (register){
                    responseMap.put("isSuccess","success");
                    responseMap.put("username",user.getUserName());
                }else {
                    responseMap.put("isSuccess","注册失败，请联系管理员！");
                }
            }
        }

        return JSON.toJSONString(responseMap);

    }

}
