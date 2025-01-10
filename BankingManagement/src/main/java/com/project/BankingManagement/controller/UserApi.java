package com.project.BankingManagement.controller;


import com.project.BankingManagement.entity.User;
import com.project.BankingManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class UserApi {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody User user)
    {
        System.out.println("Username: " + user.getUsername());
        return userService.loginUser(user);
    }


    @PostMapping("/register")
    public User register(@RequestBody User user)
    {
        System.out.println("User: " + user);
        return userService.register(user);
    }
}
