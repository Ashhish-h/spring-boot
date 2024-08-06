package com.spring_core_overview.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// This @Component annotation marks the class as spring beans class

@Component
public class BadmintonCoach implements Coach {


    @Override
    public String dailyWorkOut() {
        return " You are required to do daily workout for the fitness of the body ";
    }

    @Override
    public String dailyPractice() {
        return " You are required to do daily practice so that you can improve your performance ";
    }
}
