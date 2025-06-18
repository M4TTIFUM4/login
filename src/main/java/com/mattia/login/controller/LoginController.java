package com.mattia.login.controller;

import com.mattia.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/autenticazione")
    public String login(@RequestParam String username, @RequestParam String password) {
        if (userService.login(username, password)) {
            return "Login riuscito!";
        } else {
            return "Credenziali errate.";
        }
    }
}
