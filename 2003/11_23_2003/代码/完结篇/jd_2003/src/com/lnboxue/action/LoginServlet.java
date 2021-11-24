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
 * 用户模块控制层(登陆验证)
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
        //保存用户数据
        UserTable userTable = new UserTable();
        userTable.setName(name);
        userTable.setPassword(password);
        //进行登陆验证
        if (userTableService.userSelect(name,password)){
            //登陆成功，将用户信息放入session对象中
            HttpSession session = request.getSession();
            //保存数据
            session.setAttribute("userTable",userTable);
            //重定向
            response.sendRedirect(request.getContextPath() + "/ShowGoodsServlet");
        } else {
            //登陆失败
            response.sendRedirect(request.getContextPath() + "/jsp/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
