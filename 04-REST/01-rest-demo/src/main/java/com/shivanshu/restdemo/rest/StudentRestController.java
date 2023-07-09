package com.shivanshu.restdemo.rest;

import com.shivanshu.restdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<Student>();

        students.add(new Student("Shivanshu", "Mishra"));
        students.add(new Student("Rahul", "Verma"));
        students.add(new Student("Mehak", "Noor"));

        return students;
    }
}
