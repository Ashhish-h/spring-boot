package com.spring_core_overview.springcoredemo.common;

public class SwimCoach implements Coach {

    /*
        In this approach we won't be using @Component we will use traditional config class.
     */
    public SwimCoach() {
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }

    @Override
    public String dailyWorkOut() {
        return " do daily work out";
    }

    @Override
    public String dailyPractice() {
        return " practice your sport daily ";
    }
}
