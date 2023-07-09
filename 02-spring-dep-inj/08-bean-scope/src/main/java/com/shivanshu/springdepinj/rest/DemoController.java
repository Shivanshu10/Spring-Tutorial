package com.shivanshu.springdepinj.rest;

import com.shivanshu.springdepinj.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    // same name as class except first char lower
    public DemoController(@Qualifier("cricketCoach") Coach theCoach, @Qualifier("cricketCoach") Coach theAnotherCoach) {
        System.out.println("In constructor: "+getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Compaing beans myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}
