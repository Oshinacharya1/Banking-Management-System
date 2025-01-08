package com.project.BankingManagement.controller;


import com.project.BankingManagement.entity.User;
import com.project.BankingManagement.service.UserService;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(@RequestBody User user)
    {
        return userService.registerUser(user);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user)
    {
        return userService.registerUser(user);
    }
}
