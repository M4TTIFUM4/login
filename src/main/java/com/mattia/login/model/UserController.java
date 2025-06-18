package com.mattia.login.model;

import com.mattia.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registrati")
    public RedirectView registra(@RequestParam String username, @RequestParam String password) {
        boolean success = userService.registra(username, password);
        if (success) {
            return new RedirectView("/successo.html");
        } else {
            return new RedirectView("/errore.html");
        }
    }
}
