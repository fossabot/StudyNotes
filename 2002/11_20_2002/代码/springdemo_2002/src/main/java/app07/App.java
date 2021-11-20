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
        //获取UserService实例
        //方式一
        //UserService userService = (UserService) ac.getBean("userService");
        //方式二
        UserService userService = ac.getBean("userService", UserService.class);
        //调用业务方法
        userService.add();
    }
}
