package app09;

        import org.junit.Test;
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 */
public class App {

    //创建Spring IOC容器对象
    ApplicationContext ac = new ClassPathXmlApplicationContext("app09/applicationContext.xml");

    @Test
    public void testAOP() throws Exception{
        //获取UserService对象
        UserService userService = (UserService) ac.getBean("userService");
        //调用业务方法
        userService.delete();
    }
}
