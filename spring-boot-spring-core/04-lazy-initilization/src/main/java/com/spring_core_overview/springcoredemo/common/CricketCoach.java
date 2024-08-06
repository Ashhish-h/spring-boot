package com.spring_core_overview.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
// if we mark these bean classes as lazy they won't be initialized, they will only be initialized when they are needed
@Lazy
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
