package app01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App02 {

    /**
     * 1.对象创建：分为单例/多例
     *  scope="singleton"，默认值，即默认为单例，service/dao/工具类
     *  scope="prototype"，多例，如：action对象
     * 2.什么时候创建？
     *  scope="prototype"：在用到对象的时候才创建
     *  scope="singleton"：在启动（容器初始化之前），就已经创建了bean，且整个应用中只有一个
     * 3.是否延迟创建
     *  lazy-init="false" 默认为false，不延迟创建，即在启动时就创建对象
     *  lazy-init="true" 延迟初始化，在用到对象时候才创建（仅仅对单例有效）
     * 4.创建对象后，初始化/销毁
     *  init-method="方法名"：对应initUser，在对象创建之后执行
     *  destroy-method="方法名"：调用容器对象的destroy方法时执行（该方法已废除）
     */
    @Test
    public void testAc() throws Exception{
        //获取IOC容器对象
        //ApplicationContext ac = new ClassPathXmlApplicationContext("app01/applicationContext.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("app01/applicationContext.xml");
        System.out.println("--------容器创建--------");
        //从容器中获取bean
        User user1 = (User) ac.getBean("user");
        User user2 = (User) ac.getBean("user");
        System.out.println(user1);
        System.out.println(user2);
        //销毁容器对象
        //ac.destroy();
    }
}
