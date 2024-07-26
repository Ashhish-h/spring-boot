package com.springboot.tutorials.myspringapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // create a hello world function
    /*
        @GetMapping annotation is used for mapping HTTP GET requests onto specific handler methods.
        It is composed annotation that acts as a shortcut for @RequestMapping(method=RequestMethod.
     */
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    // creating another route to test devtools auto reload feature
    @GetMapping("/test")
    public String testingDevTools(){
        return "Dev Tool is working fine!";
    }

    //creating another test function
    @GetMapping("/information")
    public String getInfo(){
        return "This is a demo project only for learning purpose";
    }

    /*
        Creating variables and assigning them the custom properties declared in application.properties file.
        Thats the main properties file of the spring boot it used for cconfigurations and descriping custom properties.
        W'll also create a endpoint to show those properties on the web.
     */

    @Value("${project.name}")
    private String projectNname;

    @Value("${project.team.leader}")
    private String teamLeader;

    @Value("${project.platform}")
    private String platform;

    @Value("${project.idea}")
    private String projectIdea;

    @GetMapping("/project-info")
    public String projectInfo(){
        return "project name : " + projectNname + "project team leader : " + teamLeader + "project's platform : "
                + platform + "project idea : " + projectIdea;
    }
}
