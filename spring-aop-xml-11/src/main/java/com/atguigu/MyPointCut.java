package com.atguigu;


import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class MyPointCut {
    @Pointcut("execution(* com.atguigu.service.Impl.*.*(..))")
    public void pointCut() {}

    @Pointcut("execution(* com..Impl.*.*(..))")
    public void myPc(){}
}
