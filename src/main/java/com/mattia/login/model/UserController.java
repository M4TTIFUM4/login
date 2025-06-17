package com.mattia.login.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class UserController {

    @Autowired
    private JsonFileService jsonFileService;

    @PostMapping("/registrati")
    public RedirectView registra(@RequestParam String username, @RequestParam String password) {
        Utente nuovo = new Utente(username, password);
        jsonFileService.salvaUtente(nuovo);
        return new RedirectView("/successo.html");
    }
}