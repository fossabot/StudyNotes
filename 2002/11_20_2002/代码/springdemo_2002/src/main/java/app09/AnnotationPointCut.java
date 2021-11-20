package app09;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 切面类
 */
//标注这个类为切面类
@Aspect
public class AnnotationPointCut {

    //@Before(切入点表达式)
    @Before("execution(* app09.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("================方法执行前=================");
    }

    @After("execution(* app09.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("=============方法执行后====================");
    }
}
