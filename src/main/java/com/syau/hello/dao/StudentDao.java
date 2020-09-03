package com.syau.hello.dao;

import com.syau.hello.model.Student;

import java.util.List;

public interface StudentDao {

    public Boolean add(Student stu);

    public Boolean delete(Integer number);

    public Boolean update(Student stu);

    public Student select(Integer number);

    public List<Student> selectAll();
}
