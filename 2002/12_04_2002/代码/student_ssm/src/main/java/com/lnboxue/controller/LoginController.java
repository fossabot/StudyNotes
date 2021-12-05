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

@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/check")
    public String check(String username, String password, String type, HttpServletRequest request){
        switch (Integer.parseInt(type)) {
            case 0: {
                Student student = studentService.login(username, password);
                if (student != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    //return "listStudents";
                    return "redirect:/student/list";
                } else {
                    return "login";
                }
            }
            case 1: {
                Teacher teacher = teacherService.login(username, password);
                if (teacher != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    return "redirect:/teacher/list";
                } else {
                    return "login";
                }
            }
            case 2: {

            }
            default: {
                return "login";
            }
        }
    }
}
