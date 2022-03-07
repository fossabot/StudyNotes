package com.lnboxue.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听器(统计当前在线人数)
 */
public class OnlineListener implements HttpSessionListener {

    //session创建触发该方法
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //获取ServletContext对象
        ServletContext servletContext = se.getSession().getServletContext();
        System.out.println(se.getSession().getId());
        //获取在线人数
        Integer onlineCount = (Integer) servletContext.getAttribute("onlineCount");
        //判断在线人数是否存在
        if (null==onlineCount){
            onlineCount = 1;
        } else {
            onlineCount += 1;
        }
        //将在线人数放入到ServletContext对象中
        servletContext.setAttribute("onlineCount",onlineCount);
    }

    //session销毁或超时触发该方法
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //获取ServletContext对象
        ServletContext servletContext = se.getSession().getServletContext();
        //获取在线人数
        Integer onlineCount = (Integer) servletContext.getAttribute("onlineCount");
        //判断在线人数是否存在
        if (null==onlineCount){
            onlineCount = 0;
        } else {
            onlineCount -= 1;
        }
        //将在线人数放入到ServletContext对象中
        servletContext.setAttribute("onlineCount",onlineCount);
    }
}
