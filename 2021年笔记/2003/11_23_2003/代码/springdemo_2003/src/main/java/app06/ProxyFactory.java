package app06;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory implements InvocationHandler {

    //代理接口
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //生成获取代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),userDao.getClass().getInterfaces(),this);
    }

    /*
       处理代理对象实例并返回结果
       什么是代理？
       指为目标对象提供了一个代理对象，并由代理对象控制对目标对象的引用，是为了不修改目标对象的基础上，增强目标对象的业务逻辑
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开启事务...");
        //动态代理的本质就是使用反射机制事项
        /**
         * method：指的是该接口中的方法=>save()方法
         * args：指的是接口中方法的参数列表
         * result：接口中方法的返回值
         */
        Object result = method.invoke(userDao, args);
        System.out.println("提交事务...");
        return result;
    }
}
