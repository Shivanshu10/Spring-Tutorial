package com.shivanshu.hibernateadv;

import com.shivanshu.hibernateadv.dao.AppDAO;
import com.shivanshu.hibernateadv.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateadvApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateadvApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createCourseAndStudents(appDAO);
			// findCourseAndStudent(appDAO);
			// findCourseAndStudentByStudentId(appDAO);
			// addCourseToStudent(appDAO);
			// deleteCourseById(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int id;

	}

	private void addCourseToStudent(AppDAO appDAO) {
		int id = 2;

		Student student = appDAO.findStudentAndCoursesByStudentId(id);

		Course course = new Course("Python Prog Master Class");

		student.addCourse(course);

		appDAO.update(student);
	}

	private void findCourseAndStudentByStudentId(AppDAO appDAO) {
		int id = 2;

		Student student = appDAO.findStudentAndCoursesByStudentId(id);
		System.out.println(student);
		System.out.println(student.getCourses());
	}

	private void findCourseAndStudent(AppDAO appDAO) {
		int id = 10;

		Course course = appDAO.findCourseAndStudentByCourseId(id);
		System.out.println(course);
		System.out.println(course.getStudents());
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		Course course = new Course("Pacman - How to Play");

		Student student1 = new Student("John", "Doe", "john@luv2code.com");
		Student student2 = new Student("Mary", "Public", "mary@luv2code.com");

		course.addStudent(student1);
		course.addStudent(student2);

		appDAO.save(course);
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id = 10;

		appDAO.deleteCourseById(id);
	}

	private void getCourseByIdWithReviews(AppDAO appDAO) {
		int id = 10;

		Course course = appDAO.findCourseAndReviewByCourseId(id);

		System.out.println(course);
		System.out.println(course.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course course = new Course("Pacman - How to Score");

		course.addReview(new Review("Great Course"));
		course.addReview(new Review("Good"));
		course.addReview(new Review("Dumb"));

		appDAO.save(course);
	}

	private void deleteCourseById(AppDAO appDAO) {
		int id = 10;

		appDAO.deleteCourseById(id);
	}

	private void deleteInstructorById(AppDAO appDAO) {
		int id = 1 ;
		appDAO.deleteInstructorById(id);
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;
		Course course = appDAO.findCourseById(id);
		System.out.println(course);
		course.setTitle("Python Programming Master Class");
		System.out.println(course);
		appDAO.update(course);
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println(instructor);

		instructor.setLastName("Mishra");
		System.out.println(instructor);
		appDAO.update(instructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
		System.out.println(instructor);
		System.out.println(instructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println(instructor);
		List<Course> courses = appDAO.findCoursesByInstructorId(id);
		instructor.setCourses(courses);
		System.out.println(instructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println(instructor);
		System.out.println(instructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor theInstructor = new Instructor("Chad", "Giga", "giga@luv2code.com");
		InstructorDetail theInstructorDetail = new InstructorDetail("http://www.luv2code/youtube", "luv2code!!!");

		theInstructor.setInstructorDetail(theInstructorDetail);

//		Course tempCourse1 = new Course("Air Guitar - the Ultimate Guide");
//		Course tempCourse2 = new Course("Pinball Masterclass");
//
//		theInstructor.addCourse(tempCourse1);
//		theInstructor.addCourse(tempCourse2);

		appDAO.save(theInstructor);
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 7;

		appDAO.deleteInstructorDetailById(id);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		createInstructor(appDAO);

		int id = 2;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println(instructorDetail);

		System.out.println(instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 6;
		appDAO.deleteInstructorById(id);
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 1;

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println(instructor);
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor theInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
		InstructorDetail theInstructorDetail = new InstructorDetail("http://www.luv2code/youtube", "luv2code!!!");

		theInstructor.setInstructorDetail(theInstructorDetail);

		appDAO.save(theInstructor);
	}


}
