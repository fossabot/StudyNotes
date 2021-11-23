package app06;

import org.junit.Test;

/**
 * 测试类
 */
public class App {

    @Test
    public void testProxy() throws Exception{
        //真实角色
        UserDao userDao = new UserDaoImpl();
        //实例化代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        //通过调用程序处理角色，来处理我们的接口对象
        proxyFactory.setUserDao(userDao);
        UserDao proxy = (UserDao) proxyFactory.getProxy();
        proxy.save();
    }
}
