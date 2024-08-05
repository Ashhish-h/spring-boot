package com.spring_core_overview.springcoredemo;

import com.spring_core_overview.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private Coach myCoach;

    /*
        for this qualifiers we will use constructor injection
     */
    @Autowired
    public Controller(Coach theCoach){
        this.myCoach = theCoach;
    }

    // creating an endpoint coachTips
    @GetMapping("/coachTips")
    public String getWorkOutTips(){
        return myCoach.dailyWorkOut() + " and also " + myCoach.dailyPractice();
    }

}
