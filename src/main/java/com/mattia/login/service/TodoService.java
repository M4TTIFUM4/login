package com.mattia.login.service;

import com.mattia.login.model.Todo;
import com.mattia.login.model.User;
import com.mattia.login.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getTodoByUser(User user) {
        return todoRepository.findByUser(user);
    }

    public Todo addTodo(User user, String testo) {
        Todo todo = new Todo(testo, false, user);
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public void toggleCompletato(Long id) {
        Todo todo = todoRepository.findById(id).orElse(null);
        if (todo != null) {
            todo.setCompletato(!todo.isCompletato());
            todoRepository.save(todo);
        }
    }
}
