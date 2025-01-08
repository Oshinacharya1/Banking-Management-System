package com.project.BankingManagement.service;

import com.project.BankingManagement.entity.User;
import com.project.BankingManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        Optional<User> currentUser = userRepository.findByUsername(user.getUsername());
        if (currentUser.isPresent()){
            if (currentUser.get().getPassword().equals(user.getPassword())){
                return currentUser.orElse(null);
            }
        }
        return null;
    }

}
