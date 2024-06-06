package com.atguigu.test;

import com.atguigu.mapper.CustomerMapper;
import com.atguigu.mapper.OrderMapper;
import com.atguigu.pojo.Customer;
import com.atguigu.pojo.Order;
import lombok.extern.slf4j.Slf4j;
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
    public void testRelationshipToOne() {

        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        // 查询Order对象，检查是否同时查询了关联的Customer对象
        Order order = orderMapper.selectOrderWithCustomer(2);
        System.out.println("order = " + order);

    }

    @Test
    public void testRelationshipToMulti() {

        CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
        // 查询Customer对象同时将关联的Order集合查询出来
        Customer customer = customerMapper.selectCustomerWithOrderList(1);
        System.out.println("customer.getCustomerId() = " + customer.getCustomerId());
        System.out.println("customer.getCustomerName() = " + customer.getCustomerName());
        List<Order> orderList = customer.getOrderList();
        for (Order order : orderList) {
            System.out.println("order = " + order);
        }
    }

    // junit会在每一个@Test方法后执行@@AfterEach方法
    @AfterEach
    public void clear() {
        session.commit();
        session.close();
    }
}
