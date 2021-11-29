package com.lnboxue.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器：处理该项目POST请求的乱码
 */
public class EncodingFilter implements Filter {

    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //System.out.println("EncodingFilter被初始化...");
        //获取过滤器中的初始化参数
        this.encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //将当前请求进行转型(多态=>向下转型)
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //解决POST请求乱码问题
        //request.setCharacterEncoding("utf-8");
        //response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        //放行(执行下一个过滤器或Servlet)
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        //System.out.println("EncodingFilter被销毁了...");
    }
}
