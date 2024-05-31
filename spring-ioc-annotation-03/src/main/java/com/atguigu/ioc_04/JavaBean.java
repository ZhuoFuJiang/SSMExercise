package com.atguigu.ioc_04;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JavaBean {
    // 方案一：直接赋值
    // 方案二：使用注解 读取外部配置
    private String name = "二狗子";

    @Value("19")
    private int age;

    @Value("${jdbc.username:admin}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

}
