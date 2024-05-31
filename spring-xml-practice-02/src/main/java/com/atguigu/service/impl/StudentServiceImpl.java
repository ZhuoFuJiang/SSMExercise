package com.atguigu.service.impl;

import com.atguigu.Student;
import com.atguigu.dao.StudentDao;
import com.atguigu.service.StudentService;

import java.util.List;

//实现类
public class StudentServiceImpl  implements StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    /**
     * 查询全部学员业务
     * @return
     */
    @Override
    public List<Student> findAll() {

        List<Student> studentList =  studentDao.queryAll();

        return studentList;
    }
}
