package com.lnboxue.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听器（监听在线人数）
 */
public class OnlineListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //获取ServletContext对象
        ServletContext servletContext = se.getSession().getServletContext();
        System.out.println(se.getSession().getId());
        //获取项目中的在线人数
        Integer onlineCount = (Integer) servletContext.getAttribute("onlineCount");
        //判断在线人数
        if (null==onlineCount){
            onlineCount = 1;
        } else {
            onlineCount += 1;
        }
        //将当前的在线人数放入ServletContext对象
        servletContext.setAttribute("onlineCount",onlineCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("onlineCount");
        //判断在线人数
        if (null==onlineCount){
            onlineCount = 0;
        } else {
            onlineCount -= 1;
        }
        //将当前的在线人数放入ServletContext对象
        servletContext.setAttribute("onlineCount",onlineCount);
    }
}

