package app14;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserAction {

    @RequestMapping("/test")
    public void userException(HttpServletRequest request, HttpServletResponse response) throws MyException{
        //int i = 1 / 0;
        //假设这里根据id查询用户信息，搜索不到用户
        if (true){
            throw new MyException("您查找的用户不存在，请确认信息...");
        }
    }
}
