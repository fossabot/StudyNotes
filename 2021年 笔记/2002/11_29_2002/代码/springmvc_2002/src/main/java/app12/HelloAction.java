package app12;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloAction {

    @RequestMapping("/hello")
    public ModelAndView testInterceptor(Model model) throws Exception{
        //实例化ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //保存数据
        modelAndView.addObject("msg","msg");
        //保存页面信息
        modelAndView.setViewName("msg");
        System.out.println("testInterceptor...");
        return modelAndView;
    }
}
