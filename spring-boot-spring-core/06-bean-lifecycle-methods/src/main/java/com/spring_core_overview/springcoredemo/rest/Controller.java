package com.spring_core_overview.springcoredemo;

import com.spring_core_overview.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private Coach myCoach;
    private Coach anotherCoach;

    /*
        Our default scope is singelton so both myCoach and anotherCoach will refer the same instance;
        NO new instance will be created, each time.
     */

    @Autowired
    public Controller( @Qualifier("badmintonCoach") Coach theCoach,
                       @Qualifier("badmintonCoach") Coach anotherCoach){
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myCoach = theCoach;
        this.anotherCoach = anotherCoach;
    }




    // creating an endpoint coachTips
    @GetMapping("/coachTips")
    public String getWorkOutTips(){
        return myCoach.dailyWorkOut() + " and also " + myCoach.dailyPractice();
    }

    // creating a new end point to verify that both myCoach and anotherCoach refers to the same bean.
    @GetMapping("/check")
    public String check(){   // this myCoach == anotherCoach will return true is same bean is used and false if not.
        return "Comparing Beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }

}
