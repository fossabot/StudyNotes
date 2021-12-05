package com.lnboxue.service.impl;

import com.lnboxue.dao.TeacherMapper;
import com.lnboxue.pojo.Teacher;
import com.lnboxue.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher login(String name, String pwd) {
        return teacherMapper.login(name,pwd);
    }

    @Override
    public List<Teacher> list() {
        return teacherMapper.list();
    }
}
