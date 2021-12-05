package com.lnboxue.service.impl;

import com.lnboxue.dao.StudentMapper;
import com.lnboxue.pojo.Student;
import com.lnboxue.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public Student login(String name, String pwd) {
        return studentMapper.login(name,pwd);
    }

    public List<Student> list() {
        return studentMapper.list();
    }

    public boolean insert(Student student) {
        boolean isDone = false;
        if (studentMapper.insert(student)>0){
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

    @Override
    public boolean delete(int id) {
        boolean isDone = false;
        if (studentMapper.delete(id)>0){
            isDone = true;
        }
        return isDone;
    }
}
