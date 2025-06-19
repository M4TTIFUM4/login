package com.mattia.login.controller;

import com.mattia.login.model.Todo;
import com.mattia.login.model.User;
import com.mattia.login.service.TodoService;
import com.mattia.login.service.UserService;
import com.mattia.login.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private UserService userService;

    @Autowired
    private TodoService todoService;

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public List<Todo> getTodoPerUtente(@RequestParam String username) {
        User user = userService.findByUsername(username);
        return todoService.getTodoByUser(user);
    }

    @PostMapping("/addTodo")
    public Todo aggiungiTodo(@RequestParam String username, @RequestParam String descrizione) {
        User user = userService.findByUsername(username);
        return todoService.addTodo(user, descrizione);
    }

    @PostMapping("/{id}/completa")
    public void completa(@PathVariable Long id) {
        todoService.toggleCompletato(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoRepository.deleteById(id);
    }
}
