package app08;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 */
public class App {

    //创建IOC容器对象
    ApplicationContext ac = new ClassPathXmlApplicationContext("app08/applicationContext.xml");

    @Test
    public void testAOP() throws Exception{
        //动态代理的是接口
        UserService userService = (UserService) ac.getBean("userService");
        userService.add();
    }
}
