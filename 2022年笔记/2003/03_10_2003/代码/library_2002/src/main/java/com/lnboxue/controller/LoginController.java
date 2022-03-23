package com.lnboxue.controller;

import com.lnboxue.pojo.Admin;
import com.lnboxue.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 控制层
 */
@Controller
public class LoginController {

    //注入Service
    @Autowired
    private LoginService loginService;

    //跳转到登录页 login.html
    @RequestMapping(value = {"/","/login.html"})
    public String toLogin(HttpServletRequest request){
        //使Session失效
        request.getSession().invalidate();
        return "index";
    }

    //跳转到管理员主页面
    @RequestMapping("/admin_main.html")
    public ModelAndView toAdminMain(){
        return new ModelAndView("admin_main");
    }

    //跳转到管理员公共头部页面
    @RequestMapping("/admin_header.html")
    public ModelAndView toAdminHeader(){
        return new ModelAndView("admin_header");
    }

    @RequestMapping("/loginCheck")
    @ResponseBody
    public Map<String,String> loginCheck(HttpServletRequest request){
        //获取账号并进行类型转换
        long id = Long.parseLong(request.getParameter("id"));
        //获取密码
        String password = request.getParameter("password");
        //调用Service中的登录验证方法
        boolean isAdmin = loginService.hasMatchAdmin(id, password);
        //实例化Map对象
        HashMap<String,String> result = new HashMap<>();
        //判断用户是否存在，判断是否是管理员
        if (isAdmin){
            //实例化管理员对象
            Admin admin = new Admin();
            //封装数据
            admin.setAdminId(id);
            admin.setPassword(password);
            //调用Service中的用户名查询方法
            String username = loginService.getAdminUsername(id);
            //封装用户名
            admin.setUsername(username);
            //将admin对象放入Session中
            request.getSession().setAttribute("admin",admin);
            //设置响应数据
            result.put("stateCode","1");
            //设置登录成功信息
            result.put("msg","管理员登录成功！");
        } else {
            //用户名密码错误
            result.put("stateCode","0");
            result.put("msg","账号或密码错误");
        }
        return result;
    }

    //注销功能
    @RequestMapping("/logout.html")
    public String logout(HttpServletRequest request){
        //清除当前用户的Session
        request.getSession().invalidate();
        return "redirect:/login.html";
    }
}
