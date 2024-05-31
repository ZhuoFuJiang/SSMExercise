package com.atguigu.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(value = {"com.atguigu.ioc_01"})
@PropertySource(value = "classpath:jdbc.properties")
public class JavaConfiguration {

    @Value("${atguigu.url}")
    private String url;
    @Value("${atguigu.username}")
    private String username;
    @Value("${atguigu.password}")
    private String password;
    @Value("${atguigu.driver")
    private String driver;

    /**
     * 方法的返回值类型 == bean组件的类型或者它的接口和父类
     * 方法的名字 = bean id
     *
     * @Bean会真正让配置类的方法创建的组件存储到ioc容器
     *
     * 问题1：baseName的问题 默认：方法名 指定：name/value属性起名字，覆盖方法名
     * 问题2：周期方法如何指定 原有注解方案：PostConstruct + PreDestroy注解指定
     *       bean属性方案：initMethod / destroyMethod
     * 问题3：作用域 还是使用Scope注解
     * @return
     */

    @Bean
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public DruidDataSource druidDataSource() {
        // 实现具体的实例化过程
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(driver);
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(druidDataSource());
        return jdbcTemplate;
    }
}
