package app02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 */
public class App {

    @Test
    public void testIOC() throws Exception{
        //创建IOC容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("app02/applicationContext.xml");
        //获取容器中的对象
        //User user = (User) ac.getBean("user1");
        //User user = (User) ac.getBean("user2");
        //User user = (User) ac.getBean("user3");
        //User user = (User) ac.getBean("user4");
        //User user = (User) ac.getBean("user5");
        User user = (User) ac.getBean("user6");
        System.out.println(user);
    }
}
