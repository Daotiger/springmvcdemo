package com.syau.hello.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    //这里映射url，访问时：http://127.0.0.1:8080/tomcat默认名字(springmvc)/student
    @RequestMapping("student")
    public String hello(){
        System.out.println("======hello======");
        return "student";
    }
}
