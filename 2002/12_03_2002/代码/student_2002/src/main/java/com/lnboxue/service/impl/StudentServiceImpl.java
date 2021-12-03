package com.lnboxue.service.impl;

import com.lnboxue.dao.StudentMapper;
import com.lnboxue.pojo.Student;
import com.lnboxue.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务层实现类
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student login(String name, String pwd) {
        return studentMapper.login(name,pwd);
    }
}
