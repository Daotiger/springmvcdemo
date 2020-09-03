package com.syau.hello.service.impl;

import com.syau.hello.dao.StudentDao;
import com.syau.hello.model.Student;
import com.syau.hello.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    @Override
    public Boolean add(Student stu) {

        return studentDao.add(stu);
    }

    @Override
    public Boolean delete(Integer number) {

        return studentDao.delete(number);
    }

    @Override
    public Boolean update(Student stu) {

        return studentDao.update(stu);
    }

    @Override
    public Student select(Integer number) {

        return studentDao.select(number);
    }

    @Override
    public List<Student> selectAll() {

        return studentDao.selectAll();
    }
}
