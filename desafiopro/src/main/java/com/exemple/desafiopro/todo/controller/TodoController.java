package com.exemple.desafiopro.todo.controller;

import com.exemple.desafiopro.todo.dto.TodoRequest;
import com.exemple.desafiopro.todo.dto.TodoResponse;
import com.exemple.desafiopro.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponse> createTodo(@RequestBody TodoRequest request) {
        return ResponseEntity.ok(todoService.createTodo(request));
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> getAllTodos() {
        return ResponseEntity.ok(todoService.getAllTodos());
    }
}

