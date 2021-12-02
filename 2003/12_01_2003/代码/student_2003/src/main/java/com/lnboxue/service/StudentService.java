package com.lnboxue.service;

import com.lnboxue.pojo.Student;

import java.util.List;

/**
 * 业务层
 */
public interface StudentService {

    Student login(String name,String pwd);
    List<Student> list();
    boolean insert(Student student);
    Student findById(int id);
    boolean update(Student student);
}
