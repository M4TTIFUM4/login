package com.mattia.login.service;

import com.mattia.login.model.User;
import com.mattia.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // REGISTRA UTENTE
    public boolean registra(String username, String password) {
        if (userRepository.findByUsername(username) != null) {
            return false; // Utente già registrato
        }
        User nuovo = new User(null, username, password);
        userRepository.save(nuovo);
        return true;
    }

    // LOGIN UTENTE
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
}
