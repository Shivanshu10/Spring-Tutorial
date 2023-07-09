package com.shivanshu.demorestproject.dao;

import com.shivanshu.demorestproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
