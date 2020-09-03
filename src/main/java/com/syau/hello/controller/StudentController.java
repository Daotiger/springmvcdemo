package com.syau.hello.controller;

import com.syau.hello.model.Student;
import com.syau.hello.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    private Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    //这里映射url，访问时：http://127.0.0.1:8080/tomcat默认名字(springmvc)/student
    @RequestMapping("student")
    public String hello( Model model ){

        logger.info("请求访问");

        List<Student> studentList = studentService.selectAll();

        logger.info("studentList: " + studentList);

        model.addAttribute("studentList", studentList);

        return "student";
    }
}
