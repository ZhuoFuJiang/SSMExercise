package com.atguigu.mapper;

import com.atguigu.pojo.Customer;

public interface CustomerMapper {

    Customer selectCustomerWithOrderList(Integer customerId);
}
