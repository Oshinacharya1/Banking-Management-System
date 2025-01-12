package com.project.BankingManagement.service;

import com.project.BankingManagement.entity.User;
import com.project.BankingManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    AuthenticationManager manager;
    public User register(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String loginUser(User user) {
        Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword())
        );
        if(authentication.isAuthenticated()) {
            System.out.println("Success user match in database");
            User existingUserDetail = findByUser(user);
            return existingUserDetail.getEmail();
        }
        return "Failed";
    }

    public User findByUser(User user){
        return userRepository.findByUsername(user.getUsername());
    }

    public boolean isUserAdmin(String email){
        User user = userRepository.findByEmail(email);
        return "ADMIN".equalsIgnoreCase(user.getRole());
    }

}
