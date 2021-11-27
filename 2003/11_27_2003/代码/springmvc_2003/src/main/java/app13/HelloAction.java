package app13;

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
        modelAndView.addObject("message","进入全查询页面...");
        //设置视图信息
        modelAndView.setViewName("success");
        System.out.println("testInterceptor...");
        return modelAndView;
    }
}
