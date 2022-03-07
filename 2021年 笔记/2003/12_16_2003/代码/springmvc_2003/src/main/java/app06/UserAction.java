package app06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/user")
public class UserAction {

    /**
     * 用户注册，只能接收POST请求
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST,value = "/register")
    public String register(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //获取用户名和薪水
        String username = request.getParameter("username");
        String salary = request.getParameter("salary");
        System.out.println("用户注册-->" + username + "：" + salary);
        //将用户名和薪水保存到session对象中
        request.getSession().setAttribute("username",username);
        request.getSession().setAttribute("salary",salary);
        //推荐使用（SpringMVC）=>转发到一个视图
        //return "/jsp/success.jsp";
        //Servlet API中的请求转发
        //request.getRequestDispatcher("/jsp/success.jsp").forward(request,response);
        //对于Servlet API中的请求转发，在Spring MVC中如何实现
        //return "forward:/jsp/success.jsp";
        //Servlet API中的重定向
        //response.sendRedirect(request.getContextPath() + "/jsp/success.jsp");
        //对于Servlet API中的重定向，在Spring MVC中如何实现
        return "redirect:/jsp/success.jsp";
    }
}
