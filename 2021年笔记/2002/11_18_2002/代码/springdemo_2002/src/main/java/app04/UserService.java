package app04;

/**
 * 业务层
 */
public class UserService {

    //Spring IOC容器注入进来
    private UserDao userDao;

    //对象的创建交Spring的IOC容器完成
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(){
        userDao.save();
    }
}
