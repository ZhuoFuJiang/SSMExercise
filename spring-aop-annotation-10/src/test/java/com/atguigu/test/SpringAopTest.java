package com.atguigu.test;


import com.atguigu.config.JavaConfig;
import com.atguigu.service.Calculator;
import com.atguigu.service.Impl.CalculatorPureImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = JavaConfig.class)
public class SpringAopTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void test() {
        int result = calculator.add(1, 0);
        System.out.println(result);
    }
}
