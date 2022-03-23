package com.lnboxue.controller;

import com.lnboxue.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("/loginCheck")
    @ResponseBody
    public Map<String,String> loginCheck(HttpServletRequest request){

        return null;
    }
}
