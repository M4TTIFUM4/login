package com.mattia.login.service;

import com.mattia.login.model.User;
import com.mattia.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean registra(String username, String password) {
        if (userRepository.findByUsername(username) != null) {
            return false; // già registrato
        }
        User nuovo = new User(null, username, password);
        userRepository.save(nuovo);
        return true;
    }

    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
