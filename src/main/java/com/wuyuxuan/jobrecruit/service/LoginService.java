package com.wuyuxuan.jobrecruit.service;

import com.wuyuxuan.jobrecruit.dao.LoginDao;
import com.wuyuxuan.jobrecruit.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class LoginService {

    @Autowired
    private LoginDao loginDao;

    public boolean register(User user) {

        if(StringUtils.isEmpty(user.getUserGuid())){
            user.setUserGuid(UUID.randomUUID().toString());
        }
        return loginDao.register(user);
    }

    public boolean checkName(User user) {

        return loginDao.checkName(user);
    }

    public List<User> login(String userName, String password) {
        return  loginDao.login(userName,password);
    }
}
