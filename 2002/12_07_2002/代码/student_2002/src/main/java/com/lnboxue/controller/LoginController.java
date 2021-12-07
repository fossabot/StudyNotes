package com.lnboxue.controller;

import com.lnboxue.pojo.Student;
import com.lnboxue.pojo.Teacher;
import com.lnboxue.service.StudentService;
import com.lnboxue.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 控制层
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/check")
    public String check(String username, String password, String type, HttpServletRequest request){
        switch (Integer.parseInt(type)){
            //学生登录
            case 0:{
                //调用业务层中的学生登录方法
                Student student = studentService.login(username, password);
                //判断是否登录成功
                if (null!=student){
                    //获取Session对象
                    HttpSession session = request.getSession();
                    //将用户名保存到Session对象中
                    session.setAttribute("username",username);
                    //return "listStudents";
                    //重定向到学生分页查询的action
                    return "redirect:/student/list";
                } else {
                    //失败：跳转到登录页
                    return "login";
                }
            }
            //教师登录
            case 1:{
                //调用业务层中的教师登录方法
                Teacher teacher = teacherService.login(username, password);
                //判断是否登录成功
                if (null!=teacher){
                    //获取Session对象
                    HttpSession session = request.getSession();
                    //将用户名保存到Session对象中
                    session.setAttribute("username",username);
                    //return "listTeachers";
                    //重定向到教师分页查询的action
                    return "redirect:/teacher/list";
                } else {
                    //失败：跳转到登录页
                    return "login";
                }
            }
            //管理员登录
            case 2:{

            }
            default:{
                return "login";
            }
        }
    }
}
