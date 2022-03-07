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
        //判断角色
        switch (Integer.parseInt(type)){
            //学生角色
            case 0:{
                //调用业务层中的登录方法
                Student student = studentService.login(username, password);
                //判断用户是否存在
                if (null!=student){
                    //获取Session对象
                    HttpSession session = request.getSession();
                    //将用户名保存到Session对象中
                    session.setAttribute("username",username);
                    //重定向到学生分页查询的action
                    return "redirect:/student/list";
                } else {
                    //跳转到登录页面
                    return "login";
                }
            }
            //教师角色
            case 1:{

            }
            //管理员角色
            case 2:{

            }
            default:{
                return "login";
            }
        }
    }
}
