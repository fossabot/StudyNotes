package com.lnboxue.service;

import com.lnboxue.pojo.Student;

/**
 * 业务层
 */
public interface StudentService {

    Student login(String name,String pwd);
}
