package com.project.BankingManagement.controller;

import com.project.BankingManagement.entity.User;
import com.project.BankingManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

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

    @GetMapping("/verify-admin/{email}")
    public ResponseEntity<Map<String, Boolean>> verifyAdminRole(@PathVariable String email) {
        boolean hasAdminRole = userService.isUserAdmin(email);
        return ResponseEntity.ok(Collections.singletonMap("isAdmin", hasAdminRole));
    }

}
