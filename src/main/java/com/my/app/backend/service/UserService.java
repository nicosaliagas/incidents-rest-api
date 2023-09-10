package com.my.app.backend.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.backend.models.User;
import com.my.app.backend.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> list() {
        return userRepository.findAll();
    }

    public User newUser(User newUser) {
        return userRepository.save(newUser);
    }
}
