package com.lnboxue.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 注册验证
 */
public class UserAjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决POST请求乱码
        request.setCharacterEncoding("utf-8");
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //定义图片路径
        String message = "../images/MsgSent.gif";
        //判断是否合法
        if ("陈阳".equals(username)&&"123".equals(password)){
            //重置图片路径（非法图片）
            message = "../images/MsgError.gif";
        }
        //设置服务器端给客户端返回的信息类型
        response.setContentType("text/html;charset=utf-8");
        //通过PrintWriter将信息返回给客户端
        PrintWriter pw = response.getWriter();
        pw.write(message);
        //刷新
        pw.flush();
        //关闭资源
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
