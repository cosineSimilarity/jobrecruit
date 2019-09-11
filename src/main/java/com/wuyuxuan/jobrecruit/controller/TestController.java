package com.wuyuxuan.jobrecruit.controller;

import com.wuyuxuan.jobrecruit.entities.Test;
import com.wuyuxuan.jobrecruit.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public String test(){
        List<Test> testList = testService.findAllTestInfo();
        if(testList.size()>0){
            return "test success!";
        }
        return "test false!";
    }
}
