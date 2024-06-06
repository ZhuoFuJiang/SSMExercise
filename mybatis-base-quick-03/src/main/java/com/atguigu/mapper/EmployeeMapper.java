package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    Employee queryById(Integer id);

    int deleteById(Integer id);

    List<Employee> queryBySalary(Double salary);

    int insertEmp(Employee employee);

    List<Employee> queryByNameAndSalary(@Param("a") String name, @Param("b") Double salary);

    int insertEmpMap(Map data);

    String queryNameById(Integer id);

    Double querySalaryById(Integer id);

    Map<String,Object> selectEmpNameAndMaxSalary();

    List<Employee> selectAll();
}
