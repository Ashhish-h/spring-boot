package com.springboot.crudoperationsdemo;

import com.springboot.crudoperationsdemo.dao.StudentDAOImp;
import com.springboot.crudoperationsdemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudoperationsdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudoperationsdemoApplication.class, args);
	}


	/*
		 This CommandLineRunner is form spring boot library and this method will only execute after all the beans are
		 loaded. We are going command line to actually understand how crud operations work. Now to connect to the database
		 add the configuration in the application.properties file
	 */
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAOImp studentDAO) { // in place of String[] args we pass our entity  or repository class

		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAOImp studentDAO) {
		// creating a student
		System.out.println("Creating student...");
		Student student = new Student("Ashish", "Kushwaha", "ashish@gmail.com");

		// saving the student
		studentDAO.save(student);

		// displaying
		System.out.println(student.getId());
	}
}
