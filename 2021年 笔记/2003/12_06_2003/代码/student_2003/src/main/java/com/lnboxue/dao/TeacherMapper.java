package com.lnboxue.dao;

import com.lnboxue.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    //教师登录
    Teacher login(@Param("name") String name,@Param("pwd") String pwd);
    //教师分页查询
    List<Teacher> list();
}
