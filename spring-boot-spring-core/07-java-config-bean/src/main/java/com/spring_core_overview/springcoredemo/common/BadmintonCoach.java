package com.spring_core_overview.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// This @Component annotation marks the class as spring beans class

@Component
public class  BadmintonCoach implements Coach {

    /*
        The @PostConstruct annotation in Spring Boot is used to define a method that needs to be executed after
        dependency injection is done and the bean is fully constructed. This method is typically used for initialization
        tasks, such as setting up resources, establishing connections, or performing any other necessary setup.
     */

    @PostConstruct
    public void init(){
        System.out.println("Initialization has starte......");
    }

    public String doSmething(){
        return "this how the postconstruct works.....";
    }

    /*
        On the other hand, @PreDestroy is used to define a method that needs to be executed before the bean is destroyed.
        This method is typically used for cleanup tasks, such as releasing resources, closing connections, or performing
        any other necessary tear down.
     */

    @PreDestroy
    public void cleanup(){
        System.out.println("Cleaning up everything.....");
    }

    @Override
    public String dailyWorkOut() {
        return " You are required to do daily workout for the fitness of the body ";
    }

    @Override
    public String dailyPractice() {
        return " You are required to do daily practice so that you can improve your performance ";
    }
}
