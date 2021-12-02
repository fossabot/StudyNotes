package com.lnboxue.service.impl;

import com.lnboxue.dao.StudentMapper;
import com.lnboxue.pojo.Student;
import com.lnboxue.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Student> list() {
        return studentMapper.list();
    }

    @Override
    public boolean insert(Student student) {
        //设置成功标识
        boolean isDone = false;
        //调用数据库访问层中的添加方法
        if (studentMapper.insert(student)>0){
            //重置标识
            isDone = true;
        }
        return isDone;
    }

    @Override
    public Student findById(int id) {
        return studentMapper.findById(id);
    }

    @Override
    public boolean update(Student student) {
        boolean isDone = false;
        if (studentMapper.update(student)>0){
            isDone = true;
        }
        return isDone;
    }
}
