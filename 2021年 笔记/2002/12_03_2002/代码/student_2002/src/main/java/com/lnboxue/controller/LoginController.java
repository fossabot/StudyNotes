package com.lnboxue.controller;

import com.lnboxue.pojo.Student;
import com.lnboxue.service.StudentService;
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
                    return "listStudents";
                } else {
                    return "login";
                }
            }
            //教师登录
            case 1:{

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
