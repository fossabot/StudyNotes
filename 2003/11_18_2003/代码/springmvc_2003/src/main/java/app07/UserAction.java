package app07;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
public class UserAction {

    @RequestMapping(method = RequestMethod.POST,value = "/register")
    public String register(@RequestParam String username, @RequestParam Double salary, HttpSession session) throws Exception{
        System.out.println("用户注册-->" + username + "：" + salary);
        //将数据保存到session对象中
        session.setAttribute("username",username);
        session.setAttribute("salary",salary);
        //重定向
        return "redirect:/jsp/success.jsp";
    }
}
