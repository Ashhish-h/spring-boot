package com.spring_core_overview.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private Coach myCoach;

    /*
        Now we are going to use setter injection for this myCoach property.
        you can use any method name in place of setCoach(setter method) spring will handle it automatically.
     */
    @Autowired
    public void setCoach(Coach myCoach){
        this.myCoach = myCoach;
    }

    // creating an endpoint coachTips
    @GetMapping("/coachTips")
    public String getWorkOutTips(){
        return myCoach.dailyWorkOut() + " and also " + myCoach.dailyPractice();
    }

}
