package com.atguigu.mapper;

import com.atguigu.pojo.Employee;

public interface EmployeeMapper {
    Employee queryById(Integer id);
    int deleteById(Integer id);
}
