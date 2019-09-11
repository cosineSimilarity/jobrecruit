package com.wuyuxuan.jobrecruit.service;

import com.wuyuxuan.jobrecruit.dao.TestDao;
import com.wuyuxuan.jobrecruit.entities.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    public List<Test> findAllTestInfo() {
        return testDao.findAllTestInfo();
    }
}
