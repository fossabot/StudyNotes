package app10;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserAction {

    //跳转到修改页面（数据回显）
    @RequestMapping("/select")
    public String userByIdSelect(Model model) throws Exception{
        //实例化用户类
        User user = new User();
        //保存数据
        model.addAttribute("user",user);
        return "userEdit";
    }

    //修改方法
    @RequestMapping("/userEdit/{id}")
    public String userEdit(Model model,@PathVariable Integer id) throws Exception{
        System.out.println("修改的id为->" + id);
        //保存数据
        model.addAttribute("message","修改成功...");
        return "success";
    }
}
