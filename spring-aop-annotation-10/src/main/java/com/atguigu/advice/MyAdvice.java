package com.atguigu.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;

import java.lang.reflect.Modifier;

/**
 * 1、定义方法-增强代码
 * 2、使用注解指定对应的位置
 * 3、配置切点表达式或选中方法
 * 4、切面和ioc的配置
 * 5、开启aspectj注解的支持
 *
 * TODO:增强方法中获取目标方法信息
 *     1、全部增强方法中，获取目标方法的信息（方法名、参数、访问修饰符、所属类信息。。。）
 *     2、返回的结果 @AfterReturning
 *     3、异常的信息 @AfterThrowing
 */
public class MyAdvice {

    @Before("execution(* com..impl.*.*(..))")
    public void before(JoinPoint joinPoint) {
        // 1、获取方法所属类的信息
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        // 2、获取方法名称
        int modifiers = joinPoint.getSignature().getModifiers();
        String s = Modifier.toString(modifiers);
        String name = joinPoint.getSignature().getName();
        // 3、获取参数列表
        Object[] args = joinPoint.getArgs();
    }

    @AfterReturning(value="execution(* com..impl.*.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {

    }

    @After("execution(* com..impl.*.*(..))")
    public void after(JoinPoint joinPoint) {}

    @AfterThrowing(value="execution(* com..impl.*.*(..))",throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {}
}
