package com.lnboxue.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lnboxue.pojo.Student;
import com.lnboxue.service.StudentService;
import com.sun.org.apache.xpath.internal.operations.Mod;
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

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "addStudent";
    }

    @RequestMapping("/toError")
    public String toError(){
        return "databaseError";
    }

    @RequestMapping("/list")
    public String list(@RequestParam(value = "page",defaultValue = "1") int page, Model model){
        //定义第几页和每页显示的记录数
        PageHelper.startPage(page,5);
        //调用业务层中的方法
        List<Student> students = studentService.list();
        //通过model对象带出分页封装的students数据pageInfo，并跳到listStudent.jsp页面
        PageInfo pageInfo = new PageInfo(students);
        model.addAttribute("pageInfo",pageInfo);
        return "listStudents";
    }

    @RequestMapping("/add")
    public String add(Student student){
        if (studentService.insert(student)){
            return "redirect:/student/list";
        }
        return "redirect:/student/toAdd";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(int id,Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student",student);
        return "updateStudent";
    }

    @RequestMapping("/update")
    public String update(Student student){
        if (studentService.update(student)){
            return "redirect:/student/list";
        }
        return "redirect:/student/toError";
    }

    /*@RequestMapping("/delete")
    public String delete(int id){
        if (studentService.delete(id)){
            return "redirect:/student/list";
        }
        return "redirect:/student/toError";
    }*/

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        if (studentService.delete(id)){
            return "redirect:/student/list";
        }
        return "redirect:/student/toError";
    }
}
