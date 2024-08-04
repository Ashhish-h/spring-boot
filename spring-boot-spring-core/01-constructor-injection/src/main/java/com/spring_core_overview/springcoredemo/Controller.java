package com.spring_core_overview.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private Coach myCoach;

    /*
       @Autowired tells spring-boot to inject dependency. If there is only one constructor then this annotation
       is optional.
       Autowired automatically injects dependencies by searching them in the default package
       */
    @Autowired
    public Controller (Coach myCoach){
        this.myCoach = myCoach;
    }

    // creating an endpoint coachTips
    @GetMapping("/coachTips")
    public String getWorkOutTips(){
        return myCoach.dailyWorkOut() + " and also " + myCoach.dailyPractice();
    }

}
