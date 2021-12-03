package com.lnboxue.dao;

import com.lnboxue.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {

    //教师登录
    Teacher login(@Param("name") String name,@Param("pwd") String pwd);
}
