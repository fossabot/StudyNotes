package app01;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloAction implements Controller {

    public HelloAction(){
        System.out.println("HelloAction-->" + this.hashCode());
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("HelloAction:handleRequest()");
        //ModelAndView表示视图封装数据和真实路径
        ModelAndView modelAndView = new ModelAndView();
        //封装数据
        modelAndView.addObject("message","这是我们第一个Spring MVC应用程序，映射器_适配器_视图解析器都可以省略...");
        //封装视图（完整的视图路径）
        modelAndView.setViewName("/jsp/success.jsp");
        return modelAndView;
    }
}
