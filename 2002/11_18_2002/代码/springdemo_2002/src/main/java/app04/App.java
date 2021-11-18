package app04;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 */
public class App {

    //创建IOC容器对象
    ApplicationContext ac = new ClassPathXmlApplicationContext("app04/applicationContext.xml");

    @Test
    public void testExecuteAction() throws Exception{
        //获取Spring容器中的action对象
        UserAction userAction = (UserAction) ac.getBean("userAction");
        //调用控制层中的业务方法
        userAction.execute();
    }
}
