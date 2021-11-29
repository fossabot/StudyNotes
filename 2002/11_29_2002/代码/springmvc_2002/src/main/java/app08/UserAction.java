package app08;

import com.sun.org.apache.xpath.internal.operations.Mod;
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
     * 定义自定义类型转换器
     * 解决字符串转换成日期类型
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
        //保存数据
        model.addAttribute("user",user);
        return "/jsp/success.jsp";
    }
}
