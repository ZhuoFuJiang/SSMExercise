package com.atguigu.ioc_03;


import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


@Controller
public class UserController {

    // 自动装配过程，ioc容器中查找符合类型的组件对象 2、设置给当前属性
    // 同一个类型有多个对应的组件时，默认会依据成员属性名查找
    // Resource同时拥有两个的功能
//    @Autowired
//    @Qualifier(value = "newUserServiceImpl")
    @Resource(name = "newUserServiceImpl")
    private UserService userService;

//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    public void show() {
         System.out.println(userService.show());
    }
}
