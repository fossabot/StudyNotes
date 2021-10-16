package com.lnboxue.action;

import com.lnboxue.entity.UserTable;
import com.lnboxue.service.user.UserTableService;
import com.lnboxue.service.user.impl.UserTableServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录功能控制层实现
 */
public class LoginServlet extends HttpServlet {

    private UserTableService userTableService;

    @Override
    public void init() throws ServletException {
        userTableService = new UserTableServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名
        String name = request.getParameter("name");
        //获取密码
        String password = request.getParameter("password");
        //封装数据
        UserTable userTable = new UserTable();
        userTable.setName(name);
        userTable.setPassword(password);
        //判断登陆是否成功
        if(userTableService.userSelect(name,password)){
            //获取session对象
            HttpSession session = request.getSession();
            //将用户对象保存到session对象中
            session.setAttribute("userTable",userTable);
            response.sendRedirect(request.getContextPath() + "/ShowGoodsServlet");
        } else {
            //登陆失败，跳转(重定向)到错误页面
            response.sendRedirect(request.getContextPath() + "/jsp/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
