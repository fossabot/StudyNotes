package app13;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserAction {

    //跳转页面
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "logon";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session) throws Exception{
        //登录验证
        if (username.equals("admin")){
            //将用户名保存到Session对象中
            session.setAttribute("username",username);
            //重定向到全查询页面
            return "redirect:/hello.action";
        }
        //登录失败，跳转到登录页
        return "logon";
    }
}
