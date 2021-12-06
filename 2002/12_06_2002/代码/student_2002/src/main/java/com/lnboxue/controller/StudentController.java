package com.lnboxue.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lnboxue.pojo.Student;
import com.lnboxue.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //跳转到学生添加页面
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "addStudent";
    }

    //跳转到数据库错误页面
    @RequestMapping("/toError")
    public String toError(){
        return "databaseError";
    }

    @RequestMapping("/list")
    public String list(@RequestParam(value = "page",defaultValue = "1") int page, Model model){
        //定义第几页和每页显示的记录记录数
        PageHelper.startPage(page,5);
        //调用业务层中的分页方法
        List<Student> students = studentService.list();
        //通过Model对象带出分页封装的students数据pageInfo，并跳转到listStudents.jsp页面
        PageInfo pageInfo = new PageInfo(students);
        //保存分页数据
        model.addAttribute("pageInfo",pageInfo);
        return "listStudents";
    }

    @RequestMapping("/add")
    public String add(Student student){
        //调用业务层中的学生添加方法
        if (studentService.insert(student)){
            //成功：重定向到学生分页查询的action
            return "redirect:/student/list";
        }
        //失败：跳转到学生添加页面
        return "addStudent";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(int id,Model model){
        //调用业务层中的查询方法
        Student student = studentService.findById(id);
        //保存数据
        model.addAttribute("student",student);
        //跳转到学生修改页面
        return "updateStudent";
    }

    @RequestMapping("/update")
    public String update(Student student){
        //调用业务层中的学生修改方法
        if (studentService.update(student)){
            //成功：重定向到学生分页查询的action
            return "redirect:/student/list";
        }
        //失败：跳转到数据库错误页面
        return "redirect:/student/toError";
    }

    /*@RequestMapping("/delete")
    public String delete(int id){
        //调用业务层中的学生删除方法
        if (studentService.delete(id)){
            //成功：重定向到学生分页查询的action
            return "redirect:/student/list";
        }
        //失败：跳转到数据库错误页面
        return "redirect:/student/toError";
    }*/

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        //调用业务层中的学生删除方法
        if (studentService.delete(id)){
            //成功：重定向到学生分页查询的action
            return "redirect:/student/list";
        }
        //失败：跳转到数据库错误页面
        return "redirect:/student/toError";
    }
}
