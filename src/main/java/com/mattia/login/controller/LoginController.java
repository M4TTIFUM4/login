package com.mattia.login.controller;

import com.mattia.login.model.User;
import com.mattia.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/autenticazione")
    public RedirectView login(@RequestParam String username, @RequestParam String password) {
        User utente = userService.login(username, password);
        if (utente != null) {
            return new RedirectView("/todo.html?username=" + username);
        } else {
            return new RedirectView("/errore.html");
        }
    }


}
