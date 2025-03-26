package com.spring_security.spring_security.service;


import com.spring_security.spring_security.entity.Users;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<Users> users = new ArrayList<>();

    public UserService() {
        users.add(new Users("ashish", "ashish123", "ashish@gmail.com"));
        users.add(new Users("abhishek", "abhishek123", "abhishek@gmail.com"));
        users.add(new Users("sachin", "sachin123", "sachin@gmail.com"));
    }

    // to get all users
    public List<Users> getUsers() {
        return this.users;
    }

    // get a single user
    public Users getSingleUser(String username){
        return this.users.stream().filter((users) -> users.getUsername().equals(username)).findAny().orElse(null);
    }

    // add a user
    public Users addUser(Users user) {
        this.users.add(user);
        return user;
    }


}
