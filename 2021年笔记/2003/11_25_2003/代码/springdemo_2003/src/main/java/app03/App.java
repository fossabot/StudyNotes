package app03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 */
public class App {

    //创建IOC容器对象
    ApplicationContext ac = new ClassPathXmlApplicationContext("app03/applicationContext.xml");

    @Test
    public void testSet() throws Exception{
        //获取容器中的对象
        //User user = (User) ac.getBean("user");
        User user = (User) ac.getBean("user2");
        System.out.println(user);
    }

    @Test
    public void testExecuteAction() throws Exception{
        //获取容器中的action对象
        //UserAction userAction = (UserAction) ac.getBean("userAction");
        UserAction userAction = (UserAction) ac.getBean("userAction2");
        //调用控制层中的方法
        userAction.execute();
    }
}
