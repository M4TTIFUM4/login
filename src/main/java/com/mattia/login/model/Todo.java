package com.mattia.login.model;

import jakarta.persistence.*;

@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String testo;

    private boolean completato;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Todo() {}

    public Todo(String testo, boolean completato, User user) {
        this.testo = testo;
        this.completato = completato;
        this.user = user;
    }

    // GETTER/SETTER
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTesto() { return testo; }
    public void setTesto(String testo) { this.testo = testo; }

    public boolean isCompletato() { return completato; }
    public void setCompletato(boolean completato) { this.completato = completato; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
