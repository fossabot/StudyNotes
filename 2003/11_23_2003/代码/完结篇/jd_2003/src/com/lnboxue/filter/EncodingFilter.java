package com.lnboxue.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器（处理post请求乱码）
 */
public class EncodingFilter implements Filter {

    //需要设置的编码
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //System.out.println("EncodingFilter被初始化...");
        this.encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //过滤 doFilter()
        //类型转换
         HttpServletRequest request = (HttpServletRequest) servletRequest;
         HttpServletResponse response = (HttpServletResponse) servletResponse;
         //设置post请求的字符集编码
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        //放行（执行下一个过滤器或Servlet）
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        //System.out.println("EncodingFilter被销毁了...");
    }
}
