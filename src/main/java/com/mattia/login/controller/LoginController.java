package com.mattia.login.controller;

import com.mattia.login.model.JsonFileService;
import com.mattia.login.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private JsonFileService jsonFileService;
    @PostMapping("/autenticazione")
    public String login(@RequestParam String username, @RequestParam String password) {
        List<Utente> utenti = jsonFileService.leggiUtenti();

        for (Utente u : utenti) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return "Login riuscito!";
            }
        }

        return "Credenziali errate.";
    }
}