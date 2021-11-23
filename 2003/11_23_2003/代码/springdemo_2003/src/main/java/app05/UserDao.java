package app05;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//<bean id="userDao" class="app05.UserDao"/>
//@Component
//@Component("userDao")
@Repository
public class UserDao {

    public void save(){
        System.out.println("DB：保存用户...");
    }
}
