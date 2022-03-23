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

    //login.html
    @RequestMapping(value = {"/","/login.html"})
    public String toLogin(HttpServletRequest request){
        //设置session失效
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
        //获取客户端发送过来的账号，并进行类型转换
        long id = Long.parseLong(request.getParameter("id"));
        //获取客户端发送过来的密码
        String password = request.getParameter("password");
        //调用Service中的登录验证方法
        boolean isAdmin = loginService.hasMatchAdmin(id, password);
        //实例化Map集合
        Map<String,String> result = new HashMap<>();
        //判断用户角色
        if (isAdmin){
            //实例化管理员对象
            Admin admin = new Admin();
            //封装数据
            admin.setAdminId(id);
            admin.setPassword(password);
            //调用Service中查询用户名方法
            String username = loginService.getAdminUsername(id);
            //封装用户名
            admin.setUsername(username);
            //将管理员对象保存到Session中
            request.getSession().setAttribute("admin",admin);
            //封装发送到客户端的响应数据
            result.put("stateCode","1");
            result.put("msg","管理员登陆成功！");
        } else {
            //封装发送给客户端的响应数据
            result.put("stateCode","0");
            result.put("msg","账号或密码错误！");
        }
        return result;
    }

    //用户注销
    @RequestMapping("/logout.html")
    public String logout(HttpServletRequest request){
        //设置Session失效
        request.getSession().invalidate();
        return "redirect:/login.html";
    }
}
