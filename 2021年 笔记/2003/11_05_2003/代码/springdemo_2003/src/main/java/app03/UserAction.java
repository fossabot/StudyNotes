package app03;

/**
 * 控制层
 */
public class UserAction {

    //Service对象会被Spring IOC容器注入进来
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String execute(){
        userService.save();
        return null;
    }
}
