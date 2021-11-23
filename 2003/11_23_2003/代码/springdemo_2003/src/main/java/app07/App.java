package app07;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 */
public class App {

    ApplicationContext ac = new ClassPathXmlApplicationContext("app07/applicationContext.xml");

    @Test
    public void testApp() throws Exception{
        //注：动态代理的是接口
        //UserService userService = (UserService) ac.getBean("userService");
        UserService userService = ac.getBean("userService",UserService.class);
        userService.add();
    }
}
