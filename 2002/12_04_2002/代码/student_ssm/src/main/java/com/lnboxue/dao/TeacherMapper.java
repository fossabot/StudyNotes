package com.lnboxue.dao;

import com.lnboxue.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    Teacher login(@Param("name") String name, @Param("pwd") String pwd);
    List<Teacher> list();
}
