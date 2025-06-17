package com.mattia.login.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class JsonFileService {

    private final File file = new File("utenti.json");
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void salvaUtente(Utente nuovo) {
        List<Utente> utenti = leggiUtenti();
        utenti.add(nuovo);
        try {
            // Usa il writer con pretty print
            ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
            writer.writeValue(file, utenti);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Utente> leggiUtenti() {
        try {
            if (file.exists()) {
                return objectMapper.readValue(file, new TypeReference<>() {});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
