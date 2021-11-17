package app05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

//@Component
//@Component("userAction")
@Controller
public class UserAction {

    //@Resource
    //@Resource(name="userService")
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    public String execute(){
        userService.save();
        return null;
    }
}
