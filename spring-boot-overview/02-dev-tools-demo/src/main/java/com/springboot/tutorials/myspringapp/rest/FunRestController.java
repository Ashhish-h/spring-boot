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
}
