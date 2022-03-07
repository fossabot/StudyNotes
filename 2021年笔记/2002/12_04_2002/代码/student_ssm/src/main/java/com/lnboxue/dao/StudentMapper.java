package com.lnboxue.dao;

import com.lnboxue.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    Student login(@Param("name") String name, @Param("pwd") String pwd);
    List<Student> list();
    int insert(Student student);
    Student findById(int id);
    int update(Student student);
    int delete(int id);
}
