package com.lnboxue.pojo;

import java.io.Serializable;

/**
 * 课程类
 */
public class Course implements Serializable {

    //课程编号
    private Integer id;
    //课程名称
    private String name;
    //教师编号
    private Integer teacherId;

    //无参构造方法
    public Course(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
