package app02;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloAction implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //实例化ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //封装数据
        modelAndView.addObject("message","这是我们第二个Spring MVC应用程序...");
        //原来是如何实现的呢？
        //modelAndView.setViewName("/jsp/success.jsp");
        //现在封装视图的逻辑名称
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
