package com.syau.hello.dao.impl;

import com.syau.hello.dao.StudentDao;
import com.syau.hello.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath:applicationContext.xml")
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/applicationContext.xml")
public class StudentDaoImplTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void TestAdd() {

        Student stu = new Student();
        stu.setNumber(1);
        stu.setName("ergou");
        stu.setAge(12);

        studentDao.add(stu);
    }

    @Test
    public void testSelectAll() {

        List<Student> studentList = studentDao.selectAll();
        System.out.println(studentList.toString());
    }


}