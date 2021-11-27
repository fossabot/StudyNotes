package app05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    ApplicationContext ac = new ClassPathXmlApplicationContext("app05/applicationContext.xml");

    @Test
    public void testExecuteAction() throws Exception{
        //从Spring IOC容器中获取action
        UserAction userAction = (UserAction) ac.getBean("userAction");
        userAction.execute();
    }
}
