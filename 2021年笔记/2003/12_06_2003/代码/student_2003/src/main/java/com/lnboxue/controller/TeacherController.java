package com.lnboxue.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lnboxue.pojo.Teacher;
import com.lnboxue.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/list")
    public String list(@RequestParam(value = "page",defaultValue = "1") int page, Model model){
        //定义第几页和每页显示的记录数
        PageHelper.startPage(page,5);
        //调用业务层中的分页方法
        List<Teacher> teachers = teacherService.list();
        //通过model对象带出分页封装的teachers数据pageInfo，并跳转到listTeachers.jsp页面
        PageInfo pageInfo = new PageInfo(teachers);
        //保存数据
        model.addAttribute("pageInfo",pageInfo);
        return "listTeachers";
    }
}
