package com.atguigu.test;

import com.atguigu.config.JavaConfig;
import com.atguigu.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentIoCTest {
    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        StudentController controller = (StudentController) context.getBean(StudentController.class);
        controller.findAll();
    }
}
