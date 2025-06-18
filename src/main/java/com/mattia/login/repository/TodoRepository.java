package com.mattia.login.repository;

import com.mattia.login.model.Todo;
import com.mattia.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUser(User user);
}

