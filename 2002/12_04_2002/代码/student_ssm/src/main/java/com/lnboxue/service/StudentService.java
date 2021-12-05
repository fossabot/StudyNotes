package com.lnboxue.service;

import com.lnboxue.pojo.Student;

import java.util.List;

public interface StudentService {

    Student login(String name, String pwd);
    List<Student> list();
    boolean insert(Student student);
    Student findById(int id);
    boolean update(Student student);
    boolean delete(int id);
}
