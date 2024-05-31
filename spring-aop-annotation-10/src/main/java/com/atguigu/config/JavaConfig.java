package com.atguigu.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan(value = {"com.atguigu.service",
"com.atguigu.advice"})
@EnableAspectJAutoProxy
public class JavaConfig {

}
