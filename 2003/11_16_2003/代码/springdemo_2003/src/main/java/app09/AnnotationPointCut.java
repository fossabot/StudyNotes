package app09;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//标注这个类是一个切面
@Aspect
public class AnnotationPointCut {

    @Before("execution(* app09.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("============方法执行前============");
    }

    @After("execution(* app09.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("=============方法执行后==============");
    }
}
