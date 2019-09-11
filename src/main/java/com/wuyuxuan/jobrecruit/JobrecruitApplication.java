package com.wuyuxuan.jobrecruit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@MapperScan("com.wuyuxuan.jobrecruit.dao")
@EntityScan("com.wuyuxuan.jobrecruit.entities")
public class JobrecruitApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobrecruitApplication.class, args);
    }

}
