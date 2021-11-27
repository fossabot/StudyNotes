package app03;

/**
 * 业务层
 */
public class UserService {

    //Sprin IOC容器注入进来
    private UserDao userDao;

    //IOC：对象的创建交给Spring的IOC容器完成
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    void save(){
        userDao.save();
    }
}
