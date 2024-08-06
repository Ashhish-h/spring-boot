package com.spring_core_overview.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    public CricketCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String dailyWorkOut() {
        return " Do daily running of 5 to 10 kms ";
    }

    @Override
    public String dailyPractice() {
        return " Do daily net practice";
    }
}
