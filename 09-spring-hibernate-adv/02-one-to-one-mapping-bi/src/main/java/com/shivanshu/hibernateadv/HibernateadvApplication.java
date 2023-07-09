package com.shivanshu.hibernateadv;

import com.shivanshu.hibernateadv.dao.AppDAO;
import com.shivanshu.hibernateadv.entity.Instructor;
import com.shivanshu.hibernateadv.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateadvApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateadvApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			// deleteInstructor(appDAO);
			// findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};
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
