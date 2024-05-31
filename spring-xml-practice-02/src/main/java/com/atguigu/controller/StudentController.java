package com.atguigu.controller;

import com.atguigu.Student;
import com.atguigu.service.StudentService;

import java.util.List;

public class StudentController {

    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void  findAll(){
        List<Student> studentList =  studentService.findAll();
        System.out.println("studentList = " + studentList);
    }
}
