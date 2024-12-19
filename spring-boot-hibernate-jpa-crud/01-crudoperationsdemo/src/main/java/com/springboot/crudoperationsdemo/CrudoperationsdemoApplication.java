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
//			createStudent(studentDAO);
//			createMultipleStudent(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAOImp studentDAO) {
		// finding students
		System.out.println(studentDAO.findById(3));
		System.out.println(studentDAO.findById(4));
	}

	private void createMultipleStudent(StudentDAOImp studentDAO) {
		// creating multiple students
		Student student1 = new Student("Anjali", "Kushwaha", "anjali@gmail.com");
		Student student2 = new Student("Abhishek", "Kushwaha", "abhishek@gmail.com");
		Student student3 = new Student("Deepak", "Pandey", "deepak@gmail.com");

		// saving the students
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

		// displaying saved msg and ID
		System.out.println("Student1 id: " + student1.getId());
		System.out.println("Student2 id: " + student2.getId());
		System.out.println("Student3 id: " + student3.getId());
	}

	private void createStudent(StudentDAOImp studentDAO) {
		// creating a student
		System.out.println("Creating student...");
		Student student 	= new Student("Ashish", "Kushwaha", "ashish@gmail.com");

		// saving the student
		studentDAO.save(student);

		// displaying
		System.out.println(student.getId());
	}
}
