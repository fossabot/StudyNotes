package app12;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor2 implements HandlerInterceptor {

    //进入方法前执行，用于登录拦截和权限验证
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor2.preHandle...");
        //该方法如果返回true为放行，反之返回false拦截
        return true;
    }

    //方法执行之后，返回ModelAndView之前执行，用于设置页面的公共参数等
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor2.postHandle...");
    }

    //方法执行之后执行，用于处理异常、清理资源、记录日志等
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor2.afterCompletion...");
    }
}
