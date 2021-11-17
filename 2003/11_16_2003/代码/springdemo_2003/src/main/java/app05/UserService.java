package app05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@Component
//@Component("userService")
@Service
public class UserService {

    //@Resource //先按照名称查找再按照类型查找
    //@Resource(name="userDao") //按照名称查找
    @Autowired //按照类型
    @Qualifier("userDao")
    private UserDao userDao;

    public void save(){
        userDao.save();
    }
}
