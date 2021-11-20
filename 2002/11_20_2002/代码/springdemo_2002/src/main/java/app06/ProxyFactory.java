package app06;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂
 * 1.InvocationHandler接口
 * 2.Proxy（代理类）
 */
public class ProxyFactory implements InvocationHandler {

    //定义代理接口
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //生成获取代理类
    /**
     * Foo f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
     *                                           new Class[] { Foo.class },
     *                                           handler);
     * @return
     */
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),userDao.getClass().getInterfaces(),this);
    }

    /**
     *处理代理对象实例并返回结果
     * 什么是代理？
     * 指为目标对象提供了一个代理对象，并由代理对象控制对目标对象的引用，
     * 是为了不修改目标对象的基础上，增强目标对象的业务逻辑
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开启事务...");
        /**
         * 动态代理的本质就是使用反射机制
         * method：指的是该接口中的方法=>save()
         * args：接口方法中的参数列表
         * result：接口中方法的返回值
         */
        Object result = method.invoke(userDao, args);
        System.out.println("提交事务...");
        return result;
    }
}
