package app01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 */
public class App01 {

    //直接获取IOC容器对象
    @Test
    public void testAc() throws Exception{
        //获取IOC容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("app01/applicationContext.xml");
        //从容器中获取User对象
        User user = (User) ac.getBean("user");
        System.out.println(user);
    }
}
