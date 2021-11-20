package app03;

/**
 * 控制层
 */
public class UserAction {

    //Spring IOC注入进来
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String execute(){
        userService.save();
        return null;
    }
}
