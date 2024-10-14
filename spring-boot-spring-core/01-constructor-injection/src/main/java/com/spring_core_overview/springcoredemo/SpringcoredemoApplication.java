package com.spring_core_overview.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
	By default, @SpringBootApplication search for the dependencies, but within the same package to make it search outside
	the default we need to use @SpringBootApplication(scanBasePackage="package name")
 */
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
