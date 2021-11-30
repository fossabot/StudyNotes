package com.lnboxue.pojo;

import java.io.Serializable;

/**
 * 教师类
 */
public class Teacher implements Serializable {

    //教师编号
    private Integer id;
    //教师姓名
    private String name;
    //教师密码
    private String password;
    //教师的性别（男：1，0：女）
    private Integer sex;
    //出生日期
    private String birthday;
    //课程编号
    private Integer courseId;
    //职称
    private String professional;
    //教师薪水
    private Integer salary;

    //一个教师只教授一门课程
    private Course course;

    //无参构造方法
    public Teacher(){}

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
