package app03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloAction {

    /**
     * 业务方法
     * 只要是/hello.action的请求，都交由HelloAction对象中的hello()方法去处理
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/hello.action")
    public String hello(Model model) throws Exception{
        System.out.println("HelloAction:hello()");
        //保存数据
        model.addAttribute("message","加油，大数据2002....");
        return "success";
    }

    /**
     * 业务方法
     * 只要是/hello.action的请求，都交由HelloAction对象中的bye()方法去处理
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/bye.action")
    public String bye(Model model) throws Exception{
        System.out.println("HelloAction:bye()");
        //保存数据
        model.addAttribute("message","努力奋斗，大数据2002...");
        return "success";
    }
}
