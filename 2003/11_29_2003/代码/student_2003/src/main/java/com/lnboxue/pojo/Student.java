package com.lnboxue.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 学生类
 */
public class Student implements Serializable {

    //学号
    private Integer id;
    //用户名
    private String name;
    //密码
    private String password;
    //性别
    private Integer sex;
    //班级
    private String clazz;
    //出生日期
    private String birthday;

    //一个学生对应多个成绩

}
