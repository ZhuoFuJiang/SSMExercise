package com.atguigu.ioc_05;

import org.springframework.beans.factory.FactoryBean;


public class JavaBeanFactoryBean implements FactoryBean {

    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public Object getObject() throws Exception {
        // 使用你自己的方式实例化对象就可以了
        JavaBean javaBean = new JavaBean();
        javaBean.setName(value);
        return javaBean;
    }

    @Override
    public Class<?> getObjectType() {
        return JavaBean.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
