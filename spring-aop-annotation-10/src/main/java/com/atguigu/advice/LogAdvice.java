package com.atguigu.advice;


import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 1、定义方法存储增强代码
 *  具体定义几个方法，根据插入的位置决定
 *  2、使用注解配置，指定插入目标方法的位置
 *  前置 @Before
 *  后置 @AfterReturning
 *  异常 @AfterThrowing
 *  最后 @After
 *  环绕 @Around
 *  3、配置切点表达式
 *  4、补全注解
 *     加入ioc容器 @Component
 *     配置切面 @Aspect = 切点 + 增强
 *  5、开启aspect的支持
 */

@Component
@Aspect
@Order(20) // 值越小优先级越高
public class LogAdvice {

    /**
     * TODO:切点表达式
     *      固定语法 execution(1 2 3.4.5(6))
     *      1、访问修饰符
     *      public private
     *      2、方法的返回参数类型
     *      String int void
     *      如果不考虑修饰符和返回值，这两位整合成一起写
     *      如果要是不考虑， 必须两个都不考虑
     *      3、包的位置
     *      具体包：com.atguigu.service.impl
     *      单层模糊：com.atugigu.service.*
     *      多层模糊：com..impl ..是任意层的模糊，但是不能开头 可以写*..impl
     *      4、类的名称
     *      具体：CalculatorPureImpl
     *      模糊：*
     *      部分模糊：*Impl
     *      5、方法名 语法和类名一致
     *      6、形参参数列表
     *      没有参数：()
     *      有具体参数：(String) (String,int)
     *      模糊参数:(String..) String后面有没有无所谓
     *              (..int)最后一个参数是int
     *
     *      可以统一切点管理，通过Pointcut关键字
     *
     *      切点表达式的提取和复用
     *      1、当前类中提取，定义一个空方法，注解Pointcut
     *      2、创建一个存储切点的类，单独维护切点表达式
     */


    @Before("com.atguigu.MyPointCut.pointCut()")
    public void start() {
        System.out.println("方法开始了");
    }

    @After("com.atguigu.MyPointCut.pointCut()")
    public void after() {
        System.out.println("方法结束了");
    }

    @AfterThrowing("com.atguigu.MyPointCut.pointCut()")
    public void error() {
        System.out.println("方法报错了");
    }
}
