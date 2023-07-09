package com.shivanshu.cruddemo.dao;

import com.shivanshu.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findSByLastName(String theLastName);

    void update(Student theStudent);

    void delete(int id);

    int deleteAll();
}
