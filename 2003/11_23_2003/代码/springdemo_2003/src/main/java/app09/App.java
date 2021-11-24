package app09;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 */
public class App {

    //创建IOC容器对象
    ApplicationContext ac = new ClassPathXmlApplicationContext("app09/applicationContext.xml");

    @Test
    public void testAOP() throws Exception{
        UserService userService = (UserService) ac.getBean("userService");
        userService.add();
    }
}
