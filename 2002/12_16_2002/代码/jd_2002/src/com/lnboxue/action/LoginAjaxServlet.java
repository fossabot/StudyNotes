package com.lnboxue.action;

import com.lnboxue.entity.UserTable;
import com.lnboxue.service.user.UserTableService;
import com.lnboxue.service.user.impl.UserTableServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户登陆控制层（AJAX版本）
 */
public class LoginAjaxServlet extends HttpServlet {

    private UserTableService userTableService;

    @Override
    public void init() throws ServletException {
        userTableService = new UserTableServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名
        String name = request.getParameter("name");
        //获取密码
        String password = request.getParameter("password");
        //封装数据
        UserTable userTable = new UserTable();
        userTable.setName(name);
        userTable.setPassword(password);
        //用户登陆是否成功
        if (userTableService.userSelect(name,password)){
            //将用户信息保存到session中
            request.getSession().setAttribute("userTable",userTable);
            //设置响应的编码
            response.setContentType("text/html;charset=utf-8");
            //向客户端发送响应数据
            response.getWriter().write("success");
        } else {
            //失败
            response.getWriter().write("error");
        }
        //刷新
        response.getWriter().flush();
        //关闭资源
        response.getWriter().close();
    }
}
