package com.springboot.crudoperationsdemo;

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
	public CommandLineRunner commandLineRunner(String[] args) {

		return runner -> {
			System.out.println("Hello World");
		};
	}
}
