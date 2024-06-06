package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    List<Employee> query(@Param("name") String name, @Param("salary") Double salary);

    int update(Employee employee);

    List<Employee> queryTrim(@Param("name") String name, @Param("salary") Double salary);

    // 如果姓名不为null，使用姓名查询，如果姓名为空，薪水不为空就用薪水查询，都为null查询全部
    List<Employee> queryChoose(@Param("name") String name, @Param("salary") Double salary);

    List<Employee> queryBatch(@Param("ids") List<Integer> ids);

    int deleteBatch(@Param("ids") List<Integer> ids);

    int insertBatch(@Param("list") List<Employee> employees);

    int updateBatch(@Param("list") List<Employee> employees);

    List<Employee> queryList();
}
