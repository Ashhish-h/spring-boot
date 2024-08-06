package com.spring_core_overview.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TTCoach implements Coach{
    public TTCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String dailyWorkOut() {
        return " Do daily flexibility workout ";
    }

    @Override
    public String dailyPractice() {
        return " Do daily practice";
    }
}
