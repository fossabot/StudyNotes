package app14;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //全局异常信息
        String result = "系统发生异常，请联系管理员！";
        //自定义异常处理
        if (e instanceof MyException){
            //重置异常信息
            result = ((MyException)e).getMsg();
        }
        //实例化ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //保存数据
        modelAndView.addObject("message",result);
        //保存页面信息
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
