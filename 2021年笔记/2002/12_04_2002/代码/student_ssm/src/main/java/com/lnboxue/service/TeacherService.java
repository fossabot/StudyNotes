package com.lnboxue.service;

import com.lnboxue.pojo.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher login(String name, String pwd);
    List<Teacher> list();
}
