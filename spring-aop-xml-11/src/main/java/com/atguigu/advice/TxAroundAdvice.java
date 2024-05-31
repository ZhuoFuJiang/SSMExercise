package com.atguigu.advice;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TxAroundAdvice {

    /**
     * 环绕通知，需要你在通知中定义目标方法的执行
     * @param joinPoint 目标方法（获取目标方法信息，多了一个执行方法）
     * @return 目标方法的返回值
     * @throws Throwable
     */
    public Object transaction(ProceedingJoinPoint joinPoint) {

        // 保证目标方法执行
        Object[] args = joinPoint.getArgs();
        Object result = null;
        try {
            // 增强代码
            System.out.println("开启事务");
            result = joinPoint.proceed(args);
            System.out.println("结束事务");

        } catch (Throwable e) {
            System.out.println("事务回滚");
            throw new RuntimeException(e);
        } finally {

        }
        return null;
    }
}
