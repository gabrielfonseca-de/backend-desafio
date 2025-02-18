package com.exemple.desafiopro.todo.repository;

import com.exemple.desafiopro.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {}
