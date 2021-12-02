package com.lnboxue.dao;

import com.lnboxue.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据库访问层
 */
public interface StudentMapper {

    //学生登录
    Student login(@Param("name") String name,@Param("pwd") String pwd);
    //学生分页查询
    List<Student> list();
    //学生添加
    int insert(Student student);
    //按学号查询学生
    Student findById(int id);
    //学生修改
    int update(Student student);
}
