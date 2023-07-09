package com.shivanshu.restdemo.rest;

import com.shivanshu.restdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<Student>();


        theStudents.add(new Student("Shivanshu", "Mishra"));
        theStudents.add(new Student("Rahul", "Verma"));
        theStudents.add(new Student("Mehak", "Noor"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        if (studentId >= theStudents.size() || studentId<0) {
            throw new StudentNotFound("Student id not found  - "+studentId);
        }
        return theStudents.get(studentId);
    }
}
