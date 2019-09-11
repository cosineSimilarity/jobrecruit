package com.wuyuxuan.jobrecruit.dao;

import com.wuyuxuan.jobrecruit.entities.Test;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDao {
    @Select("select * from test")
    List<Test> findAllTestInfo();
}
