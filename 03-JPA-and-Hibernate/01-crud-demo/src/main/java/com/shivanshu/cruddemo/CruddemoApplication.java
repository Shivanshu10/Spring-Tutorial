package com.shivanshu.cruddemo;

import com.shivanshu.cruddemo.dao.StudentDAO;
import com.shivanshu.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	@Autowired
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}
	private void deleteAllStudent(StudentDAO studentDAO) {
		int numRowDeleted = studentDAO.deleteAll();
		System.out.println("Deleted all Student, "+numRowDeleted);
	}
	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1;
		studentDAO.delete(studentId);
	}
	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);

		myStudent.setFirstName("Scooby");

		studentDAO.update(myStudent);

		System.out.println("Student updated to: "+myStudent);
	}

	private void queryByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findSByLastName("Duck");

		for (Student student: students) {
			System.out.println(student);
		}
	}

	private void queryAll(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for (Student student: students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new Student Obj...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@shivanshu.com");

		System.out.println("Saving Student..");
		studentDAO.save(tempStudent);

		int id = tempStudent.getId();
		System.out.println("Saved Student, Id: "+id);

		System.out.println("Retriving Student with Id: "+id);
		Student foundStudent = studentDAO.findById(id);

		System.out.println("Found Student: "+foundStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new Student Obj...");
		Student tempStudent = new Student("Paul", "Doe", "paul@shivanshu.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved Output Generated Id: " + tempStudent.getId());
	}
}
