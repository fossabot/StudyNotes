package app05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@Component("userService")
//@Component
@Service
public class UserService {

    //按照名称查找进行装配
    //@Resource(name="userDao")
    //先按名称查找再按照类型查找进行装配
    //@Resource
    //按照类型查找进行装配
    //@Autowired
    //按照名称查找进行装配
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    public void save(){
        userDao.save();
    }
}
