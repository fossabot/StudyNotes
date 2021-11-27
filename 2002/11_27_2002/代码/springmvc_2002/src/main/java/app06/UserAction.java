package app06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/user")
public class UserAction {

    //用户注册，只能接收POST请求
    @RequestMapping(method = RequestMethod.POST,value = "/register")
    public String register(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //获取用户名
        String username = request.getParameter("username");
        //获取薪水
        String salary = request.getParameter("salary");
        System.out.println("用户注册->" + username + "：" + salary);
        //将数据存放到Session中
        request.getSession().setAttribute("username",username);
        request.getSession().setAttribute("salary",salary);
        //Servlet中请求转发
        //SpringMVC中的跳转，推荐使用
        //return "/jsp/success.jsp";
        //request.getRequestDispatcher("/jsp/success.jsp").forward(request,response);
        //Spring MVC中的请求转发写法
        //return "forward:/jsp/success.jsp";
        //Servlet中的重定向
        //response.sendRedirect(request.getContextPath() + "/jsp/success.jsp");
        //Spring MVC中的重定向写法
        return "redirect:/jsp/success.jsp";
    }
}
