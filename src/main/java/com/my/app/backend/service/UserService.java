package com.my.app.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.my.app.backend.exceptions.ContrainteUniqueException;
import com.my.app.backend.models.User;
import com.my.app.backend.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> list() {
        return userRepository.findAll();
    }
    
    public User findUserById(Long id) {
        return userRepository.getReferenceById(id);
    }
    
    public Optional<User> findUserByMail(String email) {
        return userRepository.findByMail(email);
    }

    public User newUser(User newUser) {
        try {
            return userRepository.save(newUser);
        } catch (DataIntegrityViolationException ex) {
            throw new ContrainteUniqueException("L'utilisateur existe déjà.");
        }
    }
}
