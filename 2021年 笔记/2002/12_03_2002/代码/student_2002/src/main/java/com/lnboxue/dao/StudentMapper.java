package com.lnboxue.dao;

import com.lnboxue.pojo.Student;
import org.apache.ibatis.annotations.Param;

/**
 * 数据库访问层
 */
public interface StudentMapper {

    //学生登录
    Student login(@Param("name") String name,@Param("pwd") String pwd);
}
