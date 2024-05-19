package com.atguigu.test;

import com.atguigu.ioc_03.A;
import com.atguigu.ioc_03.HappyComponent;
import com.atguigu.ioc_05.JavaBean;
import com.atguigu.ioc_04.JavaBean2;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ioc容器创建和读取组件的测试类
 */
public class SpringIoCTest {

    /**
     * 讲解如何创建ioc容器并且读取配置文件
     */
    public void createIoC() {
        // 床啊金容器，选择合适的容器实现即可
        /**
         * 接口 BeanFactory
         *
         * ApplicationContext
         *
         * 实现类
         * 可以直接公国构造函数实例化
         * ClassPathXmlApplicationContext 读取类路径下的xml配置方式
         * FileSystemXmlApplicationContext 读取指定文件位置的xml位置方式
         * AnnotationConfigApplicationContext 读取配置方式的ioc容器
         * WebApplicationContext web项目专属的配置ioc容器
         */

        // 方式1：直接创建容器并且指定配置文件即可
        // 构造函数可以填写一个或者多个
        // ioc di
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");

        // 方式2：先创建ioc容器对象，再指定配置文件，再刷新
        // 源码的配置过程 创建容器和配置文件指定分开
        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext();
        applicationContext1.setConfigLocations("spring-03.xml");
        applicationContext1.refresh();
    }

    /**
     * 讲解如何再IoC容器中获取组件Bean
     */
    @Test
    public void getBeanFromIoc() {
        // 1. 创建ioc容器对象
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocations("spring-03.xml");
        applicationContext.refresh();

        // 2.读取ioc容器的组件
        // 方案1：直接提供beanId即可，返回值是Object
        HappyComponent happyComponent = (HappyComponent) applicationContext.getBean("happyComponent");

        // 方案2：依据beanId，同时指定bean的类型Class
        HappyComponent happyComponent1 = applicationContext.getBean("happyComponent", HappyComponent.class);

        // 方案3：直接根据类型获取
        // 依据bean的类型获取，同一个类型，在ioc容器中只能有一个bean
        // 如果ioc容器存在多个同类型的Bean，会出现NoUniqueBeanDefinitionException
        // ioc的配置一定是实现类，但是可以依据接口类型获取值
        HappyComponent happyComponent2 = applicationContext.getBean(HappyComponent.class);

        happyComponent2.doWork();

        System.out.println(happyComponent == happyComponent1);
        System.out.println(happyComponent2 == happyComponent1);

        A happyComponent3 = applicationContext.getBean(A.class);

        happyComponent3.doWork();

        System.out.println(happyComponent3 == happyComponent1);
        System.out.println(happyComponent3 == happyComponent2);
    }

    /**
     * 测试ioc配置和销毁方法的触发
     */
    @Test
    public void test_04() {
        // 1.创建ioc容器，就会进行组件对象的实例化 -> init
        ClassPathXmlApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("spring-04.xml");
        // ioc -> 容器去调用destroy
        // ioc会立即释放 死了

        JavaBean2 bean2 = applicationContext.getBean(JavaBean2.class);
        JavaBean2 bean3 = applicationContext.getBean(JavaBean2.class);
        System.out.println(bean3 == bean2);

        applicationContext.close();
    }

    /**
     * 读取使用factoryBean工厂配置的组件对象
     */
    @Test
    public void test_05() {
        // 1.创建ioc容器，就会进行组件对象的实例化 -> init
        ClassPathXmlApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("spring-05.xml");
        // 读取组件
        JavaBean javaBean = applicationContext.getBean("javaBean", JavaBean.class);
        System.out.println("javaBean = " + javaBean);

        Object bean = applicationContext.getBean("&javaBean");
        System.out.println("bean = " + bean);

        applicationContext.close();
    }
}
