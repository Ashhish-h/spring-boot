package com.spring_security.spring_security.controller;


import com.spring_security.spring_security.entity.Users;
import com.spring_security.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<Users> getAllUsers(){
        return this.userService.getUsers();
    }

    @GetMapping("/{username}")
    public Users getSingleUser(@PathVariable("username") String username){
        return this.userService.getSingleUser(username);
    }

    @PostMapping("/addUser")
    public Users addUser(@RequestBody Users user){
        return this.userService.addUser(user);
    }

}
