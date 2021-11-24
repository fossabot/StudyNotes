package app04;


public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    void save(){
        userDao.save();
    }
}
