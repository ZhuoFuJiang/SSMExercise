package com.atguigu.test;

import com.atguigu.config.JavaConfiguration;
import com.atguigu.ioc_01.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCTest {

    @Test
    public void test() {
//        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class);

        // AnnotationConfigApplicationContext-IOC容器对象
        AnnotationConfigApplicationContext iocContainerAnnotation = new AnnotationConfigApplicationContext();
        //外部设置配置类
        iocContainerAnnotation.register(JavaConfiguration.class);
        //刷新后方可生效！！
        iocContainerAnnotation.refresh();

        StudentController studentController = iocContainerAnnotation.getBean(StudentController.class);
        System.out.println("bean" + studentController);
    }
}
