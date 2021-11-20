package app07;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 前置通知类
 */
public class Log implements MethodBeforeAdvice {

    /**
     *
     * @param method：要执行的目标对象的方法
     * @param objects：要执行的目标对象方法的参数
     * @param target：目标对象
     * @throws Throwable：该类是Exception的父类
     */
    @Override
    public void before(Method method, Object[] objects, Object target) throws Throwable {
        System.out.println(target.getClass().getName() + "的" + method.getName() + "被执行了...");
    }
}
