package com.atguigu.pojo;


import lombok.Data;

import java.util.List;

@Data
public class Order {

    private Integer orderId;
    private String orderName;
    private Integer customerId;
    private Customer customer;// 体现的是对一的关系

}
