package com.atguigu.dao;


import com.atguigu.Student;

import java.util.List;

public interface StudentDao {

    /**
     * 查询全部学生数据
     * @return
     */
    List<Student> queryAll();
}
