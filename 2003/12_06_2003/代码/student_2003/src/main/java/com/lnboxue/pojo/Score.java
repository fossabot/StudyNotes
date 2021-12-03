package com.lnboxue.pojo;

import java.io.Serializable;

/**
 * 成绩类
 */
public class Score implements Serializable {

    //成绩编号
    private Integer id;
    //学生学号
    private Integer studentId;
    //课程编号
    private Integer courseId;
    //成绩
    private Double score;

    //一个课程对应一个分数
    private Course course;

    //无参构造方法
    public Score(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
