package com.syau.hello.service;

import com.syau.hello.model.Student;

import java.util.List;

public interface StudentService {

    public Boolean add(Student stu);

    public Boolean delete(Integer number);

    public Boolean update(Student stu);

    public Student select(Integer number);

    public List<Student> selectAll();

}
