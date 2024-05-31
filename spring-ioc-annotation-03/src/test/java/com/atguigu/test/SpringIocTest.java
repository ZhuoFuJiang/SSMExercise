package com.atguigu.test;

import com.atguigu.ioc_01.XxxDao;
import com.atguigu.ioc_02.JavaBean;
import com.atguigu.ioc_03.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {

    @Test
    public void testIoc_01() {
        // 1、创建ioc容器
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-01.xml");

        // 2、获取组件
        XxxDao bean = context.getBean(XxxDao.class);
        System.out.println("bean" + bean);

        // 添加ioc注解，默认的组件名为类的首字母小写
        Object xxxService = context.getBean("xxxService");
        System.out.println("xxxService" + xxxService);

    }

    @Test
    public void testIoc_02() {
        // 1、创建ioc容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-02.xml");

        // 2、获取组件
        // 多例不会调用destroy方法
        JavaBean bean1 = context.getBean(JavaBean.class);
        JavaBean bean2 = context.getBean(JavaBean.class);
        System.out.println(bean1 == bean2);

        context.close();

    }

    @Test
    public void testIoc_03() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-03.xml");
        UserController userController = context.getBean(UserController.class);

        // ioc容器中有一个UserService接口对应的类
        userController.show();
    }

    @Test
    public void testIoc_04() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-04.xml");
        com.atguigu.ioc_04.JavaBean javaBean = context.getBean(com.atguigu.ioc_04.JavaBean.class);
        System.out.println("bean" + javaBean);
    }
}
