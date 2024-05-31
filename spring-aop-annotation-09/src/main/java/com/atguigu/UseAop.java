package com.atguigu;

import com.atguigu.dynamic.ProxyFactory;
import com.atguigu.statics.StaticProxyCalculator;

public class UseAop {

    public static void main(String[] args) {
        Calculator target = new CalculatorPureImpl();

        Calculator proxy = new StaticProxyCalculator(target);

        int result = proxy.add(1, 2);
        System.out.println(result);

        // jdk代理
        ProxyFactory proxyFactory = new ProxyFactory(target);
        // 使用接口赋值 = 代理对象【兄弟】
        Calculator calculator = (Calculator) proxyFactory.getProxy();
        calculator.add(1, 1);
    }
}
