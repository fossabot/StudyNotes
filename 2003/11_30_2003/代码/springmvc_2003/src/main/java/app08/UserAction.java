package app08;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/user")
public class UserAction {

    /**
     * 自定义类型转换器
     * 解决字符串转日期类型，如果不配置，则会出现400错误
     * @param
     * @param
     * @return
     * @throws Exception
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) throws Exception{
        binder.registerCustomEditor(
                Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true)
        );
    }

    @RequestMapping(method = RequestMethod.POST,value = "/register")
    public String register(@ModelAttribute User user, Model model) throws Exception{
        System.out.println("用户注册：" + user.toString());
        //将user对象绑定到Model对象中
        model.addAttribute("user",user);
        //跳转到成功页面
        return "/jsp/success.jsp";
    }
}
