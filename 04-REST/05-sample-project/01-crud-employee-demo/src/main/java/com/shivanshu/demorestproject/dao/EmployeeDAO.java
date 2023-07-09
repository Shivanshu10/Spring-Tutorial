package com.shivanshu.demorestproject.dao;

import com.shivanshu.demorestproject.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
