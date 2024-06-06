package com.atguigu.test;

import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class MyBatisTest {

    private SqlSession session;
    // junit会在每一个@Test方法前执行@BeforeEach方法

    @BeforeEach
    public void init() throws IOException, IOException {
        session = new SqlSessionFactoryBuilder()
                .build(
                        Resources.getResourceAsStream("mybatis-config.xml"))
                .openSession();
    }


    @Test
    public void test_01() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        List<Employee> employees = employeeMapper.query(null, 101.0);
        System.out.println(employees);
    }

    @Test
    public void test_02() throws IOException {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        // 调用之前，先设置分页数据，当前是第几页，每页显示多少个
        PageHelper.startPage(1, 2);
        List<Employee> list = employeeMapper.queryList();

        // 将查询数据封装到一个PageInfo的分页实体类
        PageInfo<Employee> pageInfo = new PageInfo<Employee>(list);

        // 获取当前页的数据
        List<Employee> list1 = pageInfo.getList();

        int pages = pageInfo.getPages();
        System.out.println("pages:" + pages);

        long total = pageInfo.getTotal();
        System.out.println("total:" + total);


        int pageNum = pageInfo.getPageNum();
        System.out.println("pageNum:" + pageNum);

        int pageSize = pageInfo.getPageSize();

        System.out.println("pageSize:" + pageSize);

    }

    // junit会在每一个@Test方法后执行@@AfterEach方法
    @AfterEach
    public void clear() {
        session.commit();
        session.close();
    }
}
