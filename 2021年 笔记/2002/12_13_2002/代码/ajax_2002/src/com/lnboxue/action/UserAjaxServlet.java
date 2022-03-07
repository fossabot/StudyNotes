package com.lnboxue.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 检查用户名是否重复
 */
public class UserAjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决POST请求乱码
        request.setCharacterEncoding("utf-8");
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //设置图片路径（通过验证的图片路径）
        String message = "../images/MsgSent.gif";
        //判断用户名密码是否合法
        if ("玉迪".equals(username)&&"123".equals(password)){
            //重置图片路径（验证不通过的图片路径）
            message = "../images/MsgError.gif";
        }
        //设置服务器端给客户端的响应格式
        response.setContentType("text/html;charset=utf-8");
        //实例化PrintWriter对象
        PrintWriter pw = response.getWriter();
        //写入数据
        pw.write(message);
        //刷新
        pw.flush();
        //关闭资源
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
