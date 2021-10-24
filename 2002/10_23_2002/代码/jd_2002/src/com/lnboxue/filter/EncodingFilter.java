package com.lnboxue.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器：处理该项目POST请求的乱码
 */
public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
