package com.lnboxue.action;

import com.lnboxue.entity.UserTable;
import com.lnboxue.service.user.UserTableService;
import com.lnboxue.service.user.impl.UserTableServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆控制层（AJAX版本）
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
        //封装对象
        UserTable userTable = new UserTable();
        userTable.setName(name);
        userTable.setPassword(password);
        //判断是否登陆成功
        if (userTableService.userSelect(name,password)){
            //将用户信息保存到session对象中
            request.getSession().setAttribute("userTable",userTable);
            //设置向客户端返回的数据类型
            response.setContentType("text/html;charset=utf-8");
            //输出字符串
            response.getWriter().write("success");
        } else {
            response.getWriter().write("error");
        }
        //刷新
        response.getWriter().flush();
        //关闭资源
        response.getWriter().close();
    }
}
