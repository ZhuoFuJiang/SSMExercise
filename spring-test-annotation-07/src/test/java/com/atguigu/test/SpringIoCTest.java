package com.atguigu.test;

import com.atguigu.config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import com.atguigu.components.*;

// locations指定xml
@SpringJUnitConfig(value = JavaConfig.class)
public class SpringIoCTest {

    @Autowired
    private A a;

    @Autowired
    private B b;

    @Test
    public void test() {
        System.out.println(a);
    }
}
