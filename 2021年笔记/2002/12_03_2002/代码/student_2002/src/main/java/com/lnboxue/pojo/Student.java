package com.lnboxue.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 学生类
 */
public class Student implements Serializable {

    //学号
    private Integer id;
    //学生姓名
    private String name;
    //学生密码
    private  String password;
    //学生性别
    private Integer sex;
    //学生班级
    private String clazz;
    //出生日期
    private String birthday;

    //一个学生对应多个成绩
    private List<Score> scores;

    //无参构造方法
    public Student(){}

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

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }
}
