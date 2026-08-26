package com.example.studeentmanger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/")
    public String hello() {
        return "Hello Student Manager!";
    }

    // Bài 2
    @GetMapping("/student/{id}")
    public String getStudent(@PathVariable int id) {
        return "Sinh viên có mã: " + id;
    }

    // Bài 3
    @GetMapping("/student")
    public String greet(@RequestParam String name) {
        return "Xin chào " + name;
    }

    // Bài 3
    @GetMapping("/searchStudent")
    public String searchStudent(
            @RequestParam String name,
            @RequestParam(defaultValue = "1") int age) {

        return "Tên=" + name + ", tuổi=" + age;
    }

    // Bài 4A
    @GetMapping("/students")
    public Student getStudentObject() {
        return new Student(1, "Nguyễn Văn A", 20);
    }

    // Bài 4B
    @GetMapping("/studentall")
    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();

        list.add(new Student(1, "A", 20));
        list.add(new Student(2, "B", 21));

        return list;
    }

    // Bài Authorization
   @GetMapping("/getstudent")
public String getStudents(
        @RequestHeader(value = "Authorization", defaultValue = "Bearer abc123") String authorization) {

    return "Authorization = " + authorization;
}
    }
