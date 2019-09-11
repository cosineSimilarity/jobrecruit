package com.wuyuxuan.jobrecruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GotoController {

    @RequestMapping("/index")
    public static String index(){
        return "/home-1.html";
    }

    @RequestMapping("/employerdashboard")
    public String employerDashboard(){
        return "/employer-dashboard.html";
    }
    @RequestMapping("/dashboard")
    public String dashboard(){
        return "/dashboard.html";
    }
}
