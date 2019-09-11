package com.wuyuxuan.jobrecruit.dao;

import com.wuyuxuan.jobrecruit.entities.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginDao {

    @Insert("insert into user(userguid,username,password,role,email) values(#{userGuid},#{userName},#{password},#{role},#{email})")
    boolean register(User user);

    @Select("select count(*) from user where username = #{userName}")
    boolean checkName(User user);

    @Select("select * from user where username = #{userName} and password = #{password}")
    List<User> login(String userName, String password);
}
