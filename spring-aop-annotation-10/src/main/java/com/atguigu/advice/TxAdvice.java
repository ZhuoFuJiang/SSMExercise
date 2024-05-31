package com.atguigu.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Order(10)
public class TxAdvice {

    @Before("com.atguigu.MyPointCut.pointCut()")
    public void begin() {
        System.out.println("开启事务");
    }

    @AfterReturning("com.atguigu.MyPointCut.pointCut()")
    public void commit() {
        System.out.println("事务提交");
    }

    @AfterThrowing("com.atguigu.MyPointCut.pointCut()")
    public void rollback() {
        System.out.println("事务回滚");
    }
}

