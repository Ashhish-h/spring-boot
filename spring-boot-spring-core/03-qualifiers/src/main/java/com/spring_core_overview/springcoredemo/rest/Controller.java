package com.spring_core_overview.springcoredemo;

import com.spring_core_overview.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private Coach myCoach;

    /*
        for this qualifiers we will use constructor injection.
        by using qualifiers we specifically tells the spring which bean is to be injected.
        @Quaifier should be inside the parameters of the constructor or setter.
     */

    // this was the qualifier example
    /*
         @Autowired
        public Controller( @Qualifier("cricketCoach") Coach theCoach){
            this.myCoach = theCoach;
        }
     */



    /*
        Now this will be the primary example in this we don't have to use qualifier but qualifier is more preffered
        since it has a high priority and it is more specific
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
